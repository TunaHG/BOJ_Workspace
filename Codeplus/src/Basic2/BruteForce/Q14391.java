package Basic2.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q14391 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			input = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
			}
		}

		int result = 0;
		for (int s = 0; s < (1 << (N * M)); s++) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				int cur = 0;
				for (int j = 0; j < M; j++) {
					if ((s & (1 << ((i * M) + j))) == 0)
						cur = cur * 10 + arr[i][j];
					else {
						sum += cur;
						cur = 0;
					}
				}
				sum += cur;
			}
			for (int i = 0; i < M; i++) {
				int cur = 0;
				for (int j = 0; j < N; j++) {
					if ((s & (1 << ((j * M) + i))) != 0)
						cur = cur * 10 + arr[j][i];
					else {
						sum += cur;
						cur = 0;
					}
				}
				sum += cur;
			}

			result = Math.max(result, sum);
		}
		System.out.println(result);
	}
}
