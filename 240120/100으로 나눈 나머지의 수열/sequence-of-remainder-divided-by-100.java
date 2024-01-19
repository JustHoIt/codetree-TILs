import java.util.Scanner;

public class Main {
    public static int solution(int n){
        if(n == 1){
            return 2;
        }
        if(n == 2){
            return 4;
        }

        return solution(n - 1) * solution(n - 2);
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(solution(N) % 100);
    }
}