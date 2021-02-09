package Basic2.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q14500 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        int[][] arr = new int[N][M];

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        int result = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(j < M - 3)
                    result = Math.max(result, arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i][j + 3]); // 가로 길쭉이
                if(i < N - 3)
                    result = Math.max(result, arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 3][j]); // 세로 길쭉이
                if(i < N - 1 && j < M - 1)
                    result = Math.max(result, arr[i][j] + arr[i + 1][j] + arr[i][j + 1] + arr[i + 1][j + 1]); // 정사각형
                if(i < N - 2) {
                    if(j > 0) {
                        result = Math.max(result, arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i][j - 1]); // L 좌우대칭 + 상하대칭
                        result = Math.max(result, arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 2][j - 1]); // L 좌우대칭
                        result = Math.max(result, arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 1][j - 1]); // ㅓ
                        result = Math.max(result, arr[i][j] + arr[i + 1][j] + arr[i + 1][j - 1] + arr[i + 2][j - 1]); // 계단 1
                    }
                    if(j < M - 1) {
                        result = Math.max(result, arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i][j + 1]); // L 상하대칭
                        result = Math.max(result, arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 2][j + 1]); // L
                        result = Math.max(result, arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 1][j + 1]); // ㅏ
                        result = Math.max(result, arr[i][j] + arr[i + 1][j] + arr[i + 1][j + 1] + arr[i + 2][j + 1]); // 계단 2
                    }
                }
                if(j < M - 2) {
                    if(i > 0) {
                        result = Math.max(result, arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i - 1][j + 2]); // 왼쪽으로 누운 L
                        result = Math.max(result, arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i - 1][j]); // 왼쪽으로 누운 L 좌우대칭
                        result = Math.max(result, arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i - 1][j + 1]); // ㅗ
                        result = Math.max(result, arr[i][j] + arr[i][j + 1] + arr[i - 1][j + 1] + arr[i - 1][j + 2]); // 누운 계단 1
                    }
                    if(i < N - 1) {
                        result = Math.max(result, arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 2]); // 왼쪽으로 누운 L 상하대칭
                        result = Math.max(result, arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j]); // 왼쪽으로 누운 L 좌우대칭 + 상하대칭
                        result = Math.max(result, arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1]); // ㅜ
                        result = Math.max(result, arr[i][j] + arr[i][j + 1] + arr[i + 1][j + 1] + arr[i + 1][j + 2]); // 누운 계단 2
                    }
                }
            }
        }
        System.out.println(result);
    }
}
