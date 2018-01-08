import java.io.FileInputStream;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		Set<String> not_listen = new HashSet<String>();
		Set<String> not_lookisten = new HashSet<String>();

		int n = sc.nextInt();
		int m = sc.nextInt();

		for (int i = 0; i < n; i++) {
			String tmp = sc.next();
			not_listen.add(tmp);
		}
		for (int i = 0; i < m; i++) {
			String not_look = sc.next();

			for (int j = 0; j < m; j++) {
				if (not_listen.contains(not_look) == true)
					not_lookisten.add(not_look);
			}
		}
		String[] Result = not_lookisten.toArray(new String[not_lookisten.size()]);
		Arrays.sort(Result);

		for (int i = 0; i < Result.length; i++)
			System.out.println(Result[i]);
	}
}
