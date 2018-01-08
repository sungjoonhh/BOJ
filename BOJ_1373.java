import java.io.FileInputStream;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		// Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		String str = sc.next();
		int length = str.length();
		char[] e = null;
		if (length % 3 == 1) {
			length = length + 2;
			e = new char[length];
			e[0] = '0';
			e[1] = '0';
			for (int i = 2; i < length; i++) {
				e[i] = str.charAt(i - 2);
			}

		} else if (length % 3 == 2) {
			length = length + 1;
			e = new char[length];
			e[0] = '0';
			for (int i = 1; i < length; i++) {
				e[i] = str.charAt(i - 1);
			}

		} else {
			e = new char[length];
			e = str.toCharArray();

		}
		for (int i = 0; i < length; i += 3) {
			System.out.print((e[i] - '0') * 4 + (e[i + 1] - '0') * 2 + (e[i + 2] - '0') * 1);
		}
	}
}
