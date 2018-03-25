import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

	static BufferedReader br;

	public static void main(String[] args) throws Exception {

		br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split("");
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += Integer.parseInt(str[i]);
		}
		System.out.println(sum);

	}
}