import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static int[] arr;
	static boolean[] visited;
	static int last;
	static ArrayList<Integer> list;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		arr = new int[N + 1];
		visited = new boolean[N + 1];
		list = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 1; i <= N; i++) {
			visited[i] = true;
			last = i;
			DFS(i);
			visited[i] = false;
		}
		Collections.sort(list);
		System.out.println(list.size());
		for (int i : list) {
			System.out.println(i);
		}
	}

	public static void DFS(int i) {
		if (!visited[arr[i]]) {
			visited[arr[i]] = true;
			DFS(arr[i]);
			visited[arr[i]] = false;
		}
		if (arr[i] == last) {
			list.add(last);
		}
	}
}