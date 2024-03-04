import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /**
     *
     * 시간 초과 오류가 발생하였음.
     * HashSet = O(1)이라는 시간 복잡도 존재
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        StringTokenizer stz = new StringTokenizer(num);
        int n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());

        ArrayList<String> result = new ArrayList<>();
        HashSet<String> list = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            list.add(name);
        }

        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            if(list.contains(name)) {
                result.add(name);
            }
        }

        Collections.sort(result);
        System.out.println(result.size());

        for(String s : result) {
            System.out.println(s);
        }
    }
}