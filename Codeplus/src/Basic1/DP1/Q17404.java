package Basic1.DP1;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Q17404 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] price = new int[N][3];
		for(int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for(int j = 0; j < 3; j++) {
				price[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		int result = 0;
		int[][] dp = new int[N][3];
		dp[0][0] = price[0][0];
		dp[0][1] = Integer.MAX_VALUE;
		dp[0][2] = Integer.MAX_VALUE;
		for(int i = 1; i < N; i++) {
			if(i == 1)
				dp[i][0] = Integer.MAX_VALUE;
			else
				dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + price[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + price[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + price[i][2];
		}
		result = Math.min(dp[N - 1][1], dp[N - 1][2]);
		
		dp = new int[N][3];
		dp[0][0] = Integer.MAX_VALUE;
		dp[0][1] = price[0][1];
		dp[0][2] = Integer.MAX_VALUE;
		for(int i = 1; i < N; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + price[i][0];
			if(i == 1)
				dp[i][1] = Integer.MAX_VALUE;
			else
				dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + price[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + price[i][2];
		}
		result = Math.min(Math.min(result, dp[N - 1][0]), dp[N - 1][2]);
		
		dp = new int[N][3];
		dp[0][0] = Integer.MAX_VALUE;
		dp[0][1] = Integer.MAX_VALUE;
		dp[0][2] = price[0][2];
		for(int i = 1; i < N; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + price[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + price[i][1];
			if(i == 1)
				dp[i][2] = Integer.MAX_VALUE;
			else
				dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + price[i][2];
		}
		result = Math.min(Math.min(result, dp[N - 1][0]), dp[N - 1][1]);
		
		System.out.println(result);
	}

}
