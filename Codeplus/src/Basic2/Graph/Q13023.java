package Basic2.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q13023 {
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	static int result;

	static void DFS(int person, int cnt) {
		if (cnt >= 4) {
			result = 1;
			System.out.println(result);
			// 답을 찾았으면 더 이상 탐색하지않고 코드가 종료되도록해야 시간초과가 발생하지 않는다.
			System.exit(0);
			return;
		}

		for (int friend : arr[person]) {
			if (visited[friend])
				continue;
			visited[friend] = true;
			DFS(friend, cnt + 1);
			visited[friend] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		// TODO: Solve unchecked cast warning
		arr = (ArrayList<Integer>[]) new ArrayList[N];
		for (int i = 0; i < N; i++) {
			arr[i] = new ArrayList<>();
		}
		visited = new boolean[N];
		result = 0;

		while (M-- > 0) {
			input = br.readLine().split(" ");
			int first = Integer.parseInt(input[0]);
			int second = Integer.parseInt(input[1]);

			arr[first].add(second);
			arr[second].add(first);
		}

		for (int i = 0; i < N; i++) {
			visited[i] = true;
			DFS(i, 0);
			visited[i] = false;
		}

		System.out.println(result);
	}
}
