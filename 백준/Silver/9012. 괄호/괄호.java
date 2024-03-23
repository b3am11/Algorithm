import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            sb.append(result(br.readLine())).append('\n');
        }

        System.out.println(sb);
    }

    public static String result(String str) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);

            // 여는 괄호일 경우 스택에 넣는다.
            if (c == '(') {
                stack.push(c);
            }

            // 스택이 비어있는 경우. 즉, 닫는 괄호를 입력받았으나 pop 할 수 없는 경우
            else if (stack.empty()) {
                return "NO";
            }
            // 그 외의 경우 stack을 pop 한다.
            else {
                stack.pop();
            }
        }

        /*
         * 모든 검사 마치고 스택에 잔여 요소가 있으면 "NO"
         * 스택이 비어있으면 "YES"
         */

        if (stack.empty()) {
            return "YES";
        }
        else {
            return "NO";
        }
    }
}