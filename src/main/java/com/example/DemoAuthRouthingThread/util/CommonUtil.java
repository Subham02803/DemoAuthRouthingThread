package com.example.DemoAuthRouthingThread.util;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CommonUtil {
	public static HttpResponse sendHttpReqAndCheckThresholds(String url, String method, String body) {
		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder(
				       URI.create("localhost:8081/getAllUsersStock"))
					   .header("accept", "application/json")
					   .build();
			//HttpResponse response = client.send(request, new JsonBodyHandler<>(APOD.class));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpResponse httpResponse = null;
		
		return httpResponse;
	}
}
