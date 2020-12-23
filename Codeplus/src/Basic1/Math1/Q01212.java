package Basic1.Math1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q01212 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();

		for(int i = 0; i < input.length(); i++) {
			int tmp = input.charAt(i) - '0';
			int binary = 4;
			while(binary != 0) {
				sb.append(tmp / binary);
				tmp %= binary;
				binary /= 2;
			}
		}
		
		while(sb.charAt(0) == '0') {
			if(sb.length() == 1)
				break;
			sb.deleteCharAt(0);
		}
		System.out.println(sb.toString());
	}

}
