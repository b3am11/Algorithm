import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main  {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> s = new Stack<>();

        int n = Integer.parseInt(br.readLine()); //수열의 길기
        int current = 1; //스택에 넣을 다음수
        StringBuilder sb = new StringBuilder(); //결과를 저장할 빌더
        boolean isPossible = true; //수열 생성 가능 여부
        
        //수열을 확인하면서 스택 조작
        for(int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine()); //목표 수
            if(target >= current) {
                //목표 수를 얻기 위해 스택에 push
                while(current <= target) {
                    s.push(current++); //스택에 push
                    sb.append("+\n"); //push를 기록
                }
                s.pop(); // 목표 수를 스택에서 pop
                sb.append("-\n"); // pop을 기록
            } else {
                // 목표 수가 스택의 맨 위에 있는지 확인
                if (s.peek() == target) {
                    s.pop(); // 스택의 맨 위에 목표 수가 있다면 pop
                    sb.append("-\n"); // pop을 기록
                } else {
                    // 스택의 맨 위에 목표 수가 없다면 불가능
                    isPossible = false;
                    break;
                }
            }
        }
        // 결과 출력
        if (isPossible) {
            System.out.print(sb.toString()); // 가능한 경우 연산 출력
        } else {
            System.out.println("NO"); // 불가능한 경우 "NO" 출력
        }
    }
}