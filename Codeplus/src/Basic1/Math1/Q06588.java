package Basic1.Math1;

import java.util.Scanner;
import java.util.ArrayList;

public class Q06588 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> prime = new ArrayList<>();
		
		boolean[] check = new boolean[1000001];
		check[0] = true;
		check[1] = true;
		for(int i = 2; i < 1000001; i++) {
			if(check[i])
				continue;
			else {
				if(i % 2 != 0)
					prime.add(i);
				for(int j = i * 2; j < 1000001; j+=i) {
					check[j] = true;
				}
			}
		}
		int num = 0;
		while((num = scan.nextInt()) != 0) {
			for(int i = 0; i < prime.size(); i++) {
				if(!check[num - prime.get(i)]) {
					sb.append(num + " = " + prime.get(i) + " + " + (num - prime.get(i)) + "\n");
					break;
				}
			}
		}
		
		scan.close();
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());
	}

}
