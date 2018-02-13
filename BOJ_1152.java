import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		String[] str = br.readLine().split(" ");
		int count = str.length;
		for (int i = 0; i < str.length; i++) {
			if (str[i].equals("")) {
				count--;
			}
		}
		System.out.println(count);
	}
}
