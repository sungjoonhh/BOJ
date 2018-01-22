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
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		int result =(((V-N)%(N-M))!=0?((V-N)/(N-M)+2):((V-N)/(N-M)+1));
		System.out.println(result);
	}

}
