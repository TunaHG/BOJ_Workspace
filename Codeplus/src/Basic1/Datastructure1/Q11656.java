package Basic1.Datastructure1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.ArrayList;

public class Q11656 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Character> stack = new Stack<>();
		
		String input = br.readLine();
		for(int i = 0; i < input.length(); i++) {
			stack.push(input.charAt(i));
		}
		ArrayList<String> result = new ArrayList<>();
		
		String suffix = String.valueOf(stack.pop());
		result.add(suffix);
		A: while(!stack.isEmpty()) {
			suffix = stack.pop() + suffix;
			B: for(int i = 0; i < result.size(); i++) {
				for(int j = 0; j < result.get(i).length(); j++) {
					if(j > suffix.length()) {
						result.add(i, suffix);
						continue A;
					}
					else if(suffix.charAt(j) < result.get(i).charAt(j)) {
						result.add(i, suffix);
						continue A;
					}
					else if(suffix.charAt(j) > result.get(i).charAt(j))
						continue B;
				}
			}
			result.add(suffix);
		}
		
		for(int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

}
