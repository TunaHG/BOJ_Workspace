package Basic2.Graph;

import java.util.*;

public class Q16940 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		ArrayList<Integer>[] arrayLists = (ArrayList<Integer>[]) new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			arrayLists[i] = new ArrayList<>();
		}
		for (int i = 0; i < N - 1; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			arrayLists[from].add(to);
			arrayLists[to].add(from);
		}

		int[] result = new int[N];
		for (int i = 0; i < N; i++) {
			result[i] = sc.nextInt();
		}

		Queue<Integer> queue = new LinkedList<>();
		HashSet<Integer> set = new HashSet<>();
		boolean[] visited = new boolean[N + 1];
		int startIdx = 0;
		int endIdx = 1;
		queue.add(1);
		while (!queue.isEmpty()) {
			int num = queue.poll();
			visited[num] = true;

			set.clear();
			for (int x : arrayLists[num]) {
				if (visited[x])
					continue;
				set.add(x);
			}

			startIdx = endIdx;
			endIdx = startIdx + set.size();

			for (int i = startIdx; i < endIdx; i++) {
				if (set.contains(result[i]))
					queue.add(result[i]);
				else {
					System.out.println(0);
					System.exit(0);
				}
			}
		}
		System.out.println(1);
	}
}
