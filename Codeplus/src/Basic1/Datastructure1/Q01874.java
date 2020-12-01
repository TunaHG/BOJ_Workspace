package Basic1.Datastructure1;

import java.util.Stack;
import java.util.Scanner;

public class Q01874 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		
		int idx = 1;
		for(int i = 0; i < N; i++) {
			int num = scan.nextInt();
			while(true) {
				if(stack.empty()) {
					stack.push(idx++);
					sb.append("+\n");
				}
				if(stack.peek().equals(num)) {
					stack.pop();
					sb.append("-\n");
					break;
				}
				else if(stack.peek() > num) {
					System.out.println("NO");
					scan.close();
					return;
				}
				stack.push(idx++);
				sb.append("+\n");
			}
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());
		scan.close();
	}

}
