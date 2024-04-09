import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[][] distance;
    static boolean[][] visited;
    static int n, m;
    static final int INF = Integer.MAX_VALUE;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        distance = new int[n][m];
        visited = new boolean[n][m];

        // 도시 정보 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    distance[i][j] = 0; // 시작 지점
                } else {
                    distance[i][j] = INF; // 시작 지점 이외의 지점은 최대값으로 설정
                }
            }
        }

        // BFS 수행
        bfs();

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

    static void bfs() {
        Queue<Point> queue = new ArrayDeque<>();
        
        // 시작 지점을 큐에 추가
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    queue.offer(new Point(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int x = current.x;
            int y = current.y;

            // 상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위를 벗어난 경우 무시
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                
                // 벽이거나 이미 방문한 경우 무시
                if (map[nx][ny] == 0 || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                distance[nx][ny] = distance[x][y] + 1;
                queue.offer(new Point(nx, ny));
            }
        }
    }
}
