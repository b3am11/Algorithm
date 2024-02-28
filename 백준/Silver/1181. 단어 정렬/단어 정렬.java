import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        //문자열 길이 비교
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) { //문자열 길이가 같다면
                    return o1.compareTo(o2); //사전순 정렬
                } else {
                    return o1.length() - o2.length(); //문자열 길이 다르면 짧은 문자열이 먼저 오도록 정렬
                }
            }
        });

        //중복된 문자 제거 ==> HashSet 사용해도 됨
        //중복체크를 안 해서 틀렸음

        System.out.println(words[0]); //먼저 처음 단어를 받아준다

        for (int i = 1; i < n; i++) { //이후 2번째 단어부터 중복 체크
            if (!words[i].equals(words[i - 1])) {
                System.out.println(words[i]);
            }
        }
    }
}