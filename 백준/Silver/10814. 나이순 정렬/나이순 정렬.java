import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        String [][] member = new String[count][2];

        for(int i = 0; i < count; i++) {
            member[i][0] = sc.next(); //나이
            member[i][1] = sc.next(); //이름
        }
        /**
         * 람다식으로 변경
         */
        //Arrays.sort(member, (o1, o2) -> Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]));
        Arrays.sort(member, new Comparator<String[]>() { //배열 정렬, Comparator = 정렬 기준
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]); //오름차순으로 정렬
            }
        });
        for(int i = 0; i < count; i++) {
            System.out.println(member[i][0] + " " + member[i][1]);
        }
    }
}