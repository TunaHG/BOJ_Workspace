package Basic2.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class Q15664 {
    static int N, M;
    static int[] arr;
    static int[] answer;
    static LinkedHashSet<String> set;
    public static void NM(int index, int count) {
        if(count == M) {
            StringBuilder sb = new StringBuilder();
            for(int i : answer)
                sb.append(i).append(" ");
            set.add(sb.toString().trim());
            return ;
        }

        for(int i = index + 1; i < N; i++) {
            answer[count] = arr[i];
            NM(i, count + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new int[N];
        input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);
        answer = new int[M];
        set = new LinkedHashSet<>();

        NM(-1, 0);
        for(String str : set)
            System.out.println(str);
    }
}
