package Basic2.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q06603 {
	static int k;
	static int[] arr, answer;

	public static void Lotto(int index, int count) {
		if (count == 6) {
			for (int i = 0; i < 6; i++) {
				System.out.print(answer[i]);
				if (i != k - 1)
					System.out.print(" ");
			}
			System.out.println();

			return;
		}

		for (int i = index + 1; i < k; i++) {
			answer[count] = arr[i];
			Lotto(i, count + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input;
		while (!(input = br.readLine().split(" "))[0].equals("0")) {
			k = Integer.parseInt(input[0]);
			arr = new int[k];
			answer = new int[6];
			for (int i = 0; i < k; i++) {
				arr[i] = Integer.parseInt(input[i + 1]);
			}

			Lotto(-1, 0);
			System.out.println();
		}
	}
}
