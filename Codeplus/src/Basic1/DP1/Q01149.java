package Basic1.DP1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q01149 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] price = new int[N + 1][3];
		for(int i = 1; i <= N; i++) {
			String[] input = br.readLine().split(" ");
			for(int j = 0; j < 3; j++) {
				price[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		int[][] dp = new int[N + 1][3];
		dp[1][0] = price[1][0];
		dp[1][1] = price[1][1];
		dp[1][2] = price[1][2];
		
		for(int i = 2; i <= N; i++) {
			dp[i][0] = Math.min(dp[i - 1][1] + price[i][0], dp[i - 1][2] + price[i][0]);
			dp[i][1] = Math.min(dp[i - 1][0] + price[i][1], dp[i - 1][2] + price[i][1]);
			dp[i][2] = Math.min(dp[i - 1][0] + price[i][2], dp[i - 1][1] + price[i][2]);
		}
		
		System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
	}

}
