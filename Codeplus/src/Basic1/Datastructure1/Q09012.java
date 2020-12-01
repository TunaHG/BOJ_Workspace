package Basic1.Datastructure1;

import java.util.Stack;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q09012 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> stack;
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		A: while(N-- > 0) {
			stack = new Stack<String>();
			String[] line = br.readLine().split("");
			for(int i = 0; i < line.length; i++) {
				switch(line[i]) {
				case "(":
					stack.push("(");
					break;
				case ")":
					if(!stack.empty() && stack.peek().equals("(")) {
						stack.pop();
						break;
					}
					else {
						sb.append("NO\n");
						continue A;
					}
				}
			}
			if(stack.empty())
				sb.append("YES\n");
			else
				sb.append("NO\n");
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());
	}

}
