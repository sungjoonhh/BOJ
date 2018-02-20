import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String args[]) throws Exception {
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		String[] str = br.readLine().split(" ");

		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		str = br.readLine().split(" ");
		
		//양수와 음수를 나눠서 계산
		Queue<Integer> pos_q = new PriorityQueue<Integer>((x, y) -> y - x);
		Queue<Integer> neg_q = new PriorityQueue<Integer>();

		for (int i = 0; i < N; i++) {
			if (Integer.parseInt(str[i]) > 0) {
				pos_q.add(Integer.parseInt(str[i]));
			} else {
				neg_q.add(Integer.parseInt(str[i]));

			}
		}
		int element;
		int max = 0;
		int sum = 0;
		//양수가 없을때까지 
		while (!pos_q.isEmpty()) {
			//한번의 이동에 M개의 책을 가져올 수 있다.
			for (int i = 0; i < M; i++) {
				//M개씩 가져오다보면 마지막에 M개보다 부족 할 수 있기 때문에 continue 함수를 써서 넘어간다.
				//continue 안하면 에러
				if (pos_q.isEmpty())
					continue;
				element = pos_q.poll();

				//처음 가는 곳이 제일 거리가 먼곳이므로 이때만 거리를 더해주면 된다.
				if (i == 0) {
					sum += Math.abs(element);
					if (Math.abs(element) > max) {
						max = Math.abs(element);
					}
				}
			}
		}
		//음수 일때
		while (!neg_q.isEmpty()) {
			//한번의 이동에 M개의 책을 가져올 수 있다.
			for (int i = 0; i < M; i++) {
				//M개씩 가져오다보면 마지막에 M개보다 부족 할 수 있기 때문에 continue 함수를 써서 넘어간다.
				//continue 안하면 에러
				if (neg_q.isEmpty())
					continue;
				element = neg_q.poll();
				
				//처음 가는 곳이 제일 거리가 먼곳이므로 이때만 거리를 더해주면 된다.
				if (i == 0) {
					sum += Math.abs(element);
					if (Math.abs(element) > max) {
						max = Math.abs(element);
					}
				}
			}
		}
		System.out.println(sum * 2 - max);
	}
}