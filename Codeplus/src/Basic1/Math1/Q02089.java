package Basic1.Math1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q02089 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int inputValue = Integer.parseInt(br.readLine());
		
		if(inputValue == 0) {
			System.out.println(0);
			return ;
		}
		
		while(inputValue != 1) {
			if(inputValue % -2 == -1) {
				sb.append(1);
				inputValue = inputValue / -2 + 1;
			} else {
				sb.append(inputValue % -2);
				inputValue = inputValue / -2;
			}
		}
		sb.append(inputValue);
		System.out.println(sb.reverse().toString());
	}

}
