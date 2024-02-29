import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int num = Integer.parseInt(br.readLine());
       Queue<Integer> queue = new LinkedList<>();

       for(int i = 1; i <= num; i++) { //num 포함으로 적기 주의
           queue.offer(i); //queue 꽉 찼을 때 add는 예외 반환, offer은 false 반환
       }

       while(queue.size() > 1) { // 1개 남을 때까지 실행
           queue.poll(); //맨 앞 값버림
           int temp = queue.poll(); //2번째 값 담기
           queue.offer(temp); //담긴 두번째 값 맨 뒤로 보내기
       }
       System.out.println(queue.poll());
   }
}