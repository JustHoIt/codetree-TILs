import java.util.Scanner;

public class Main {
    static int cnt;
    public static int solution(int n){
        if(n == 1){
            return cnt;
        }

        if(n % 2 == 0){
            cnt++;
            return solution(n / 2);

        }
        cnt++;
        return solution(n * 3 + 1);
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));

    }
}