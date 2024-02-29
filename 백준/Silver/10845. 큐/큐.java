import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder(); // 결과를 저장하기 위함
        Queue<Integer> q = new LinkedList<>(); //Queue = 인터페이스 / LinkedList = 구현 클래스
        int b = 0; //결과 저장

        for (int i = 0; i < num; i++) {
            StringTokenizer stz = new StringTokenizer(br.readLine()); // 공백으로 분리
            String s = stz.nextToken(); // 명령어
            switch (s) {
                case "push":
                    int n = Integer.parseInt(stz.nextToken()); //다음 토큰을 읽어 정수 변환
                    q.offer(n); //q에 추가
                    break;
                case "pop":
                    if (!q.isEmpty()) b = q.poll(); //q가 비어있지 않으면 맨 앞 요소를 빼냄
                    else b = -1;
                    sb.append(b).append('\n'); //결과 및 줄바꿈 저장
                    break;
                case "size":
                    b = q.size();
                    sb.append(b).append('\n');
                    break;
                case "empty":
                    if (q.isEmpty()) b = 1;
                    else b = 0;
                    sb.append(b).append('\n');
                    break;
                case "front":
                    if (!q.isEmpty()) b = q.peek(); //맨 뒤의 요소를 저장
                    else b = -1;
                    sb.append(b).append('\n');
                    break;
                case "back":
                    if (!q.isEmpty()) b = ((LinkedList<Integer>) q).getLast(); //형변환해서 마지막 거 가져옴
                    else b = -1;
                    sb.append(b).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}