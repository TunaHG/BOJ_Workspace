package Basic1.Math1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q11576 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		int A = Integer.parseInt(input[0]);
		int B = Integer.parseInt(input[1]);
		
		int m = Integer.parseInt(br.readLine());
		
		String[] eachNumbers = br.readLine().split(" ");
		
		int decimal = 0;
		int multiple = 1;
		for(int i = 1; i <= m; i++) {
			decimal += (Integer.parseInt(eachNumbers[m - i]) * multiple);
			multiple *= A;
		}

		Stack<Integer> stack = new Stack<>();
		while(decimal >= B) {
			stack.push(decimal % B);
			decimal /= B;
		}
		stack.push(decimal);
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
			if(stack.size() != 0)
				System.out.print(" ");
		}
	}

}
