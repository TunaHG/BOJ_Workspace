package Basic1.Datastructure1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

public class Q17299 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Map<Integer, Integer> map = new HashMap<>();
		Stack<Integer> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		
		int[] NGF = new int[N];
		int[] A = new int[N];
		
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(input[i]);
			if(!map.containsKey(A[i]))
				map.put(A[i], 0);
			map.put(A[i], map.get(A[i]) + 1);
		}
		
		stack.push(0);
		for(int i = 1; i < N; i++) {
			while(!stack.isEmpty() && map.get(A[i]) > map.get(A[stack.peek()])) {
				NGF[stack.pop()] = A[i];
			}
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			NGF[stack.pop()] = -1;
		}
		
		for(int i = 0; i < N; i++) {
			sb.append(NGF[i] + " ");
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());
	}

}
