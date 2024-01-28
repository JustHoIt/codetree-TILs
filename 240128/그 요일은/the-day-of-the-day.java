import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        String[] dayOfWeek = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        int[] endDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        Scanner sc = new Scanner(System.in);

        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        String day = sc.next();
        int cnt = 0;
        int week = 0;
        int days = 1;
        int answer = 1;
        while(true){
            if(m1 == m2 && d1 == d2){
                break;
            }
            days++;
            d1++;

            if(d1 > endDays[m1]){
                m1++;
                if(m1 == 13){
                    m1 = 1;
                }
                d1 = 1;
            }
        }
        answer += days / 7;
        cnt = days % 7;

        for(int i = 0; i < cnt; i++){
            if(dayOfWeek[i].equals(day)){
                answer++;
                break;
            }
        }
        System.out.println(answer);
    }
}