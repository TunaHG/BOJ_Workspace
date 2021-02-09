package Basic2.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q01476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int E = Integer.parseInt(input[0]); // 15
        int S = Integer.parseInt(input[1]); // 28
        int M = Integer.parseInt(input[2]); // 19
        if(E == 15)
            E = 0;
        if(S == 28)
            S = 0;
        if(M == 19)
            M = 0;

        int num = 1;
        while(true) {
            if(num % 15 == E && num % 28 == S && num % 19 == M)
                break;
            num++;
        }

        System.out.println(num);
    }
}
