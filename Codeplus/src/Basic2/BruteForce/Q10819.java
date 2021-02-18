package Basic2.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q10819 {
    static int N, result;
    static int[] arr, answer;
    static boolean[] visited;
    public static void permutation(int count) {
        if(count == N) {
            int sum = 0;
            for(int i = 1; i < N; i++) {
                sum += Math.abs(answer[i] - answer[i - 1]);
            }
            result = Math.max(result, sum);
            return ;
        }

        for(int i = 0; i < N; i++) {
            if(visited[i])
                continue;
            visited[i] = true;
            answer[count] = arr[i];
            permutation(count + 1);
            visited[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        answer = new int[N];
        visited = new boolean[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        permutation(0);
        System.out.println(result);
    }
}