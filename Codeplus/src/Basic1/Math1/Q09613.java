package Basic1.Math1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q09613 {
	public static double GCD(double num1, double num2) {
		if(num1 % num2 == 0)
			return num2;
		
		return GCD(num2, num1 % num2);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		double arr[] = {};
		int n = 0;
		String input[] = {};
		double sum = 0;
		while(T-- > 0) {
			input = br.readLine().split(" ");
			n = Integer.parseInt(input[0]);
			
			arr = new double[n];
			
			for(int i = 0; i < n; i++) {
				arr[i] = Double.parseDouble(input[i + 1]);
			}
			
			sum = 0;
			for(int i = 0; i < n - 1; i++) {
				for(int j = i + 1; j < n; j++) {
					sum += GCD(arr[i], arr[j]);
				}
			}
			System.out.printf("%.0f\n", sum);
		}
	}

}
