import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int N; // 수빈이 위치
    static int K; // 동생 위치
    static boolean[] visit = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        }

        int result = bfs(N);

        System.out.println(result);
    }

    public static int bfs(int N) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(N); // 시작 위치 추가
        visit[N] = true; // 시작 위치 방문 처리

        int time = 0; // 이동한 시간

        while (!q.isEmpty()) {
            int size = q.size(); // 현재 큐의 크기

            // 현재 큐의 크기만큼 반복하여 같은 시간에 이동한 위치들을 모두 처리
            for (int i = 0; i < size; i++) {
                int current = q.poll(); // 현재 위치 가져오기

                // 다음 위치들을 계산하여 큐에 추가
                if (current - 1 >= 0 && !visit[current - 1]) {
                    q.offer(current - 1);
                    visit[current - 1] = true;
                }
                if (current + 1 <= 100000 && !visit[current + 1]) {
                    q.offer(current + 1);
                    visit[current + 1] = true;
                }
                if (current * 2 <= 100000 && !visit[current * 2]) {
                    q.offer(current * 2);
                    visit[current * 2] = true;
                }

                // 동생의 위치를 찾았으면 현재 시간 반환
                if (current - 1 == K || current + 1 == K || current * 2 == K) {
                    return time + 1;
                }
            }

            time++; // 시간 증가
        }

        return -1; // 동생을 찾지 못했을 경우
    }
}
