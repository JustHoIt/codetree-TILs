import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int answer = fibo(n);
        System.out.println(answer);
    }

    public static int fibo(int n){
        if(n == 1 || n == 2){
            return 1;
        }else{
            return fibo(n - 2) + fibo(n - 1);
        }
    }
}