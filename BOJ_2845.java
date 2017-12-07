import java.io.FileInputStream;
import java.util.Scanner;

public class Main {


	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		// Scanner sc1 = new Scanner(System.in);
		int x = sc.nextInt();

		int n = sc.nextInt()*x;

		for (int i = 0; i < x; i++) {
			int c= sc.nextInt();
			System.out.print(c-n + " ");
		}
	}
}