package Basic1.Datastructure1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q10799 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		
		String str = br.readLine();
		
		int bar = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(') {
				if(str.charAt(i + 1) == ')') {
					bar += stack.size();
					i++;
				}
				else {
					stack.push('(');
				}
			}
			else {
				bar += 1;
				stack.pop();
			}
		}
		System.out.println(bar);
	}

}
