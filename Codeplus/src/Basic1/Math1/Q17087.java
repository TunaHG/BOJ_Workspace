package Basic1.Math1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q17087 {
	public static int GCD(int num1, int num2) {
		if(num2 == 0)
			return num1;
		return GCD(num2, num1 % num2);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int S = Integer.parseInt(input[1]);
		
		int[] diff = new int[N];
		input = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			diff[i] = Math.abs(Integer.parseInt(input[i]) - S);
		}
		
		if(N == 1) {
			System.out.println(diff[0]);
			return ;
		}
		
		int result = GCD(diff[0], diff[1]);
		for(int i = 2; i < N; i++) {
			result = GCD(result, diff[i]);
		}
		System.out.println(result);
		
//		int[] A = new int[N];
//		input = br.readLine().split(" ");
//		for(int i = 0; i < N; i++) {
//			A[i] = Integer.parseInt(input[i]);
//		}
//		
//		if(N == 1) {
//			System.out.println(Math.abs(S - A[0]));
//			return ;
//		}
//		
//		int currentLocation = S;
//		int result = 0;
//		for(int i = 0; i < N - 1; i++) {
//			int tmp = currentLocation - A[i];
//			currentLocation = A[i];
//			result = GCD(Math.abs(tmp), Math.abs(currentLocation - A[i + 1]));
//		}
//		System.out.println(result);
	}

}
