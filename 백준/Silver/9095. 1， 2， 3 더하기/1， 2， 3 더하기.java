import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 입력 받기

    for(int i = 0; i < T; i++) {
        int n = Integer.parseInt(br.readLine()); //테스트 케이스의 정수 n
        int[] dp = new int[11]; //동적 프로그래밍을 위한 배열 선언


        // 초기값 설정
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int j = 4; j <= n; j++) {
            dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
        }

        System.out.println(dp[n]);

    }

    }

}