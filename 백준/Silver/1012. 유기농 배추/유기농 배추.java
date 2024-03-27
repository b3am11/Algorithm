import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int T;
    static int M, N;
    static int [][] box;
    static boolean[][] visit; //구역 방문 여부
    static int[] dx = {-1, 1, 0, 0}; //상하 좌우
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        int K = Integer.parseInt(st.nextToken()); //배추의 개수

        box = new int[M][N];
        visit = new boolean [M][N]; //방문한 곳
        
        //배추의 위치 입력받기
        for(int j = 0; j < K; j++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            box[X][Y] = 1; //배추가 있는 위치 1로 표시
        }

        int bugs = 0; //벌레 개수
        for(int x = 0; x < M; x++) {
            for(int y = 0; y < N; y++) {
                if(box[x][y] == 1 && !visit[x][y]) {
                    dfs(x,y);
                    bugs++;
                }
            }
        }
            System.out.println(bugs);

    }
}
    static void dfs(int x, int y) {

        visit[x][y] = true;
        
        for(int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if(cx >= 0 && cy >= 0 && cx < M && cy < N) {
                if(!visit[cx][cy] && box[cx][cy] == 1) {
                    dfs(cx, cy);
                }
            }
        }

    }
}