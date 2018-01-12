import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static boolean[][] arr;
	static int[][] kevin;
	static int[] bacon;
	static int n;
	static int m;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		// Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		Set<String> hashset = new HashSet<String>();
		for (int i = 0; i < N; i++) {
			hashset.add(sc.next());
		}
		int size = hashset.size();
		int end = size;

		String[] arr = new String[size];
		int[] length = new int[size];
		hashset.toArray(arr);

		Arrays.sort(arr);

		Arrays.sort(arr, (s1, s2) -> Integer.compare(s1.length(), s2.length()));

		
		//System.out.println(Integer.compare(1, 2));
		for (String a : arr) {
			System.out.println(a);
		}
	}

}