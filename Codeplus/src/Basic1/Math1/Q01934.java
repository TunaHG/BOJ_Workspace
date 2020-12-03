package Basic1.Math1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q01934 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			String[] input = br.readLine().split(" ");
			int num1 = Integer.parseInt(input[0]);
			int num2 = Integer.parseInt(input[1]);
			
			if(num1 % num2 == 0) {
				sb.append(num1 + "\n");
				continue;
			}
			if(num2 % num1 == 0) {
				sb.append(num2 + "\n");
				continue;
			}
			
			int idx = 2;
			while(true) {
				if(num1 * idx % num2 == 0) {
					sb.append(num1 * idx + "\n");
					break;
				}
				idx++;
			}
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());
	}

}
