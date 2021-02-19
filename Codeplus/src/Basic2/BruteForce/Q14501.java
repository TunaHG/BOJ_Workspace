package Basic2.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q14501 {
	static int N;
	static int[] T, P;
	static int result = 0;

	public static void consulting(int day, int sum) {
		if (day > N)
			return;
		if (day == N) {
			result = Math.max(result, sum);
			return;
		}

		consulting(day + T[day], sum + P[day]);
		consulting(day + 1, sum);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		T = new int[N];
		P = new int[N];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			T[i] = Integer.parseInt(input[0]);
			P[i] = Integer.parseInt(input[1]);
		}

		consulting(0, 0);
		System.out.println(result);
	}
}
