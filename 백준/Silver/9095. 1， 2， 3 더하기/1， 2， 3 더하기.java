import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 입력 받기

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine()); // 각 테스트 케이스의 정수 n 입력 받기
            int[] dp = new int[n + 1]; // 다이나믹 프로그래밍을 위한 배열 선언

            // 초기값 설정
            dp[0] = 1; // 0을 만드는 방법은 아무것도 선택하지 않는 경우 1가지

            // 다이나믹 프로그래밍으로 경우의 수 계산
            for (int j = 1; j <= n; j++) {
                if (j - 1 >= 0) dp[j] += dp[j - 1]; // 1을 더하는 경우
                if (j - 2 >= 0) dp[j] += dp[j - 2]; // 2를 더하는 경우
                if (j - 3 >= 0) dp[j] += dp[j - 3]; // 3을 더하는 경우
            }

            System.out.println(dp[n]); // 결과 출력
        }

        br.close(); // BufferedReader 닫기
    }
}
