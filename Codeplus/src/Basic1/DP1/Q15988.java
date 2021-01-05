package Basic1.DP1;

import java.util.Scanner;

public class Q15988 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		
		int[] dp = new int[1000001];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i < 1000001; i++) {
			dp[i] = ((dp[i - 1] + dp[i - 2]) % 1000000009 + dp[i - 3]) % 1000000009;
		}
		
		while(T-- > 0) {
			int n = scan.nextInt();
			
			System.out.println(dp[n]);
		}
		scan.close();
	}

}
