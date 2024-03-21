import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static boolean[][] check;
	static int[][] arr;
	static int[] moveX = {0, 0, 1, -1};
	static int[] moveY = {1, -1, 0, 0};

	static int count = 0,ans = Integer.MIN_VALUE;
	static Deque<spot> q = new LinkedList<>();

	
	static int N, M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M][N];
		check = new boolean[M][N];
		
		for(int i = 0 ; i < M ; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			
			for(int j = 0 ; str.hasMoreTokens() ; j++) {
				arr[i][j] = Integer.parseInt(str.nextToken());
				if(arr[i][j] == 1)
					q.add(new spot(i,j));
			}
		}
		 bfs();
		loop : for(int i = 0 ; i < M ; i++) {
			for(int j = 0 ; j < N ; j++) {
				//System.out.print(arr[i][j] + " ");
				if(arr[i][j] == 0) {
					ans = 0;
					break loop;
				}else
					ans = Math.max(ans, arr[i][j]);
		}
		}
		
			System.out.println(ans-1);
		}

	public static void bfs() {
		
		while(!q.isEmpty()) {
			spot s = q.poll();
			for (int i = 0; i < 4; i++) {
                int nextX = s.x + moveX[i];
                int nextY = s.y + moveY[i];
                
                if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) {
                    continue;
                }
                if (check[nextX][nextY] || arr[nextX][nextY] < 0) {
                    continue;
                }
                
                q.add(new spot(nextX, nextY));
                if(arr[nextX][nextY] == 0)
                	arr[nextX][nextY] = arr[s.x][s.y] + 1;
                else
                	arr[nextX][nextY] = Math.min(arr[s.x][s.y] + 1, arr[nextX][nextY]);
                
                check[nextX][nextY] = true;
            }
		}
	}
}
class spot{
	int x;
	int y;
	spot(int x, int  y){
		this.x = x;
		this.y = y;
	}
}