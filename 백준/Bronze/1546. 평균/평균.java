import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] score = new int[count];
        int max = 0;
        double sum = 0;
        double total = 0;

        // 반복문으로 최댓값 찾기 및 총합 구하기
        for (int i = 0; i < score.length; i++) {
            score[i] = scanner.nextInt();
            //MAX 찾는 부분을 Array.sort 이용하여 찾는 것도 좋을듯함. score[count-1];
            if(max < score[i]) { 
                max = score[i];
            }
            sum += score[i];
        }

        total = sum / max * 100; //최고점을 이용한 점수 구하기
        total = total / count; //새로운 평균

        System.out.println(total);
    }

}