package Basic2.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q07576 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int[][] map = new int[N + 2][M + 2];
		for (int i = 0; i < N + 2; i++) {
			Arrays.fill(map[i], -1);
		}
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < M + 1; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, -1, 0, 1};
		boolean[][] visited = new boolean[N + 2][M + 2];
		int result = 0;
		Queue<Integer[]> queue = new LinkedList<>();
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < M + 1; j++) {
				if (map[i][j] != 1)
					continue;

				queue.add(new Integer[]{i, j});
			}
		}

		while (!queue.isEmpty()) {
			Integer[] x = queue.poll();
			if (visited[x[0]][x[1]])
				continue;
			visited[x[0]][x[1]] = true;

			for (int near = 0; near < dx.length; near++) {
				if (!visited[x[0] + dx[near]][x[1] + dy[near]] && map[x[0] + dx[near]][x[1] + dy[near]] == 0) {
					queue.add(new Integer[]{x[0] + dx[near], x[1] + dy[near]});
					map[x[0] + dx[near]][x[1] + dy[near]] = map[x[0]][x[1]] + 1;
				}
			}
		}

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < M + 1; j++) {
				if (map[i][j] == 0) {
					System.out.println(-1);
					System.exit(0);
				}
				result = Math.max(result, map[i][j]);
			}
		}
		System.out.println(result - 1);
	}
}
