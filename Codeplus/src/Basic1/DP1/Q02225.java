package Basic1.DP1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q02225 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		int[][] dp = new int[K + 1][N + 1];
		Arrays.fill(dp[1], 1);
		
		for(int i = 1; i <= K; i++) {
			dp[i][0] = 1;
		}
		
		for(int i = 2; i <= K; i++) {
			for(int j = 1; j <= N; j++) {
				dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000000;
			}
		}
		
//		for(int i = 2; i <= K; i++) {
//			for(int j = 0; j <= N; j++) {
//				for(int k = 0; k <= j; k++) {
//					dp[i][j] += dp[i - 1][k];
//				}
//			}
//		}
		
//		for(int i = 1; i <= K; i++) {
//			for(int j = 0; j <= N; j++) {
//				System.out.print(dp[i][j] + "\t");
//			}
//			System.out.println();
//		}
		
		System.out.println(dp[K][N]);
	}

}
