import java.util.Scanner;

public class Main {
    static int cnt = 0;
    public static int solution(int N){
        if(N == 1){
            return cnt;
        }
        if(N % 2 == 0){
            cnt++;
            return solution(N / 2);
        }else{
            cnt++;
            return solution(N / 3);
        }
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(solution(N));
    }
}