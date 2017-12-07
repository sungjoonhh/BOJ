import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		Scanner sc1 = new Scanner(System.in);
		int Testcase = sc.nextInt();

		for (int i = 0; i < Testcase; i++) {
			String str = sc.next();
			//System.out.println(str);

			int size = str.length();

			if (size % 2 == 0) {
				for (int j = 0; j < size/2; j++) {
					System.out.print(str.charAt(j*2));
				}
				System.out.println();
				for (int j = 0; j < size/2; j++) {
					System.out.print(str.charAt(j*2+1));
				}
				System.out.println();
			} else {
				for (int j = 0; j < size; j++) {
					System.out.print(str.charAt((j*2)%size));
				}
				System.out.println();
				for (int j = 0; j < size; j++) {
					System.out.print(str.charAt((j*2+1)%size));
				}
				System.out.println();
			}

		}
	}
}