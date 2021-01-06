package Basic1.DP1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q11055 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		
		int[] A = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(input[i - 1]);
		}

		int[] dp = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			dp[i] = A[i];
		}
		
		int result = dp[1];
		for(int i = 2; i <= N; i++) {
			for(int j = 1; j < i; j++) {
				if(A[i] > A[j] && dp[j] + A[i] > dp[i]) {
					dp[i] = dp[j] + A[i];
					result = Math.max(result, dp[i]);
				}
			}
		}
		
		System.out.println(result);
	}

}
