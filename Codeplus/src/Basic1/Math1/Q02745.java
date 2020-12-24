package Basic1.Math1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q02745 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		String N = input[0];
		int B = Integer.parseInt(input[1]);
		
		int result = 0;
		int multiple = 1;
		for(int i = 1; i <= N.length(); i++) {
			char tmp = N.charAt(N.length() - i);
			if(tmp >= 'A') {
				result += (int)(tmp - 'A' + 10) * multiple;
			}
			else {
				result += (int)(tmp - '0') * multiple;
			}
			multiple *= B;
		}
		System.out.println(result);
	}

}
