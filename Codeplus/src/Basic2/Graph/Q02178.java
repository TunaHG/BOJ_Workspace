package Basic2.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q02178 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		int[][] maze = new int[N + 2][M + 2];
		for (int i = 1; i < N + 1; i++) {
			input = br.readLine().split("");
			for (int j = 1; j < M + 1; j++) {
				int num = Integer.parseInt(input[j - 1]);
				maze[i][j] = num == 1 ? 10000 : num;
			}
		}
		maze[1][1] = 1;

		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, -1, 0, 1};
		boolean[][] visited = new boolean[N + 2][M + 2];

		Queue<Integer[]> queue = new LinkedList<>();
		queue.add(new Integer[]{1, 1});

		while (!queue.isEmpty()) {
			Integer[] target = queue.poll();
			if (visited[target[0]][target[1]])
				continue;
			visited[target[0]][target[1]] = true;

			for (int near = 0; near < dx.length; near++) {
				if (!visited[target[0] + dx[near]][target[1] + dy[near]] && maze[target[0] + dx[near]][target[1] + dy[near]] != 0) {
					queue.add(new Integer[]{target[0] + dx[near], target[1] + dy[near]});
					maze[target[0] + dx[near]][target[1] + dy[near]] = Math.min(maze[target[0] + dx[near]][target[1] + dy[near]], maze[target[0]][target[1]] + 1);
				}
			}
		}

		System.out.println(maze[N][M]);
	}
}
