package Basic2.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q02529 {
	static int k;
	static String min = String.valueOf(Double.MAX_VALUE), max = String.valueOf(Double.MIN_VALUE);
	static String[] arr;
	static boolean[] visited = new boolean[10];

	public static void brute(String num, int count) {
		if (count == k) {
			min = Double.parseDouble(min) > Double.parseDouble(num) ? num : min;
			max = Double.parseDouble(max) < Double.parseDouble(num) ? num : max;
			return;
		}

		for (int i = 0; i <= 9; i++) {
			if (!visited[i]) {
				int tmp = num.charAt(num.length() - 1) - '0';
				if (arr[count].equals(">")) {
					if (tmp > i) {
						visited[i] = true;
						brute(num + i, count + 1);
						visited[i] = false;
					}
				} else {
					if (tmp < i) {
						visited[i] = true;
						brute(num + i, count + 1);
						visited[i] = false;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		k = Integer.parseInt(br.readLine());
		arr = br.readLine().trim().split(" ");

		for (int i = 0; i <= 9; i++) {
			visited[i] = true;
			brute(String.valueOf(i), 0);
			visited[i] = false;
		}
		System.out.println(max);
		System.out.println(min);
	}
}
