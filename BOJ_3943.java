
import java.util.Scanner;

public class Main {


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int Testcase = sc.nextInt();

		for (int i = 0; i < Testcase; i++) {
			int n = sc.nextInt();
			int max = n;
			while(n!=1){
				if(n%2==0){
					n = n/2;
				}
				else{
					n = n*3 +1;
				}
				max = Math.max(max,n);
			}
			
			System.out.println(max);
		}
	}
}