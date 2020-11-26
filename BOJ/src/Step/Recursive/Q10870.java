package Step.Recursive;
import java.util.Scanner;

public class Q10870 {
	public static int fibo(int n) {
		if(n == 1)
			return 1;
		if(n == 0)
			return 0;
		return fibo(n - 1) + fibo(n - 2);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		System.out.println(fibo(n));
	}

}
