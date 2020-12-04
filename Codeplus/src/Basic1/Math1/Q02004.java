package Basic1.Math1;

import java.util.Scanner;

public class Q02004 {
	// 배수를 이용해야 함.
	// 100 = 5 * 20이란소리는 1~100까지의 숫자중에 5의 배수가 20개 존재한다는 의미
	public static int twoCount(int num) {
		int cnt = 0;
		for(long i = 2; i <= num; i *= 2) {
			cnt += num / i;
		}
		return cnt;
	}
	public static int fiveCount(int num) {
		int cnt = 0;
		for(long i = 5; i <= num; i *= 5) {
			cnt += num / i;
		}
		return cnt;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int m = scan.nextInt();
		
		int two = 0;
		int five = 0;
		
		two += twoCount(n);
		five += fiveCount(n);
		
		two -= twoCount(m);
		five -= fiveCount(m);
		
		two -= twoCount(n - m);
		five -= fiveCount(n - m);
		
		System.out.println(Math.min(two, five));
		scan.close();
	}

}
