import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[][] distance;
    static int n, m;
    static final int INF = Integer.MAX_VALUE;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        distance = new int[n][m];

        int startX = -1, startY = -1;

        // 도시 정보 입력 및 시작 지점 찾기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    startX = i;
                    startY = j;
                    distance[i][j] = 0; // 시작 지점
                } else {
                    distance[i][j] = INF; // 시작 지점 이외의 지점은 최대값으로 설정
                }
            }
        }

        // BFS 수행
        bfs(startX, startY);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) { // 벽인 경우
                    sb.append("0 ");
                } else if (distance[i][j] == INF) { // 도달할 수 없는 경우
                    sb.append("-1 ");
                } else { // 최단 거리 출력
                    sb.append(distance[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int sx, int sy) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sx, sy});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위를 벗어난 경우 무시
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                
                // 벽이거나 이미 방문한 경우 무시
                if (map[nx][ny] == 0 || distance[nx][ny] != INF) continue;

                distance[nx][ny] = distance[x][y] + 1;
                queue.offer(new int[]{nx, ny});
            }
        }
    }
}
