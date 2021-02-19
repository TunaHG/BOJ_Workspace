package Basic2.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q01759 {
	static int L, C;
	static String[] arr, answer;
	static String vowel = "aeiou";

	public static void passwd(int index, int count) {
		if (count == L) {
			int num = 0;
			for (int i = 0; i < L; i++) {
				if (vowel.contains(answer[i]))
					num++;
			}
			if (num > 0 && num <= L - 2) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < L; i++)
					sb.append(answer[i]);
				System.out.println(sb.toString().trim());
				return;
			}
			return;
		}

		for (int i = index + 1; i < C; i++) {
			answer[count] = arr[i];
			passwd(i, count + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		L = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);

		arr = br.readLine().split(" ");
		Arrays.sort(arr);
		answer = new String[L];

		passwd(-1, 0);
	}
}
