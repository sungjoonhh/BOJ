import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int zero;
	static int one;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		// Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testcase = 0; testcase < T; testcase++) {
			int N = sc.nextInt();
			divide(N);

		}
	}

	static void divide(int x) {
		if(x%3==0){
			x = x/3;
		}
		else if(x%2==0){
			x = x/2;
		}
		else{
			x--;
		}
		
		
	}
}
