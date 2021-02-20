package Basic2.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q01248 {
	static int N;
	static int[] answer;
	static char[][] S;

	public static void brute(int count) {
		if (count == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(answer[i] + " ");
			}
			System.exit(0);
		}

		for (int i = -10; i <= 10; i++) {
			answer[count] = i;
			if (check(count))
				brute(count + 1);
		}
	}

	public static boolean check(int idx) {
		for (int i = 0; i <= idx; i++) {
			int sum = 0;
			for (int j = i; j <= idx; j++) {
				sum += answer[j];
				if (S[i][j] != (sum == 0 ? '0' : (sum > 0 ? '+' : '-')))
					return false;
			}
		}

		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		answer = new int[N];
		S = new char[N][N];

		String input = br.readLine();
		int idx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				S[i][j] = input.charAt(idx++);
			}
		}

		brute(0);
	}
}
