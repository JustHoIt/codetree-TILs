import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Meeting implements Comparable<Meeting> {
    int s, e;
    
    public Meeting(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Meeting m) {
        return this.e - m.e;
    }
}

public class Main {    
    public static int n;
    public static ArrayList<Meeting> meetings = new ArrayList<>();
    
    public static int ans;

    public static void main(String[] args) {
        //여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            meetings.add(new Meeting(s, e));
        }
        Collections.sort(meetings);
        int lastE = -1;
        for(int i = 0; i < n; i++) {
            int s = meetings.get(i).s;
            int e = meetings.get(i).e;
            if(lastE <= s) {
                ans++;
                lastE = e;
            }
        }

        System.out.print(ans);
    }
}