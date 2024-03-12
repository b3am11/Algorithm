import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " "); //3개의 수 공백으로 분리

        int a, b, c;

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        //모든 수가 다를 경우
        if (a != b && b != c && a != c) {
            int max;
            
            if (a > b) {
                // c > a > b 라면
                if (c > a) {
                    max = c;
                }
                // a > (b, c)
                else {
                    max = a;
                }
            }
            //b > a
            else {
                if (c > b) {
                    max = c;
                }
                // b > (a, c)
                else {
                    max = b;
                }
            }
            System.out.println(max * 100);
        }
        //적어도 한 쌍 이상의 서로 같은 변수가 존재할 경우
        else {
            //3개의 변수가 모두 같은 경우
            if (a == b && a == c) {
                System.out.println(10000 + a * 1000);
            } else {
                //a가 b 또는 c랑만 같은 경우
                if (a == b || a == c) {
                    System.out.println(1000 + a * 100);
                }
                //b랑 c랑 같은 경우
                else {
                    System.out.println(1000 + b * 100);
                }
            }
        }
    }
}