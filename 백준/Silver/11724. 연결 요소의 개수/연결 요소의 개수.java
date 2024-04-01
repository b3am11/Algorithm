import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int answer;
    static int[][] arr;
    static boolean[] visit;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //정점 개수
        M = Integer.parseInt(st.nextToken()); //간선 개수
        arr = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            //무방향 노드 생성
            arr[x][y] = arr[y][x] = 1;
        }

        //방문한 적 없으면 DFS 실행
        for (int i = 1; i < N + 1; i++) {
            if (!visit[i]) {
                dfs(i);
                answer++;
            }
        }
        System.out.println(answer);

    }

    public static void dfs(int i) {
        visit[i] = true; //방문했으면
        for (int j = 0; j < N + 1; j++) {
            if (!visit[j] && arr[i][j] == 1) {
                dfs(j);
            }
        }
    }


}