import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] xy = new int[n][2];

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            xy[i][0] = Integer.parseInt(st.nextToken()); //첫번째 호출 x
            xy[i][1] = Integer.parseInt(st.nextToken()); //두번째 호출 y
        }

        /**
         * 람다식
         */

//        Arrays.sort(xy, (o1, o2) -> {
//            if(o1[0] == o2[0]) { //첫 번째 열의 값이 서로 같다면
//                return o1[1] - o1[1]; //두 번째 열의 값으로 오름차순 정렬
//            } else { //그렇지 않으면
//                return o1[0] - o1[0]; //첫번째 열의 값으로 오름차순 정렬
//            }
//        });

        Arrays.sort(xy, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) { //첫 번째 열의 값이 서로 같다면
                    return o1[1] - o2[1]; //두 번째 열의 값으로 오름차순 정렬
                } else { //그렇지 않으면
                    return o1[0] - o2[0]; //첫번째 열의 값으로 오름차순 정렬
                }
            }

        });

        StringBuilder sb = new StringBuilder(); //문자열 결합

        for (int i = 0; i < n; i++) {
            sb.append(xy[i][0] + " " + xy[i][1]).append("\n");
        }
        System.out.println(sb);
    }
}