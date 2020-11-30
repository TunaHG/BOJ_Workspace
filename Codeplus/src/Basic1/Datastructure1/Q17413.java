package Basic1.Datastructure1;

import java.util.Deque;
import java.util.LinkedList;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q17413 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Deque<Character> deque = new LinkedList<>();
		
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		
		for(int i = 0; i < str.length(); i++) {
			if(flag && str.charAt(i) != '>') {
				sb.append(str.charAt(i));
				continue;
			}
			if(str.charAt(i) == '<') {
				while(!deque.isEmpty()) {
					sb.append(deque.pollLast());
				}
				sb.append(str.charAt(i));
				flag = true;
			}
			else if(str.charAt(i) == '>') {
				sb.append(str.charAt(i));
				flag = false;
			}
			else if(str.charAt(i) == ' ') {
				while(!deque.isEmpty()) {
					sb.append(deque.pollLast());
				}
				sb.append(' ');
			}
			else {
				deque.add(str.charAt(i));
			}
		}
		while(!deque.isEmpty()) {
			sb.append(deque.pollLast());
		}
		System.out.println(sb.toString());
	}

}
