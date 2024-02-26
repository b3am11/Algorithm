import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //테스트 케이스의 개수
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) { // 테스트 케이스만큼 반복

            //반복 횟수
            int R = scanner.nextInt();
            String S = scanner.next();
            String p = "";

            for (int j = 0; j < S.length(); j++) { //문자별로 반복문 돌리기
                for (int z = 0; z < R; z++) { //R번 반복
                    p += S.charAt(j);
                }
            }
            System.out.println(p);
        }
    }
}