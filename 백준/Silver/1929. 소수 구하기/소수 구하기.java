import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    //소수 구하기는 에라토스테네스체로 풀기
    /**
     * 소수는 1보다 큰 자연수 중 자기 자신만을 약수로 갖는 자연수를 의미한다. (그 반대는 합성수)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer M = Integer.parseInt(st.nextToken());
        Integer N = Integer.parseInt(st.nextToken());
        boolean [] prime = new boolean[N+1]; //N까지 구하기

        /**
         * o과 1은 소수가 아니기 때문에 true 설정, 2부터 시작
         * Math.sqrt() : 주어진 숫자의 제곱근을 계산
         * prime.length = N+1
         */
        prime[0] = prime[1] = true; //true = 소수 아님, false = 소수

        for(int i = 2; i <= Math.sqrt(prime.length); i++) {
            if(prime[i]) continue;
            for(int j = i * i; j < prime.length; j+= i) {
                prime[j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = M; i < N+1; i++) {
            //false = 소수
            if(!prime[i]) sb.append(i).append('\n');
        }

        System.out.println(sb);
    }

}