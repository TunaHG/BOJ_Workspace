package Basic1.DP1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q13398 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		
		int[] seq = new int[n];
		for(int i = 0; i < n; i++) {
			seq[i] = Integer.parseInt(input[i]);
		}
		
		int result = seq[0];
		int[] DP = new int[n];
		DP[0] = seq[0];
		for(int i = 1; i < n; i++) {
			DP[i] = Math.max(seq[i], DP[i - 1] + seq[i]);
			result = Math.max(result, DP[i]);
		}
		
		int[] reverseDP = new int[n];
		reverseDP[n - 1] = seq[n - 1];
		for(int i = n - 2; i >= 0; i--) {
			reverseDP[i] = Math.max(seq[i], reverseDP[i + 1] + seq[i]);
		}
		
		for(int i = 1; i < n - 1; i++) {
			result = Math.max(result, DP[i - 1] + reverseDP[i + 1]);
		}
		
		System.out.println(result);
	}

}
