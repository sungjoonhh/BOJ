import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String args[]) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String output;
		int count = 0;
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			output = br.readLine();
			output += output;

			if (output.contains(str)) {
				count++;
			}
		}
		System.out.println(count);

	}
}