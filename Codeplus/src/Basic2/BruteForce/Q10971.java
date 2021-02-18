package Basic2.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10971 {
	static int N;
	static int[][] arr;
	static int result = Integer.MAX_VALUE;
	static boolean[] visited;

	public static void TSP(int start, int end, int sum, int count) {
		if (count == N) {
			if (arr[end][start] == 0)
				return;
			sum += arr[end][start];
			result = Math.min(result, sum);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			if (arr[end][i] == 0)
				continue;
			visited[i] = true;
			TSP(start, i, sum + arr[end][i], count + 1);
			visited[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N];

		String[] input;
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			visited[i] = true;
			TSP(i, i, 0, 1);
			visited[i] = false;
		}
		System.out.println(result);
	}
}
