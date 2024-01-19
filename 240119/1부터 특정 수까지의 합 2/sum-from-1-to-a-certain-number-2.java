import java.util.Scanner;
public class Main {
    public static int solution(int N){
        if(N == 1){
            return 1;
        }
        return solution(N - 1) + N;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(solution(N));
    }
}