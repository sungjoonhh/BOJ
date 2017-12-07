	import java.io.FileInputStream;
	import java.util.LinkedList;
	import java.util.Queue;
	import java.util.Scanner;
	import java.util.Stack;
	
	public class Main {
	
		public static void main(String[] args) throws Exception {
			// TODO Auto-generated method stub
	
			// Scanner sc = new Scanner(System.in);
			Scanner sc = new Scanner(new FileInputStream("input.txt"));
			int n = sc.nextInt();
			sc.nextLine();
			Stack<Integer> stack = new Stack<Integer>();
			for (int i = 0; i < n; i++) {
				String str = sc.nextLine();
	
				String instruction[] = str.split(" ");
	
				switch (instruction[0]) {
				case "push":
					stack.push(Integer.parseInt(instruction[1]));
					break;
	
				case "pop":
					if(stack.isEmpty()){
						System.out.println(-1);
					}
					else{
						System.out.println(stack.pop());
					}
					break;
	
				case "size":
	
						System.out.println(stack.size());
					break;
	
				case "empty":
					if(stack.isEmpty()){
						System.out.println(1);
					}
					else{
						System.out.println(0);
					}
					break;
	
				case "top":
					if(stack.isEmpty()){
						System.out.println(-1);
					}
					else{
						System.out.println(stack.peek());
					}
					break;
	
				}
	
			}
	
		}
	
	}