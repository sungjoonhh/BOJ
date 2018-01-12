import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	static boolean[][] arr;
	static int[][] kevin;
	static int[] bacon;
	static int n;
	static int m;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		String str = br.readLine();
		int size = str.length();
		Integer[] arr = new Integer[size];
		for (int i = 0; i < size; i++) {
			arr[i] = str.charAt(i) - '0';
		}
		
		Arrays.sort(arr,new Comparator<Integer>(){
			@Override
			public int compare(Integer x, Integer y){
				return Integer.compare(y, x);
			}
		});
		for(Integer i:arr){
			System.out.print(i);
		}
		
	}

}