import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc =new Scanner(System.in);

        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt(); 
        int answer = 1;

        int[] endDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        while(true){
            if(m1 == m2 && d1 == d2){
                break;
            }
            answer++;

            d1++;

            if(d1 > endDays[m1]){
                m1++;
                if(m1 == 13){
                    m1 = 1;
                }
                d1 = 1;
            }
        }
        System.out.println(answer);
    }
}