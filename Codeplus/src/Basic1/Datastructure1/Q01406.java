package Basic1.Datastructure1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Stack;

// Scanner 쓰면안됨 + System.out.print 쓰면안됨
public class Q01406 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack<Character> leftStack = new Stack<>();
		Stack<Character> rightStack = new Stack<>();
		
		String str = br.readLine();
		for(int i = 0; i < str.length(); i++) {
			leftStack.push(str.charAt(i));
		}
		
		int N = Integer.parseInt(br.readLine());
		
		while(N-- > 0) {
			String command = br.readLine();
			switch(command.charAt(0)) {
			case 'P':
				char addStr = command.charAt(2);
				leftStack.push(addStr);
				break;
			case 'L':
				if(!leftStack.isEmpty())
					rightStack.push(leftStack.pop());
				break;
			case 'D':
				if(!rightStack.isEmpty())
					leftStack.push(rightStack.pop());
				break;
			case 'B':
				if(!leftStack.isEmpty())
					leftStack.pop();
				break;
			}
		}
		
		while(!leftStack.isEmpty()) {
			rightStack.push(leftStack.pop());
		}
		
		while(!rightStack.isEmpty()) {
			bw.write(rightStack.pop());
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
