import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		// Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int count = 0;
		while(n!=m){
			if(n*2 <m){
				n = n*2;
			}
			else{
				if(n<m){
					n = n+1;
				}
				else{
					n = n-1;
				}
			}
			count++;
		}
		System.out.println(count);
		
	}

}
