package Basic1.Datastructure1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q01918 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		
		// 우선순위에 따라서 자신의 우선순위보다 같거나 높은건 전부 빼기
		for(int i = 0; i < str.length(); i++) {
			switch(str.charAt(i)) {
			case '+':
				while(!stack.isEmpty() && stack.peek() != '(')
					sb.append(stack.pop());
				stack.push('+');
				break;
			case '-':
				while(!stack.isEmpty() && stack.peek() != '(')
					sb.append(stack.pop());
				stack.push('-');
				break;
			case '/':
				while(!stack.isEmpty() && stack.peek() != '(' && stack.peek() != '+' && stack.peek() != '-')
					sb.append(stack.pop());
				stack.push('/');
				break;
			case '*':
				while(!stack.isEmpty() && stack.peek() != '(' && stack.peek() != '+' && stack.peek() != '-')
					sb.append(stack.pop());
				stack.push('*');
				break;
			case '(':
				stack.push('(');
				break;
			case ')':
				while(!stack.isEmpty()) {
					if(stack.peek() == '(') {
						stack.pop();
						break;
					}
					sb.append(stack.pop());
				}
				break;
			default:
				sb.append(str.charAt(i));
				break;
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb.toString());
	}

}
