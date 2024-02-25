import java.util.Scanner;

public class Main {

    public Character solution(String str) {
        int[] count = new int[26]; // 알파벳은 26개

        //A-Z (65~ ) a-z (97~)
        //알파벳 순서의 int 배열 count 값 증가
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - 'A'; //A를 0번째로 위치 시키기 위해
            count[num]++;
        }

        int max = 0;
        char answer = '?';
        //알파벳 개수(배열 크기) 만큼 반복문 실행
        for (int i = 0; i < count.length; i++) {
            if (max < count[i]) {
                max = count[i];
                answer = (char) (i + 'A');
            } else if (max == count[i]) {
                answer = '?';
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toUpperCase();
        System.out.println(main.solution(str));
    }
}