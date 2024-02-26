import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt(); //nextInt() 메서드는 정수를 읽고 개행 문자(\n)를 남겨둠
        //scanner.nextLine(); // 쓰려면 개행 문자를 소비해줘야 함 혹은, next()로 문자열을 직접 읽어온다.
        String str = scanner.next();

        int sum = 0;

        for(int i = 0; i < count; i++) {
            sum += str.charAt(i) - 48; //아스키 코드로 계산 안 되게 조심할것 48이나 '0' 빼주기
        }
        System.out.println(sum);
    }
}