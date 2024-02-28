import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       while (true) { //입력의 맨 마지막 줄에는 0이 주어지기 때문에 0이 들어올때까지 계속 무한루프
           String str = br.readLine();

           StringBuffer stb = new StringBuffer(str);
           String reverse = stb.reverse().toString();

           if (str.equals("0")) break; //0이면 무시

           if (str.equals(reverse)) {
               System.out.println("yes");
           } else {
               System.out.println("no");
           }
       }
   }
}