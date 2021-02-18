package Basic2.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10972 {
    public static void permutation(int[] arr) {
        int n = arr.length;
        boolean flag = true;
        A: for(int i = n - 1; i > 0; i--) {
            if(arr[i - 1] < arr[i]) {
                for(int j = n - 1; j >= i; j--) {
                    if(arr[i - 1] < arr[j]) {
                        int tmp = arr[j];
                        arr[j] = arr[i - 1];
                        arr[i - 1] = tmp;
                        int k = n - 1;
                        while(i < k) {
                            int tmp2 = arr[i];
                            arr[i] = arr[k];
                            arr[k] = tmp2;
                            i++;
                            k--;
                        }
                        flag = false;
                        break A;
                    }
                }
            }
        }
        if(flag)
            System.out.println(-1);
        else {
            for(int i = 0; i < n; i++) {
                System.out.print(arr[i]);
                if(i != n - 1)
                    System.out.print(" ");
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        permutation(arr);
    }
}
