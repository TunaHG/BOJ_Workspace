package Basic1.Datastructure1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q10808 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] count = new int[26];
		String input = br.readLine();
		
		for(int i = 0; i < input.length(); i++) {
			count[input.charAt(i) - 'a']++;
		}
		
		for(int i = 0; i < count.length; i++) {
			sb.append(count[i] + " ");
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());
	}

}
