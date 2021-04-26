package Basic2.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q11724 {
	static boolean[] visited;
	static int result;
	static ArrayList<Integer>[] arr;

	static void BFS(int target) {
		Queue<Integer> q = new LinkedList<>();
		q.add(target);

		while (!q.isEmpty()) {
			int x = q.poll();
			if (visited[x])
				continue;

			visited[x] = true;

			for (int next : arr[x]) {
				if (visited[next])
					continue;
				q.add(next);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		result = 0;
		visited = new boolean[N + 1];
		arr = (ArrayList<Integer>[]) new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		while (M-- > 0) {
			int from = sc.nextInt();
			int to = sc.nextInt();

			arr[from].add(to);
			arr[to].add(from);
		}

		for (int i = 1; i <= N; i++) {
			if (visited[i])
				continue;
			BFS(i);
			result++;
		}
		System.out.println(result);
	}
}
