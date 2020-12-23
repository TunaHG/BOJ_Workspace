package Basic1.Math1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q17103 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> primeNumber = new ArrayList<>();
		
		boolean[] goldbach = new boolean[1000001];
		goldbach[0] = true;
		goldbach[1] = true;
		for(int i = 2; i < 1000001; i++) {
			if(goldbach[i])
				continue;
			primeNumber.add(i);
			for(int j = i * 2; j < 1000001; j+=i)
				goldbach[j] = true;
		}
		
		int T = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			
			cnt = 0;
			for(int i = 0; i < primeNumber.size(); i++) {
				if(primeNumber.get(i) > N - primeNumber.get(i)) 
					break;
				if(!goldbach[N - primeNumber.get(i)]) {
					cnt++;
				}
			}
			sb.append(cnt + "\n");
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());
	}

}
