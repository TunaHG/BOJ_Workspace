package Basic2.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q01707 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int test = sc.nextInt();

		A:
		while (test-- > 0) {
			int vertex = sc.nextInt();
			int edge = sc.nextInt();

			int[] check = new int[vertex + 1];
			ArrayList<Integer>[] arr = (ArrayList<Integer>[]) new ArrayList[vertex + 1];
			for (int i = 0; i <= vertex; i++) {
				arr[i] = new ArrayList<>();
			}

			while (edge-- > 0) {
				int from = sc.nextInt();
				int to = sc.nextInt();

				arr[from].add(to);
				arr[to].add(from);
			}

			Queue<Integer> queue = new LinkedList<>();

			for (int i = 1; i <= vertex; i++) {
				if (check[i] != 0)
					continue;
				check[i] = 1;
				queue.add(i);

				while (!queue.isEmpty()) {
					int target = queue.poll();

					System.out.println("Target: " + target + ", NEXTS: " + arr[target].toString());
					if (check[target] == 1) {
						for (int next : arr[target]) {
							if (check[next] == 1) {
								System.out.println("NO");
								continue A;
							}
							if (check[next] == 2)
								continue;
							check[next] = 2;
							queue.add(next);
						}
					} else {
						for (int next : arr[target]) {
							if (check[next] == 2) {
								System.out.println("NO");
								continue A;
							}
							if (check[next] == 1)
								continue;
							check[next] = 1;
							queue.add(next);
						}
					}
				}
			}
			System.out.println("YES");
		}
	}
}
