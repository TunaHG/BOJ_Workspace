package Basic2.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q01748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int cnt = 1;
        int divide = 10;
        for(int i = 1; i <= N; i++) {
            if(i / divide == 0) {
                sum += cnt;
            }
            else {
                sum += ++cnt;
                divide *= 10;
            }
        }

        System.out.println(sum);
    }
}
