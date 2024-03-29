import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    /**
     * 그리디 알고리즘 (탐욕 알고리즘)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 사람 수
        int[] times = new int[N]; // 각 사람의 인출 시간

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times); // 인출 시간을 오름차순으로 정렬

        int totalTime = 0; //총 소요시간
        int watingTime = 0; //대기 시간

        // 각 사람이 돈을 인출하는데 필요한 시간의 합
        for (int time : times) {
            watingTime += time; //대기 시간 누적
            totalTime += watingTime; //총 소요시간 누적
        }
        System.out.println(totalTime);

    }

}