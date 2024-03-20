import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //첫째 줄
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];

        //둘째줄
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        //오름차순 정렬
        Arrays.sort(num);

        //셋째 줄 (확인할 숫자의 개수)
        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());

            //결과 출력
            sb.append(upperBound(num, key) - lowerBound(num, key)).append(' ');
        }
        System.out.println(sb);
    }

    /**
     * lowerNum와 upperNum을 찾아서 그 차이를 구하면 해당 숫자가 배열에서 등장한 횟수를 구할 수 있음
     */

    //배열에서 처음 등장하는 위치를 찾음
    private static int lowerBound(int[] arr, int n) {
        int lt = 0;
        int rt = arr.length;

        while (lt < rt) {
            int mid = (lt + rt) / 2;
            if (arr[mid] < n) {
                lt = mid + 1;
            } else {
                rt = mid;
            }
        }
        return lt;
    }

    // 숫자가 배열에서 등장하는 끝 위치를 의미함
    private static int upperBound(int[] arr, int n) {
        int lt = 0;
        int rt = arr.length;


        while (lt < rt) {
            int mid = (lt + rt) / 2;
            if (arr[mid] <= n) {
                lt = mid + 1;
            } else {
                rt = mid;
            }
        }
        return lt;
    }
}