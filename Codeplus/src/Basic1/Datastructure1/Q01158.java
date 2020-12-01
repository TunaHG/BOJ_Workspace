package Basic1.Datastructure1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q01158 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int N = scan.nextInt();
		int K = scan.nextInt();
		
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		int idx = 1;
		sb.append("<");
		while(!queue.isEmpty()) {
			if(idx % K == 0) {
				sb.append(queue.poll() + ", ");
			}
			else {
				queue.add(queue.poll());
			}
			idx++;
		}
		sb.replace(sb.length() - 2, sb.length() - 1, ">");
		System.out.println(sb.toString());
		scan.close();
	}

}
