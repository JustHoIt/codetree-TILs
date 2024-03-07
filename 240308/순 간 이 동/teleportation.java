import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        if(A > B){
            int temp = A;
            A = B;
            B = temp;
        }

        if(x > y){
            int temp = x;
            x = y;
            y = temp;
        }

        int distance1 = B - A;
        int distance2 = Math.abs(A - x) + Math.abs(B - y);

        System.out.println(Math.min(distance1, distance2));
    }
}