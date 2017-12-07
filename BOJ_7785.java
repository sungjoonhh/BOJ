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

		Set<String> set = new HashSet<>();	//set�� �����
		for (int i = 0; i < n; i++) {
			String name = sc.next();
			String commute = sc.next();

			if (commute.equals("enter")) {	//enter�� set�� �߰��� �ϰ�
				set.add(name);
			} else {						//leave�� set���� ������ �Ѵ�. ���� leave�ۿ� ���⿡ else���� ����ߴ�.
				set.remove(name);
			}
		}
		List<String> array = new ArrayList<String>(set);	//sort�� ListIterator�� ����ϱ� ���� set --> list �۾��� �ߴ�.
		Collections.sort(array);	//����
		ListIterator<String> iter = array.listIterator(array.size());	//ListInterator�� ����ؼ� �ݴ�� Ž��

		
		//Iterator ���
		while (iter.hasPrevious()) {
			System.out.println(iter.previous());
		}

	}

}