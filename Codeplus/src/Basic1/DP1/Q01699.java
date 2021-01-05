package Basic1.DP1;

import java.util.Arrays;
import java.util.Scanner;

public class Q01699 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int[] dp = new int[N + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		for(int i = 1; i <= N; i++) {
			int j = 1;
			while(i >= j * j) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
				j++;
			}
		}

		System.out.println(dp[N]);
		scan.close();
	}

}
