package Basic1.DP1;

import java.util.Scanner;

public class Q01309 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int mod = 9901;
		
		int[][] dp = new int[N + 1][3];
		dp[1][0] = 1;
		dp[1][1] = 1;
		dp[1][2] = 1;
		
		for(int i = 2; i <= N; i++) {
			dp[i][0] = ((dp[i - 1][0] + dp[i - 1][1]) % mod + dp[i - 1][2]) % mod;
			dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
			dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
		}
		
		System.out.println(((dp[N][0] + dp[N][1]) % mod + dp[N][2]) % mod);
		
		scan.close();
	}

}
