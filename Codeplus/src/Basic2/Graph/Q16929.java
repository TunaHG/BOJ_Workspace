package Basic2.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q16929 {
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {0, -1, 0, 1, 0};
	static int[] dy = {0, 0, -1, 0, 1};

	public static void DFS(int row, int col, int pre, char c) {
		if (visited[row][col]) {
			System.out.println("Yes");
			System.exit(0);
		}

		visited[row][col] = true;

		for (int i = 1; i < 5; i++) {
			if (i == pre)
				continue;
			if (map[row + dx[i]][col + dy[i]] == c)
				DFS(row + dx[i], col + dy[i], i > 2 ? i - 2 : i + 2, c);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		map = new char[N + 2][M + 2];

		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = str.charAt(j - 1);
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				visited = new boolean[N + 2][M + 2];
				DFS(i, j, 0, map[i][j]);
			}
		}
		System.out.println("No");
	}
}
