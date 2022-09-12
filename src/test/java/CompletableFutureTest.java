import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {
	public static void main(String[] args) {
		System.out.println("Starting process......");
		CompletableFuture.supplyAsync(()->longNetwork(5))
		.thenAccept(System.out::println);
//		System.out.println("process finished");
	}
	
	public static int longNetwork(int value) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return value*10;
	}
}
