import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public int solution(String str) {
        StringTokenizer st = new StringTokenizer(str, " ");
        int count = st.countTokens();
        return count;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(main.solution(str));
    }
}