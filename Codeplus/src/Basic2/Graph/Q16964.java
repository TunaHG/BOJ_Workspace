package Basic2.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Q16964 {
	static boolean[] visited;
	static ArrayList<Integer>[] arrayLists;
	static int[] DFSResult;
	static int result = 1;
	static int idx = 2;

	static void DFS(int target) {
		if (result == 0)
			return;

		HashSet<Integer> set = new HashSet<>();
		for (int next : arrayLists[target]) {
			if (!visited[next]) {
				visited[next] = true;
				set.add(next);
			}
		}

		int size = set.size();
		for (int i = 0; i < size; i++) {
			if (set.remove(DFSResult[idx])) {
				DFS(DFSResult[idx++]);
			} else {
				result = 0;
				return;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		arrayLists = (ArrayList<Integer>[]) new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			arrayLists[i] = new ArrayList<>();
		}
		for (int i = 0; i < N - 1; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			arrayLists[from].add(to);
			arrayLists[to].add(from);
		}

		visited = new boolean[N + 1];
		DFSResult = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			DFSResult[i] = sc.nextInt();
		}

		visited[1] = true;
		DFS(1);
		System.out.println(result);
	}
}
