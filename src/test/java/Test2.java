import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Test2 {
	
	static class Pokemon{
		int id;
		long power;
	}

	public static void main(String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in); 
		int T = sc.nextInt();
		while(T > 0) {
			int n = sc.nextInt();
			Pokemon[] ground = new Pokemon[n];
			Pokemon[] water = new Pokemon[n];
			for(int i=0;i<n;i++) {
				ground[i] = new Pokemon();
				ground[i].id = i;
				ground[i].power = sc.nextLong();
			}
			for(int i=0;i<n;i++) {
				water[i] = new Pokemon();
				water[i].id = i;
				water[i].power = sc.nextLong();
			}
			Arrays.sort(ground, (o1,o2)->Long.compare(o1.power,o2.power));
			Arrays.sort(water, (o1,o2)->Long.compare(o1.power,o2.power));
			
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			
			for(int i=0;i<n;i++) {
				map.put(ground[i].id, i);
			}
			
			int count=0;
			for(int i=0;i<n;i++) {
				int power = map.get(water[i].id) + i;
				map.put(water[i].id, power);
				if(power>=n-1)
					count++;
			}
			System.out.println(count);
			T--;
		}
		sc.close();
	}
}
