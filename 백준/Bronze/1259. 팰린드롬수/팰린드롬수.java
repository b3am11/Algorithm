import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       while (true) {
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