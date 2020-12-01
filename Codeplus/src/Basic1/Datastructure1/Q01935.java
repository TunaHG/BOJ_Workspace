package Basic1.Datastructure1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q01935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Double> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		double[] operand = new double[N];
		String notation = br.readLine();
		
		for(int i = 0; i < N; i++) {
			operand[i] = Double.parseDouble(br.readLine());
		}
		
		double num1 = 0;
		double num2 = 0;
		for(int i = 0; i < notation.length(); i++) {
			switch(notation.charAt(i)) {
			case '+':
				num1 = stack.pop();
				num2 = stack.pop();
				stack.push(num1 + num2);
				break;
			case '-':
				num1 = stack.pop();
				num2 = stack.pop();
				stack.push(num2 - num1);
				break;
			case '/':
				num1 = stack.pop();
				num2 = stack.pop();
				stack.push(num2 / num1);
				break;
			case '*':
				num1 = stack.pop();
				num2 = stack.pop();
				stack.push(num1 * num2);
				break;
			default:
				stack.push(operand[notation.charAt(i) - 'A']);
				break;
			}
		}
		double result = stack.pop();
		System.out.println(String.format("%.2f", result));
	}

}
