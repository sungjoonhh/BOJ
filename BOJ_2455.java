import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		// Scanner sc1 = new Scanner(System.in);
		int sum = 0;
		int max = 0;
		for(int i=0; i<4; i++){
			sum = sum - sc.nextInt();
			if(sum > max){
				max = sum;
			}
			
			sum = sum + sc.nextInt();
			if(sum > max){
				max = sum;
			}
		}
		System.out.println(max);
	}
}