package Basic1.Math1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q11005 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int B = Integer.parseInt(input[1]);
		
		while(N != 0) {
			int tmp = N % B;
			if(tmp >= 10) {
				sb.append((char)('A' + tmp - 10));
			} else {
				sb.append(tmp);
			}
			N /= B;
		}
		System.out.println(sb.reverse().toString());
	}

}
