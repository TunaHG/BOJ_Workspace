package Basic2.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q15655 {
    static int[] arr;
    static boolean[] visited;
    static int M;
    static int N;
    public static void NM(String str, int index, int count) {
        if(count >= M) {
            System.out.println(str.trim());
            return;
        }

        for(int i = index + 1; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                NM(str + arr[i] + " ", i, count + 1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new int[N];
        visited = new boolean[N];
        input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);

        NM("", -1, 0);
    }
}
