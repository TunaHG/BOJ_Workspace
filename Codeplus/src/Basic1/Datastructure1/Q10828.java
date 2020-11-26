package Basic1.Datastructure1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Scanner 사용시 시간초과!
public class Q10828 {
	static int stack[];
	public static void push(int num) {
		int tmp[] = stack.clone();
		stack = new int[stack.length + 1];
		for(int i = 0; i < tmp.length; i++) {
			stack[i] = tmp[i];
		}
		stack[stack.length - 1] = num;
	}
	public static int top() {
		if(stack.length == 0)
			return -1;
		return stack[stack.length - 1];
	}
	public static int size() {
		return stack.length;
	}
	public static int pop() {
		if(stack.length == 0)
			return -1;
		int tmp[] = stack.clone();
		stack = new int[stack.length - 1];
		for(int i = 0; i < stack.length; i++) {
			stack[i] = tmp[i];
		}
		return tmp[tmp.length - 1];
	}
	public static int empty() {
		if(stack.length == 0)
			return 1;
		return 0;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		stack = new int[0];
		int N = Integer.parseInt(br.readLine());
		
		while(N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			switch(command) {
			case "push":
				int num = Integer.parseInt(st.nextToken());
				push(num);
				break;
			case "top":
				sb.append(top() + "\n");
				break;
			case "size":
				sb.append(size() + "\n");
				break;
			case "empty":
				sb.append(empty() + "\n");
				break;
			case "pop":
				sb.append(pop() + "\n");
				break;
			default:
				break;
			}
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());
	}
}
