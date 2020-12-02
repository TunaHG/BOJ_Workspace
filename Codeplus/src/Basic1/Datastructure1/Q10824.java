package Basic1.Datastructure1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q10824 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] result = new int[14];
		String[] input = br.readLine().split(" ");
		
		String num1 = input[0] + input[1];
		String num2 = input[2] + input[3];
		
		for(int i = 0; i < result.length; i++) {
			if(i < num1.length())
				result[13 - i] += num1.charAt(num1.length() - 1 - i) - '0';
			if(i < num2.length())
				result[13 - i] += num2.charAt(num2.length() - 1 - i) - '0';
			if(result[13 - i] >= 10) {
				result[13 - i] %= 10;
				result[12 - i] += 1;
			}
		}
		
		int idx = 0;
		while(true) {
			if(result[idx] != 0)
				break;
			idx++;
		}
		
		while(idx < 14) {
			System.out.print(result[idx]);
			idx++;
		}
	}

}
