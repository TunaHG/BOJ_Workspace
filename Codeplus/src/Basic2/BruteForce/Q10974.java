package Basic2.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10974 {
    static int N;
    static int[] arr;
    static int[] answer;
    static boolean[] visited;
    public static void permutation(int count) {
        if(count == N) {
            for(int i = 0; i < N; i++) {
                System.out.print(answer[i]);
                if(i != N - 1)
                    System.out.print(" ");
            }
            System.out.println();
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
        arr[0] = 1;
        for(int i = 1; i < N; i++) {
            arr[i] = arr[i - 1] + 1;
        }
        visited = new boolean[N];

        permutation(0);
    }
}
