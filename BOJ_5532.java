import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		// Scanner sc1 = new Scanner(System.in);
		int L = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();
		
		int lang;
		int math;
		
		if(A%C==0){
			lang = A/C;
		}
		else{
			lang = (A/C)+1;
		}
		
		if(B%D==0){
			math = B/D;
		}
		else{
			math = (B/D)+1;
		}

		System.out.println(L-Math.max(lang, math));
		
	}
}