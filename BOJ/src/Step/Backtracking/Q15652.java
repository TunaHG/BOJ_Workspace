package Step.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q15652 {
	// (BT()에서 사용하기 때문에 전역변수로 선언)
	static int M;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 주어지는 두 값을 입력받음
		String[] str = br.readLine().split(" ");
		// 값의 범위를 의미하는 변수 입력
		M = Integer.parseInt(str[0]);
		// 고르는 값의 개수를 의미하는 변수 입력
		N = Integer.parseInt(str[1]);
		
		// 시작값을 입력하며 재귀함수 호출
		for(int i = 1; i <= M; i++) {
			// 재귀함수 호출
			BT(String.valueOf(i), i, 1);
		}
	}
	
	// 시작값부터 N개를 골라서 출력할 재귀함수
	public static void BT(String str, int num, int size) {
		// N개가 선택되었다면 출력하고 재귀함수 종료
		if(size >= N) {
			System.out.println(str);
			return ;
		}
		
		// 모든값들을 탐색하며 재귀함수 호출
		for(int i = num; i <= M; i++)
			BT(str + " " + i, i, size + 1);
		
	}
}

