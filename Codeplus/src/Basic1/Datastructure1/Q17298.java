package Basic1.Datastructure1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q17298 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] A = new int[N];
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(input[i]);
		}
		int[] NGE = new int[N];
		
		Stack<Integer> stack = new Stack<>();
		
		stack.push(0);
		for(int i = 1; i < N; i++) {
			while(!stack.isEmpty() && A[i] > A[stack.peek()]) {
				NGE[stack.pop()] = A[i];
			}
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			NGE[stack.pop()] = -1;
		}
		
		for(int i = 0; i < N; i++) {
			sb.append(NGE[i] + " ");
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());
	}

}
