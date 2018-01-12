import java.io.FileInputStream;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		// Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int TestCase = sc.nextInt();
		int sum;
		sc.nextLine();
		for (int T = 0; T < TestCase; T++) {
			sum = 0;
			String str = sc.nextLine();
			int length = str.length();
			int[] arr = new int[length];
			for (int i = 0; i < length; i++) {
				if(str.charAt(i)==' ')continue;
				arr[i] = str.charAt(i) - 64;
				//System.out.print(str.charAt(i)+" ");
				//System.out.println(arr[i]);
				sum += arr[i];
			}
			if(sum==100){
				System.out.println("PERFECT LIFE");
			}
			else{
				System.out.println(sum);
			}
		}

	}

}
