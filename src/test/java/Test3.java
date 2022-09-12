import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Test3 {
	
	public static Set<BigInteger> getAllDivisor(BigInteger data){
		Set<BigInteger> d = new HashSet<BigInteger>();
		BigInteger temp = data.sqrt();
		BigInteger i=BigInteger.ONE;
		while(i.compareTo(temp) <= 0) {
			if(data.mod(i).equals(BigInteger.ZERO)) {
				if(data.divide(i).equals(BigInteger.ONE))
					d.add((i.multiply(data)));
				else {
					d.add(i.multiply(data));
					d.add(data.multiply(data).divide(i));
				}
			}
			i = i.add(BigInteger.ONE);
		}
		return d;
	}
	
	public static void main(String[] args) throws java.lang.Exception {
		BigInteger MOD = BigInteger.valueOf(7000000000L);
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(T>0) {
			int a = sc.nextInt();
			int k = sc.nextInt();
			BigInteger n = BigInteger.valueOf(a);
			
			Set<BigInteger> data = new HashSet<BigInteger>();
			Map<BigInteger, Boolean> map = new HashMap<BigInteger, Boolean>();
			data.add(n);
			while(k>0) {
				Set<BigInteger> temp = new HashSet<BigInteger>();
				for(BigInteger s : data) {
					if(map.get(s) == null)
						temp.addAll(getAllDivisor(s));
					map.put(s, true);
				}
				data.addAll(temp);
				k--;
			}
			BigInteger sum = BigInteger.ZERO;
			for(BigInteger s : data)
				sum = sum.add(s);
			System.out.println(sum.mod(MOD).longValue());
			T--;
		}
		sc.close();
	}
}
