package Basic1.Datastructure1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q10866 {
	static int[] deque;
	public static void push_front(int num) {
		int[] tmp = deque.clone();
		deque = new int[tmp.length + 1];
		deque[0] = num;
		for(int i = 1; i < deque.length; i++) {
			deque[i] = tmp[i - 1];
		}
		return ;
	}
	public static void push_back(int num) {
		int[] tmp = deque.clone();
		deque = new int[tmp.length + 1];
		for(int i = 0; i < deque.length - 1; i++) {
			deque[i] = tmp[i];
		}
		deque[deque.length - 1] = num;
		return ;
	}
	public static int pop_front() {
		if(deque.length == 0)
			return -1;
		int[] tmp = deque.clone();
		deque = new int[tmp.length - 1];
		for(int i = 0; i < deque.length; i++) {
			deque[i] = tmp[i + 1];
		}
		return tmp[0];
	}
	public static int pop_back() {
		if(deque.length == 0)
			return -1;
		int[] tmp = deque.clone();
		deque = new int[tmp.length - 1];
		for(int i = 0; i < deque.length; i++) {
			deque[i] = tmp[i];
		}
		return tmp[tmp.length - 1];
	}
	public static int size() {
		return deque.length;
	}
	public static int empty() {
		if(deque.length == 0)
			return 1;
		return 0;
	}
	public static int front() {
		if(deque.length == 0)
			return -1;
		return deque[0];
	}
	public static int back() {
		if(deque.length == 0)
			return -1;
		return deque[deque.length - 1];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		deque = new int[0];
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(N-- > 0) {
			String[] command = br.readLine().split(" ");
			switch(command[0]) {
			case "push_front":
				push_front(Integer.parseInt(command[1]));
				break;
			case "push_back":
				push_back(Integer.parseInt(command[1]));
				break;
			case "pop_front":
				sb.append(pop_front() + "\n");
				break;
			case "pop_back":
				sb.append(pop_back() + "\n");
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
