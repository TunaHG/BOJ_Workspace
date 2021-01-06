package Basic1.DP1;

import java.util.Scanner;

public class Q02133 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		
		int[] dp = new int[N + 1];
		dp[0] = 1;
		dp[1] = 0;
		
		for(int i = 2; i <= N; i++) {
			int tmp = 0;
			for(int j = 4; j <= i; j += 2) {
				tmp += dp[i - j];
			}
			dp[i] = 3 * dp[i - 2] + 2 * tmp;
		}
		
		System.out.println(dp[N]);
		
		scan.close();
	}

}

// N이 0일 땐 아무것도 사용하지 않고 채울 수 있으므로 1
// 홀수일 땐 채울 수 있는 경우의 수가 없으므로 전부 0