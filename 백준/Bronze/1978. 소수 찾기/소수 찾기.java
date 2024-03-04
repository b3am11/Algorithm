import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringTokenizer stz = new StringTokenizer(br.readLine());

        int num = 0; //총 개수

        for (int i = 0; i < count; i++) {
            int b = Integer.parseInt(stz.nextToken());

            if (isPrime(b)) num++;
        }
        System.out.println(num);
    }

    static boolean isPrime(int num) {
        if (num == 1) return false; //1은 소수가 아님

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}