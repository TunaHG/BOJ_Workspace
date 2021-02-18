package Basic2.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10973 {
    public static void permutation(int[] arr) {
        int N = arr.length;
        boolean flag = true;
        A: for(int i = N - 1; i > 0; i--) {
            if(arr[i - 1] > arr[i]) {
                for(int j = N - 1; j >= i; j--) {
                    if(arr[i - 1] > arr[j]) {
                        int tmp = arr[i - 1];
                        arr[i - 1] = arr[j];
                        arr[j] = tmp;
                        int k = N - 1;
                        while(i < k) {
                            int tmp1 = arr[i];
                            arr[i] = arr[k];
                            arr[k] = tmp1;
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
            for(int i = 0; i < N; i++) {
                System.out.print(arr[i]);
                if(i != N - 1)
                    System.out.print(" ");
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        permutation(arr);
    }
}
