package Basic2.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q04963 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean[][] visited;
		int[][] map;
		int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
		int[] dy = {1, 0, -1, -1, -1, 0, 1, 1};
		Queue<Integer[]> queue;
		int result = 0;

		while (true) {
			int w = sc.nextInt();
			int h = sc.nextInt();

			if (w == 0 && h == 0)
				break;

			result = 0;
			visited = new boolean[h + 2][w + 2];
			map = new int[h + 2][w + 2];
			for (int i = 1; i < h + 1; i++) {
				for (int j = 1; j < w + 1; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 1; i < h + 1; i++) {
				for (int j = 1; j < w + 1; j++) {
					if (map[i][j] == 0)
						continue;
					if (visited[i][j])
						continue;

					result++;

					queue = new LinkedList<>();
					queue.add(new Integer[]{i, j});

					while (!queue.isEmpty()) {
						Integer[] x = queue.poll();
						if (visited[x[0]][x[1]])
							continue;
						visited[x[0]][x[1]] = true;

						for (int near = 0; near < dx.length; near++) {
							if (map[x[0] + dx[near]][x[1] + dy[near]] == 1 && !visited[x[0] + dx[near]][x[1] + dy[near]]) {
								queue.add(new Integer[]{x[0] + dx[near], x[1] + dy[near]});
							}
						}
					}
				}
			}
			System.out.println(result);
		}
	}
}
