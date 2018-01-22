import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str[] = new String[2];
		str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		long[] arr = new long[N + 1];
		String[] string_arr = new String[N + 1];
		string_arr = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(string_arr[i]);
		}
		Arrays.sort(arr);

		System.out.println(arr[M - 1]);
	}

}