import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		// Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n != 0) {

			int[] arr = new int[n];

			Queue<int[]> q = new LinkedList();
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}

			for (int i = 0; i < 1 << n; i++) {
				// System.out.print(i + " : ");

				int bit = i;
				int cnt = 0;
				int[] temp = new int[6];
				for (int j = 0; bit != 0; j++, bit >>= 1) {

					if ((1 & bit) == 0) {
						continue;
					}
					temp[cnt++] = arr[j];
					if (cnt == 6) {
						//Arrays.sort(temp);
						q.add(temp);
						for (int t = 0; t < 6; t++) {
							//System.out.print(temp[t] + " ");
						}
						//System.out.println();
						break;
					}
				}
			}

			int[] lotto = new int[6];
			int[][] result = new int[100][6];
			int num = 0;
			while (!q.isEmpty()) {
				lotto = q.poll();

				int count = 0;
				boolean duplicate = false;
				for(int i=0; i<num; i++){
					for(int j=0; j<6; j++){
						if(result[i][j]==lotto[j]){
							//System.out.println(result[i][j] +"  "+lotto[j]);
							count++;
						}
					}
					if(count==6){
						duplicate = true;
					}
					count = 0;
				}
				if(!duplicate){
					for (int i = 0; i < 6; i++) {
						result[num][i] = lotto[i];
					}
					num++;
				}
			
			
			}

			
			
			
			
			
			for (int i = 0; i < num; i++) {
				for (int j = 0; j < 6; j++) {
					System.out.print(result[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			n = sc.nextInt();

		}

	}

}
