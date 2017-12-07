import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		// Scanner sc1 = new Scanner(System.in);

		int x = sc.nextInt();
		int y = x;
		int[] arr = new int[x];
		for (int i = 0; i < x; i++) {
			arr[i] = i + 1;
		}

		int i = 0;
		boolean flags = true;
		while (y != 1) {
			if (flags) {
				if (arr[i] != 0) {
					// 삭제부분
					System.out.println(arr[i] + "는 삭제합니다.");
					arr[i] = 0;
					i++;
					y--;
					i = i % x;
					flags = false;
				} else {
					i++;
					i = i % x;
				}
			}
			if (!flags) {
				if (arr[i] != 0) {
					System.out.println(arr[i] + "는 뒤로 넘어갑니다.");
					i = i + 1;
					i = i % x;
					flags = true;
				} else {
					i++;
					i = i % x;
				}
			}
		}

		for(int t=0; t<x; t++){
			if(arr[t]!=0){
				System.out.println(arr[t]);
				break;
			}
	}
	}
}
