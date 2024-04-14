import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0; // 필요한 개수

        while (N > 0) {
            if (N % 5 == 0) {
                count += N / 5;
                System.out.println(count);
                return;
            } else { // 5킬로그램으로 못 채울 때 3킬로그램으로 채울 수 있는지 확인
                N -= 3; // 3킬로그램 봉지를 사용
                count++;
            }
        }
        if (N < 0) {
            count = -1;
        }
        System.out.println(count);
    }
}
