import java.util.Scanner;

public class Main {
    static int a, b, c;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.

        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        int sum = 0;
        
        for(int i  = 0; i * a <= c; i++){
            for(int j = 0; j * b <= c - i * a; j++){
                sum = Math.max(sum, i * a + j * b);
            }
        }
        System.out.println(sum);
    }
}