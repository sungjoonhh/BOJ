import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		//Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();

		int[] arr ={0,1,0,0};
		boolean flag = true;
		for (int i = 0; i < x; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			int temp = 0;
			temp = arr[a];
			arr[a] = arr[b];
			arr[b] = temp;
		}

		for (int i = 0; i < arr.length; i++) {
			
			if(arr[i] == 1){
				System.out.println(i+1);
				flag = false;
				break;
			}
		}
		if(flag){
			System.out.println(-1);
		}
	}

}
