package Basic1.DP1;

import java.util.Scanner;

public class Q09095 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		
		while(T-- > 0) {
			int n = scan.nextInt();
			
			int dp[] = new int[n + 1];
			dp[0] = 1;
			dp[1] = 1;
			if(n >= 2)
				dp[2] = 2;
			
			for(int i = 3; i <= n; i++) {
				dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
			}
			
			System.out.println(dp[n]);
		}
	}

}
