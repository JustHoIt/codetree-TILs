import java.util.Scanner;

public class Main {
    static int m1, m2, d1, d2 ;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        String[] dayOfWeek = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        Scanner sc = new Scanner(System.in);

        m1 = sc.nextInt();
        d1 = sc.nextInt();
        m2 = sc.nextInt();
        d2 = sc.nextInt();


        String day = sc.next();

        int diff = numOfDays();
        int answer = diff / 7;
        int cnt = diff % 7;

        int p = 0;
        for(int i = 0; i < 7; i++){
            if(dayOfWeek[i].equals(day)){
                p = i;
                break;
            }
        }

        for(int i = 0; i < cnt; i++){
            if(dayOfWeek[i].equals(day)){
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static int numOfDays(){
        int[] endDays = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int totalDays = 1;

        while (true){
            if(m1 == m2 && d1 == d2){
                break;
            }
            totalDays++;
            d1++;
            if(d1 > endDays[m1]){
                m1++;
                d1 = 1;
            }
        }
        return totalDays;
    }
}