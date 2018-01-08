import java.io.FileInputStream;
import java.util.*;
import java.util.stream.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		// Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		Queue<Integer> queue = new LinkedList<Integer>();

		int[] arr = new int[N];
		int cnt = 0;
		for (int i = 1; i < N + 1; i++) {
			queue.add(i);
		}

		int jsp = 0;
		while (!queue.isEmpty()) {
			if ((jsp + 1) % M == 0) {
				arr[cnt++] = queue.poll();

			}

			else {
				queue.add(queue.poll());
			}

			jsp++;
		}
		System.out.print("<");
		for (int i = 0; i < N - 1; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.print(arr[N - 1]);

		System.out.print(">");

	}

}