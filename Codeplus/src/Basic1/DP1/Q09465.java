package Basic1.DP1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q09465 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[][] score = new int[n + 1][2];
			for(int i = 0; i < 2; i++) {
				String[] input = br.readLine().split(" ");
				for(int j = 1; j <= n; j++) {
					score[j][i] = Integer.parseInt(input[j - 1]);
				}
			}
			
			int[][] dp = new int[n + 1][3];
			dp[1][0] = 0;
			dp[1][1] = score[1][0];
			dp[1][2] = score[1][1];
			for(int i = 2; i <= n; i++) {
				dp[i][0] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
				dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2]) + score[i][0];
				dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][1]) + score[i][1];
			}

			int result = Math.max(Math.max(dp[n][0], dp[n][1]), dp[n][2]);
			System.out.println(result);
		}
	}

}
