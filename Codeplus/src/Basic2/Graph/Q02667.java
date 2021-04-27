package Basic2.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q02667 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N + 2][N + 2];
		for (int i = 0; i < N + 2; i++) {
			Arrays.fill(arr[i], -1);
		}
		for (int i = 1; i < N + 1; i++) {
			String[] input = br.readLine().split("");
			for (int j = 1; j < N + 1; j++) {
				arr[i][j] = Integer.parseInt(input[j - 1]);
			}
		}

		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, -1, 0, 1};
		boolean[][] visited = new boolean[N + 2][N + 2];

		ArrayList<Integer> dangi = new ArrayList<>();
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (arr[i][j] == 0)
					continue;
				if (visited[i][j])
					continue;

				int cnt = 0;

				Queue<Integer[]> queue = new LinkedList<>();
				queue.add(new Integer[]{i, j});

				while (!queue.isEmpty()) {
					Integer[] x = queue.poll();
					if (visited[x[0]][x[1]])
						continue;

					visited[x[0]][x[1]] = true;
					cnt++;

					for (int near = 0; near < 4; near++) {
						if (arr[x[0] + dx[near]][x[1] + dy[near]] == 1 && !visited[x[0] + dx[near]][x[1] + dy[near]]) {
							queue.add(new Integer[]{x[0] + dx[near], x[1] + dy[near]});
						}
					}
				}

				dangi.add(cnt);
			}
		}

		System.out.println(dangi.size());
		Collections.sort(dangi);
		for (int result : dangi)
			System.out.println(result);
	}
}
