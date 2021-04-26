package Basic2.Graph;

import java.util.*;

public class Q01260 {
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

	static void DFS(int target) {
		if (visited[target])
			return;
		visited[target] = true;

		System.out.print(target + " ");

		for (int next : arr.get(target)) {
			if (visited[next])
				continue;
			DFS(next);
		}
	}

	static void BFS(int target) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(target);

		while (!queue.isEmpty()) {
			int x = queue.poll();
			if (visited[x])
				continue;

			visited[x] = true;

			System.out.print(x + " ");

			for (int next : arr.get(x)) {
				if (visited[next])
					continue;
				queue.add(next);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();

		for (int i = 0; i <= N; i++) {
			arr.add(new ArrayList<>());
		}

		while (M-- > 0) {
			int from = sc.nextInt();
			int to = sc.nextInt();

			arr.get(from).add(to);
			arr.get(to).add(from);
		}

		for (int i = 0; i < N; i++) {
			Collections.sort(arr.get(i));
		}

		visited = new boolean[N + 1];
		DFS(V);
		System.out.println();
		visited = new boolean[N + 1];
		BFS(V);
	}
}
