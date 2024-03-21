import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] box;
    static int[] dx = {0, 0, 1, -1}; // 상하좌우 이동
    static int[] dy = {1, -1, 0, 0}; // 상하좌우 이동

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        box = new int[M][N]; // 토마토 넣을 박스
        Queue<Point> ripe = new LinkedList<>(); // 익은 토마토 위치 큐
        int day = 0; // 일수

        // 배열 값 세팅
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) ripe.offer(new Point(i, j, 0)); // 익은 토마토의 위치 큐에 저장
            }
        }

        while (!ripe.isEmpty()) {
            Point p = ripe.poll();
            day = p.day;

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue; // 범위 체크

                if (box[nx][ny] == 0) { // 익지 않은 토마토가 있다면 익힘
                    box[nx][ny] = 1;
                    ripe.offer(new Point(nx, ny, p.day + 1));
                }
            }
        }

        if (checkAllRipe()) // 모든 토마토가 익었는지 체크
            System.out.println(day);
        else
            System.out.println(-1);
    }

    // 모든 토마토가 익었는지 체크하는 함수
    static boolean checkAllRipe() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (box[i][j] == 0) // 익지 않은 토마토가 있다면
                    return false;
            }
        }
        return true; // 모든 토마토가 익었다면
    }

    static class Point {
        int x, y, day;

        Point(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
}
