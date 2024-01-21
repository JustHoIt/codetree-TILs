import java.util.Scanner;
public class Main {
    public static int solution(int N){
        if(N == 1){
            return 1;
        }else if(N == 2){
            return 2;
        }
        
        return solution(N / 3) + solution(N - 1);
    }


    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(solution(N));

    }
}