import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int b = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            switch (s) {
                case "push":
                    int n = Integer.parseInt(st.nextToken());
                    stack.push(n);
                    break;
                case "pop":
                    if (stack.empty()) b = -1;
                    else b = stack.pop();
                    sb.append(b).append('\n');
                    break;
                case "size":
                    b = stack.size();
                    sb.append(b).append('\n');
                    break;
                case "empty":
                    if (stack.empty()) b = 1;
                    else b = 0;
                    sb.append(b).append('\n');
                    break;
                case "top":
                    if (stack.isEmpty()) b = -1;
                    else b = stack.peek();
                    sb.append(b).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}
