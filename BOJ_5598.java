import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		String str = sc.next();

		int size = str.length();
		int[] arr = new int[size];
		int[] decrypt = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = str.charAt(i);
			if(arr[i]-68<0){
				System.out.print((char)(arr[i]+23));
			}
			else{
				System.out.print((char)(arr[i]-3));
			}
			
		
		}

	}

}
