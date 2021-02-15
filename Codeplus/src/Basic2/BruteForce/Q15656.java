package Basic2.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q15656 {
    static int[] arr;
    static int[] answer;
    static int M;
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void NM(int count) {
        if(count == M) {
            for(int i : answer)
                sb.append(i + " ");
            sb.append("\n");
            return ;
        }

        for(int i = 0; i < N; i++) {
            answer[count] = arr[i];
            NM(count + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new int[N];
        answer = new int[M];
        input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);

        NM(0);
        System.out.println(sb.toString());
    }
}
