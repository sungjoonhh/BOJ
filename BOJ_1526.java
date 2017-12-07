import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		// Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int[] flags = new int[x+1];
		
		
		int result = 0;
		String a;
		for (int i = x; i > 0; i--) {
			a = Integer.toString(i);
			for (int j = 0; j < a.length(); j++) {
				if (a.charAt(j) == '4' || a.charAt(j) == '7') {
					flags[i] = 1;
				}
				else{
					flags[i] = 0;
					break;
				}
			}
		}
		
		for(int i=x; i>3; i--){
			if(flags[i]==1){
				System.out.println(i);
				break;
			}
		}
	}

}
