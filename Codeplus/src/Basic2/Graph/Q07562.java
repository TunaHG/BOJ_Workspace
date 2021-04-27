package Basic2.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q07562 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
		int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

		int test = sc.nextInt();
		while (test-- > 0) {
			int I = sc.nextInt();
			int[][] map = new int[I + 4][I + 4];
			boolean[][] visited = new boolean[I + 4][I + 4];

			for (int i = 0; i < I + 4; i++) {
				Arrays.fill(map[i], -1);
			}
			for (int i = 2; i < I + 2; i++) {
				for (int j = 2; j < I + 2; j++) {
					map[i][j] = 0;
				}
			}

			int fromRow = sc.nextInt();
			int fromCol = sc.nextInt();
			int toRow = sc.nextInt();
			int toCol = sc.nextInt();

			Queue<Integer[]> q = new LinkedList<>();
			q.add(new Integer[]{fromRow + 2, fromCol + 2});

			while (!q.isEmpty()) {
				Integer[] x = q.poll();
				if (visited[x[0]][x[1]])
					continue;
				visited[x[0]][x[1]] = true;

				int num = map[x[0]][x[1]];

				for (int i = 0; i < dx.length; i++) {
					if (!visited[x[0] + dx[i]][x[1] + dy[i]] && map[x[0] + dx[i]][x[1] + dy[i]] == 0) {
						q.add(new Integer[]{x[0] + dx[i], x[1] + dy[i]});
						map[x[0] + dx[i]][x[1] + dy[i]] = num + 1;
					}
				}
			}

			System.out.println(map[toRow + 2][toCol + 2]);
		}
	}
}
