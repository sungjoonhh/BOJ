import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Set;

public class Main {

	private static Scanner sc;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		sc = new Scanner(new FileInputStream("input.txt"));
		// sc = new Scanner(System.in);
		int n = sc.nextInt();

		Set<String> set = new HashSet<>();	//set을 사용함
		for (int i = 0; i < n; i++) {
			String name = sc.next();
			String commute = sc.next();

			if (commute.equals("enter")) {	//enter면 set에 추가를 하고
				set.add(name);
			} else {						//leave면 set에서 삭제를 한다. 물론 leave밖에 없기에 else문을 사용했다.
				set.remove(name);
			}
		}
		List<String> array = new ArrayList<String>(set);	//sort와 ListIterator를 사용하기 위해 set --> list 작업을 했다.
		Collections.sort(array);	//정렬
		ListIterator<String> iter = array.listIterator(array.size());	//ListInterator를 사용해서 반대로 탐색

		
		//Iterator 사용
		while (iter.hasPrevious()) {
			System.out.println(iter.previous());
		}

	}

}