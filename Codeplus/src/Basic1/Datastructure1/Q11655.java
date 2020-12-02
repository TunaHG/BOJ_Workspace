package Basic1.Datastructure1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q11655 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) >= 'a') {
				sb.append(input.charAt(i) + 13 > 'z' ? (char)(input.charAt(i) + 13 - 'z' + 'a' - 1) : (char)(input.charAt(i) + 13));
			} 
			else if(input.charAt(i) >= 'A') {
				sb.append(input.charAt(i) + 13 > 'Z' ? (char)(input.charAt(i) + 13 - 'Z' + 'A' - 1) : (char)(input.charAt(i) + 13));
			}
			else 
				sb.append(input.charAt(i));
		}
		System.out.println(sb.toString());
	}

}
