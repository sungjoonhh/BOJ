import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		Scanner sc1 = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		int num = 0;
		int[] arr = new int[N];
		int count = 0;
		while(arr[num]!=M-1){
			count++;
			arr[num]++;
			if(arr[num]%2==0){
				num = (num-L)%N;
				
				if(num <0){
					num = N+num;
				}
			}
			else{
				num = (num+L)%N;
			}
		}
		System.out.println(count);
	}

}
