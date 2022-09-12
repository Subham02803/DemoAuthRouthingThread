package com.example.DemoAuthRouthingThread.threadtest.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.DemoAuthRouthingThread.threadtest.dto.CSVParseDto;
import com.example.DemoAuthRouthingThread.threadtest.model.AcountDetails;
import com.example.DemoAuthRouthingThread.threadtest.model.StockDetails;
import com.example.DemoAuthRouthingThread.threadtest.model.User;

@Service
public class StockService {

	Logger log = LoggerFactory.getLogger(StockService.class);

	@Autowired
	private UserService userService;

	@Autowired
	private AcountDetailsService acountDetailsService;

	@Autowired
	private StockDetailsService stockDetailsService;

	public List<CSVParseDto> getAlStockUserDetails() {
		log.info("in getAlStockUserDetails service method by " + Thread.currentThread().getName());
		try {
			long start = System.currentTimeMillis();
			// get all users
			List<User> users = userService.getAllUsers();
			List<Integer> userIds = users.stream().map(x -> x.getId()).collect(Collectors.toList());

			CompletableFuture<Map<Integer, AcountDetails>> futureAccountDetails = CompletableFuture.supplyAsync(() -> {
				return getAccountDetails(userIds);
			});

			CompletableFuture<Map<Integer, StockDetails>> futureStockDetails = CompletableFuture.supplyAsync(() -> {
				return getStockDetails(userIds);
			});

			Map<Integer, AcountDetails> mapAccountDetails = futureAccountDetails.get();
			Map<Integer, StockDetails> mapStockDetails = futureStockDetails.get();
			// construct output
			List<CSVParseDto> outputDto = new ArrayList<CSVParseDto>();
			for (User user : users) {
				outputDto.add(new CSVParseDto(user.getId(), user.getName(), user.getEmail(),
						mapAccountDetails.get(user.getId()).getCreditCard(),
						mapAccountDetails.get(user.getId()).getCreditCardType(),
						mapStockDetails.get(user.getId()).getStockIndustry(),
						mapStockDetails.get(user.getId()).getStockMarket(),
						mapStockDetails.get(user.getId()).getAmount()));
			}
			long end = System.currentTimeMillis();
			log.info("Total time to get data : " + (end - start) + " by " + Thread.currentThread().getName());
			return outputDto;
		} catch (Exception e) {
			log.error("error in getAlStockUserDetails : ", e);
		}
		return null;
	}

	public Map<Integer, AcountDetails> getAccountDetails(List<Integer> userIds) {
		// get all accounts by userIds
		List<AcountDetails> accountDetails = acountDetailsService.getAllAccountsByUserIds(userIds);
		return accountDetails.stream().collect(Collectors.toMap(x -> x.getUser().getId(), Function.identity()));
	}

	public Map<Integer, StockDetails> getStockDetails(List<Integer> userIds) {
		// get all stocks by userIds
		List<StockDetails> stockDetails = stockDetailsService.getAllStocksByUserIds(userIds);
		return stockDetails.stream().collect(Collectors.toMap(x -> x.getUser().getId(), Function.identity()));
	}

	public void saveStockData(MultipartFile file) throws Exception {
		try {
			long start = System.currentTimeMillis();
			List<CSVParseDto> csvParsers = parseCSV(file);
			log.info("saving user size - " + csvParsers.size() + " by " + Thread.currentThread().getName());
			// collect all users
			List<User> users = csvParsers.stream().map(p -> new User(p.getName(), p.getEmail()))
					.collect(Collectors.toList());
			// save all users
			users = userService.saveUsers(users);

			// map users by name for saving account details and stocks
			Map<String, User> mapUser = users.stream().collect(Collectors.toMap(x -> x.getName(), Function.identity()));

			// collect all account details
			List<AcountDetails> accountDetails = csvParsers.stream()
					.map(p -> new AcountDetails(p.getCreditCard(), p.getCreditCardType(), mapUser.get(p.getName())))
					.collect(Collectors.toList());
			// save all account details
			acountDetailsService.saveAllAccounts(accountDetails);

			// collect all stock details
			List<StockDetails> stockDetails = csvParsers.stream().map(p -> new StockDetails(p.getStockIndustry(),
					p.getStockMarket(), p.getAmount(), mapUser.get(p.getName()))).collect(Collectors.toList());
			// save all stock details
			stockDetailsService.saveAllStocks(stockDetails);

			long end = System.currentTimeMillis();
			log.info("Total time to save data : " + (end - start));
		} catch (Exception e) {
			log.error("error while saving stock details : ", e);
			throw new Exception("error while saving stock details : ", e);
		}
	}

	private List<CSVParseDto> parseCSV(MultipartFile file) throws Exception {
		List<CSVParseDto> csvParsers = new ArrayList<CSVParseDto>();
		Map<String, Boolean> csvMap = new HashMap<String, Boolean>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
			String line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				if (csvMap.containsKey(data[0]))
					continue;
				csvMap.put(data[0], true);
				BigDecimal amount = new BigDecimal(data[4].substring(1));
				csvParsers.add(new CSVParseDto(data[0], data[1], data[2], data[3], data[5], data[6], amount));
			}
		} catch (Exception e) {
			log.error("Error while parsing file : ", e);
			throw new Exception("Error while parsing file : ", e);
		}
		return csvParsers;
	}
}
