package Basic1.Datastructure1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q9093 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while(N-- > 0) {
			String line[] = br.readLine().split(" ");
			for(int i = 0; i < line.length; i++) {
				for(int j = line[i].length() - 1; j >= 0; j--) {
					sb.append(line[i].charAt(j));
				}
				if(i != line.length - 1)
					sb.append(" ");
			}
			if(N != 0)
				sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
