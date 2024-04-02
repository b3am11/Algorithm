import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

    
class Time implements Comparable<Time> {
    int s, e;

    public Time(int s, int e) {
    this.s = s;
    this.e = e;
    }
    @Override
    public int compareTo(Time t) {
        if (this.e == t.e) // 종료 시간이 같을 경우 시작 시간으로 비교
        return Integer.compare(this.s, t.s);
    return Integer.compare(this.e, t.e); // 종료 시간 오름차순 정렬
    } 
}

class Main{

    public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    
    ArrayList<Time> arr = new ArrayList<>();
    for (int i = 0; i < N; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        arr.add(new Time(x, y));
        }
        Collections.sort(arr); //종료시간을 기준으로 회의 정렬

        int count = 0; //최대 회의 수
        int et = 0; //종료 시간
        for(Time t : arr) {
            if(t.s >= et) {
                count++;
                et = t.e;
            }
        }
        System.out.println(count);
       
        
    }

}