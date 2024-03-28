import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        /**
         * 동적 프로그래밍 문제 해결 순서
         * 1. 테이블 정의하기
         * 2. 점화식 찾기
         * 3. 초기값 설정
         */

        int[] dy = new int[N + 1]; // 1로 만드는데 필요한 최소 연산 횟수 저장
        dy[0] = dy[1] = 0; // 0과 1은 이미 1로 만들어진 상태이므로 연산 횟수가 0

        // Bottom-up 방식의 다이나믹 프로그래밍을 이용하여 dy 배열을 채움
        for (int i = 2; i <= N; i++) {
            dy[i] = dy[i - 1] + 1; //먼저 1을 빼준다.

            // 현재 수가 2로 나누어 떨어지는 경우, 2로 나눈 수에서 1을 더하는 연산과 현재 수에서 1을 빼는 연산 중 더 작은 횟수를 선택
            if (i % 2 == 0) dy[i] = Math.min(dy[i], dy[i / 2] + 1);
            if (i % 3 == 0) dy[i] = Math.min(dy[i], dy[i / 3] + 1);

        }
        System.out.println(dy[N]);
    }
}