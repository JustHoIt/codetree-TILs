import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int day = 11;
        int hour = 11;
        int minute = 11;

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int answer = -1;

        if(((day * 24 * 60) + (hour * 60) + minute) > ((a * 24 * 60) + (b * 60) + c)){
            answer = - 1;
        }else{
            while(true){
                if( day == a && hour == b && minute == c){
                    answer++;
                    break;
                }

                answer++;
                minute++;

                if(minute == 60){
                    hour++;
                    minute = 0;
                }
                if(hour == 24){
                    day++;
                    hour = 0;
                }
            }
        }

        System.out.println(answer);
    }
}