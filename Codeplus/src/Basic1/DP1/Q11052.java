package Basic1.DP1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q11052 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String input[] = br.readLine().split(" ");
		
		int dp[] = new int[N];
		for(int i = 0; i < N; i++) {
			dp[i] = Integer.parseInt(input[i]); 
		}
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < i; j++) {
				dp[i] = Math.max(dp[i], dp[j] + Integer.parseInt(input[i - j - 1]));
			}
		}
		
		System.out.println(dp[N - 1]);
	}

}
