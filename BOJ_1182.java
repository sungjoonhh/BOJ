import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		//Scanner sc1 = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		int[] arr = new int[n];
		int result = 0;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		//i는 0000~1111까지
		for (int i = 1; i < 1 << n; i++) {
			//System.out.println(Integer.toBinaryString(i));

			int bit = i;
			//0000 을 
			//bit!=0 은 도중에 할게 없으면 컷 0000111 일떄 1뽑고 난후 0이므로 돌 필요가 없다.
			for (int j = 0; bit != 0; j++, bit >>= 1) {


				//첫번째 자리가 0이면 j는 구할필요가 없다. ex) 10010일때 j의 자리는 0이므로 뽑을 필요가 없기 때문이다.
				if ((1 & bit) == 0){
					continue;
				}
				sum = sum + arr[j];
			}
			if (sum == s) {
				result++;
			}
			sum = 0;
		}
		System.out.println(result);

	}

}