package Basic2.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q16947 {
	static ArrayList<Integer>[] arrayLists;
	static int[] check;
	static int[] dist;

	public static int DFS(int num, int pre) {
		if (check[num] == 1)
			return num;
		check[num] = 1;
		for (int next : arrayLists[num]) {
			if (next == pre)
				continue;
			int res = DFS(next, num);
			if (res == -2)
				return -2;
			if (res >= 1) {
				check[num] = 2;
				if (res == num)
					return -2;
				else
					return res;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		check = new int[N + 1];
		dist = new int[N + 1];
		arrayLists = (ArrayList<Integer>[]) new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			arrayLists[i] = new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			arrayLists[from].add(to);
			arrayLists[to].add(from);
		}

		DFS(1, 0);
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (check[i] == 2) {
				dist[i] = 0;
				queue.add(i);
			} else
				dist[i] = -1;
		}
		while (!queue.isEmpty()) {
			int num = queue.poll();
			for (int next : arrayLists[num]) {
				if (dist[next] == -1) {
					dist[next] = dist[num] + 1;
					queue.add(next);
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			System.out.print(dist[i] + " ");
		}
	}
}
