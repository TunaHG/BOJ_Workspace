package Basic2.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11723 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		int bitmask = 0;
		while (M-- > 0) {
			String[] input = br.readLine().split(" ");
			switch (input[0]) {
				case "add" -> bitmask |= 1 << (Integer.parseInt(input[1]) - 1);
				case "remove" -> bitmask &= ~(1 << (Integer.parseInt(input[1]) - 1));
				case "check" -> sb.append((bitmask & (1 << (Integer.parseInt(input[1]) - 1))) != 0 ? 1 : 0).append("\n");
				case "toggle" -> bitmask ^= (1 << (Integer.parseInt(input[1]) - 1));
				case "all" -> bitmask |= (~0);
				case "empty" -> bitmask &= 0;
			}
		}
		System.out.println(sb.toString());
	}
}
