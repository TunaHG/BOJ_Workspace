package Basic1.Datastructure1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q10845 {
	static int[] queue;
	public static void push(int num) {
		int[] tmp = queue.clone();
		queue = new int[tmp.length + 1];
		for(int i = 0; i < tmp.length; i++) {
			queue[i] = tmp[i];
		}
		queue[tmp.length] = num;
		return ;
	}
	public static int pop() {
		if(queue.length == 0)
			return -1;
		int[] tmp = queue.clone();
		queue = new int [tmp.length - 1];
		for(int i = 0; i < queue.length; i++) {
			queue[i] = tmp[i + 1];
		}
		return tmp[0];
	}
	public static int size() {
		return queue.length;
	}
	public static int empty() {
		if(queue.length == 0)
			return 1;
		return 0;
	}
	public static int front() {
		if(queue.length == 0)
			return -1;
		return queue[0];
	}
	public static int back() {
		if(queue.length == 0)
			return -1;
		return queue[queue.length - 1];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		queue = new int[0];
		
		while(N-- > 0) {
			String[] command = br.readLine().split(" ");
			switch(command[0]) {
			case "push":
				push(Integer.parseInt(command[1]));
				break;
			case "pop":
				sb.append(pop() + "\n");
				break;
			case "size":
				sb.append(size() + "\n");
				break;
			case "empty":
				sb.append(empty() + "\n");
				break;
			case "front":
				sb.append(front() + "\n");
				break;
			case "back":
				sb.append(back() + "\n");
				break;
			}
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());
	}

}
