import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        String[] dayOfWeek = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        Scanner sc = new Scanner(System.in);

        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();


        String day = sc.next();

        int diff = numOfDays(m2, d2) - numOfDays(m1, d1);
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

    public static int numOfDays(int m, int d){
        int[] endDays = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int totalDays = 0;

        for(int i = 1; i < m; i++){
            totalDays += endDays[i];
        }
        totalDays += d;

        return totalDays;
    }
}