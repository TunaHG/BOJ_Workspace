package Basic1.Math1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q01373 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();
		
		int binaryNumber = 1;
		int octal = 0;
		for(int i = 1; i <= input.length(); i++) {
			if(binaryNumber == 8) {
				binaryNumber = 1;
				sb.insert(0, octal);
				octal = 0;
			}
			octal += (input.charAt(input.length() - i) - '0') * binaryNumber;
			binaryNumber *= 2;
		}
		sb.insert(0, octal);
		System.out.println(sb.toString());
	}

}
