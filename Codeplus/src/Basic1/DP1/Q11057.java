package Basic1.DP1;

import java.util.Arrays;
import java.util.Scanner;

public class Q11057 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		
		int[][] dp = new int[N + 2][10];
		Arrays.fill(dp[1], 1);
		
		for(int i = 2; i <= N + 1; i++) {
			dp[i][0] = 1;
			for(int j = 1; j < 10; j++) {
				dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 10007;
			}
		}
		
		System.out.println(dp[N + 1][9]);
		scan.close();
	}

}

/*
	9	8	7	6	5	4	3	2	1	0
1	1	1	1	1	1	1	1	1	1	1
2	1	2	3	4	5	6	7	8	9	10
3	1	3	6	10	15	21	28	36	45	55
4	1	4	10	20	35	56	84	120	165	220

row -> 자릿수 (digit)
col -> 각 자릿수의 숫자 (The number of each digit)
*/