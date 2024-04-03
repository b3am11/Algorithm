import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] fib0 = new int[41];
            int[] fib1 = new int[41];
            fib0[0] = 1;
            fib0[1] = 0;
            fib1[0] = 0;
            fib1[1] = 1;

            for (int j = 2; j <= N; j++) {
                fib0[j] = fib0[j - 1] + fib0[j - 2];
                fib1[j] = fib1[j - 1] + fib1[j - 2];

            }

            System.out.println(fib0[N] + " " + fib1[N]);

        }
    }
}