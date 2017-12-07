import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int A_bark = sc.nextInt();
		int A_rest = sc.nextInt();

		int B_bark = sc.nextInt();
		int B_rest = sc.nextInt();

		int[] arr = new int[3];
		int[] result = new int[3];
		for (int i = 0; i < 3; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < 3; i++) {
			if (arr[i] % (A_bark + A_rest) <= A_bark && 0 < arr[i] % (A_bark + A_rest)) {
				result[i]++;
			}
			if (arr[i] % (B_bark + B_rest) <= B_bark && 0 < arr[i] % (B_bark + B_rest)) {
				result[i]++;
			}
		}
		for(int i=0; i<3; i++){
		System.out.println(result[i]);
		}
	}

}