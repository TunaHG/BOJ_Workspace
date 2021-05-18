package Basic2.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q02146 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] dist = new int[N + 2][N + 2];
		int[][] group = new int[N + 2][N + 2];
		for (int i = 0; i < N + 2; i++) {
			Arrays.fill(group[i], -1);
			Arrays.fill(dist[i], -1);
			if (i == 0 || i == N + 1)
				continue;
			String[] input = br.readLine().split(" ");
			for (int j = 1; j < N + 1; j++) {
				dist[i][j] = Integer.parseInt(input[j - 1]);
				group[i][j] = 0;
			}
		}

		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, -1, 0, 1};
		boolean[][] visited = new boolean[N + 2][N + 2];
		Queue<Integer[]> queue = new LinkedList<>();
		Queue<Integer[]> queue2 = new LinkedList<>();
		int island = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (visited[i][j]) {
					continue;
				}
				if (dist[i][j] == 1) {
					queue.add(new Integer[]{i, j});
					visited[i][j] = true;

					while (!queue.isEmpty()) {
						Integer[] tmp = queue.poll();
						int row = tmp[0];
						int col = tmp[1];

						for (int k = 0; k < 4; k++) {
							if (dist[row + dx[k]][col + dy[k]] == 0) {
								queue2.add(new Integer[]{row, col});
								break;
							}
						}

						group[row][col] = island;

						for (int k = 0; k < 4; k++) {
							if (!visited[row + dx[k]][col + dy[k]] && dist[row + dx[k]][col + dy[k]] == 1) {
								queue.add(new Integer[]{row + dx[k], col + dy[k]});
								visited[row + dx[k]][col + dy[k]] = true;
							}
						}
					}
					island++;
				}
			}
		}

		int result = Integer.MAX_VALUE;
		A:
		while (!queue2.isEmpty()) {
			Integer[] tmp = queue2.poll();
			int row = tmp[0];
			int col = tmp[1];

			for (int i = 0; i < 4; i++) {
				if (group[row + dx[i]][col + dy[i]] > 0 && group[row + dx[i]][col + dy[i]] != group[row][col]) {
					if (dist[row][col] == dist[row + dx[i]][col + dy[i]]) {
						result = Math.min(result, dist[row][col] + dist[row + dx[i]][col + dy[i]] - 2);
					} else {
						result = Math.min(result, Math.min(dist[row][col], dist[row + dx[i]][col + dy[i]]) * 2 - 1);
					}
				}
				if (!visited[row + dx[i]][col + dy[i]] && dist[row + dx[i]][col + dy[i]] == 0) {
					queue2.add(new Integer[]{row + dx[i], col + dy[i]});
					dist[row + dx[i]][col + dy[i]] = dist[row][col] + 1;
					group[row + dx[i]][col + dy[i]] = group[row][col];
					visited[row + dx[i]][col + dy[i]] = true;
				}
			}
		}
		System.out.println(result);
	}
}

/*
발생할 수 있는 오류 몇가지
1. 두 섬이 1221로 만나는 경우와 121로 만나는 경우를 분리
2. 1221과 121이 동시에 발생할 수 있음에 주의
3. 메모리초과의 경우. 중복을 제거하기 위해서는 Queue에서 값을 빼고 visited를 처리하는 것이 아니라 Queue에 값을 넣을때 visited를 처리해주는 것이 좋다.
 */
