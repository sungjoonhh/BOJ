import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		long[] file = new long[N];
		for(int i=0; i<N; i++){
		 file[i] = Integer.parseInt(str[i]);
		}
		
		long cluster = Integer.parseInt(br.readLine());
		long disk = 0;
		
		for (int i = 0; i < N; i++) {
			if ((file[i] % cluster) == 0) {
				disk += (file[i] / cluster) * cluster;
			} else {
				disk += ((file[i] / cluster) + 1) * cluster;

			}
		}
		System.out.println(disk);

	}
}