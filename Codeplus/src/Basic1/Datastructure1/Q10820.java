package Basic1.Datastructure1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q10820 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int upperCase = 0;
		int lowerCase = 0;
		int space = 0;
		int number = 0;
		String input = "";
		while((input = br.readLine()) != null) {
			upperCase = 0;
			lowerCase = 0;
			space = 0;
			number = 0;
			for(int i = 0; i < input.length(); i++) {
				char word = input.charAt(i);
				if(word == ' ')
					space++;
				else if(word >= 'A' && word <= 'Z')
					upperCase++;
				else if(word >= 'a' && word <= 'z')
					lowerCase++;
				else
					number++;
			}
			sb.append(lowerCase + " " + upperCase + " " + number + " " + space + "\n");
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());
	}

}
