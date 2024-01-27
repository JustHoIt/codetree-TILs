import java.util.Scanner;

public class Main {
    static String p = "";
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
       
        String[] dayOfWeek = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        int diff = numOfDays(m2, d2) - numOfDays(m1, d1);

        while(diff < 0){
            diff += 7;
        }

        System.out.print(dayOfWeek[diff % 7]);
    }

    public static int numOfDays(int m, int d){
        int[] endDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int totalDays = 0;

        for(int i = 1; i < m; i++){
            totalDays += endDays[i];
        }
        totalDays += d;

        return totalDays;
    }
}