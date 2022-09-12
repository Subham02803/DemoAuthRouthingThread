
public class Test {
	public static void main(String[] args) {
		int[] arr = {6,3,2,0,1,6,5,2 };
		int[] arr2 = {1,1,2};
		
		int[] ar3 = {5,1,2,1,2};
		
		int[] arr4 = {4,0};
		
		if(arr.length <=2)
			System.out.println("No output");
			
		int i=1;
		int rightSum = 0;
		int leftSum = arr[0];
		for(int j=2;j<arr.length;j++)
			rightSum += arr[j];
		
		for(i=1;i<arr.length-1;i++) {
			if(leftSum == rightSum)
				break;
			leftSum += arr[i];
			rightSum = rightSum - arr[i+1];
		}
		
		if(i < arr.length-1)
			System.out.println(arr[i]);
		else
			System.out.println("No output");
		
	}
	
}
