import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Comparator;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();

		}
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] start, int[] end) {
				//start[0], end[0] �迭�� arr[][] �� ù��° ����(���۽ð�)�̴�.
				//start[1], end[0] �迭�� arr[][] �� �ι�° ����(����ð�)�̴�.
				if(start[1]==end[1]){
					//���� ���ϴ� ���� ����ð��� ���� ��� ���۽ð����� �����Ѵ�.
					return Integer.compare(start[0], end[0]);
				}
				//����ð��� ���� �����Ѵ�.
				return Integer.compare(start[1], end[1]);
			}

		});
		

		int count = 0;	// �ִ밪 ���� 
		int end = -1;	// �������� �ð��� ���� ����
		for (int i = 0; i < N; i++) {
			//���� ���۽ð��� ���� ����ð����� ���� ��� 
			if (arr[i][0] >= end) {
				//System.out.println(arr[i][0] + " " + arr[i][1]);
				end = arr[i][1];	//���� ����ð��� ���� ���۽ð��� ���ϱ����� ���� 
				count++;
			}
		}
		System.out.println(count);
	}
}
