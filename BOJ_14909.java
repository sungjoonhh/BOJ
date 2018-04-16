import java.io.BufferedReader;
import java.io.InputStreamReader;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str= br.readLine().split(" ");
		int count = 0;
		for(int i=0; i<str.length; i++){
			if(Integer.parseInt(str[i])>0) count++;
		}
		System.out.println(count);
		
	}
}