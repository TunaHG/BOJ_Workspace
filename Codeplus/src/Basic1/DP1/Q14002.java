package Basic1.DP1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Q14002 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>(); 
		
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		
		int[] A = new int[N];
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(input[i]);
		}
		int[] order = new int[N];
		Arrays.fill(order, -1);
		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < i; j++) {
				if(A[i] > A[j] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
					order[i] = j;
				}
			}
		}
		
		int result = 0;
		int resultLoc = 0;
		for(int i = 0; i < N; i++) {
			if(dp[i] > result) {
				result = dp[i];
				resultLoc = i;
			}
		}
		
		while(true) {
			if(resultLoc == -1)
				break;
			
			stack.push(A[resultLoc]);
			resultLoc = order[resultLoc];
		}
		
		System.out.println(result);
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
			if(!stack.isEmpty())
				System.out.print(" ");
		}
	}

}
