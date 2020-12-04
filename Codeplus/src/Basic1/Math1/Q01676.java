package Basic1.Math1;

import java.util.Scanner;

public class Q01676 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();

		if(N == 0) {
			System.out.println(0);
			scan.close();
			return ;
		}
		
		int cnt = 0;
		for(int i = 5; i <= N; i++) {
			int tmp = i;
			while(true) {
				if(tmp % 5 == 0) {
					cnt++;
					tmp = tmp / 5;
				} else
					break;
			}
		}
		System.out.println(cnt);
		scan.close();
	}

}
