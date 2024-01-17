import java.util.Scanner;

public class Main {
    public void solution(int N){
        if(N == 0){
            return;
        }

        System.out.print(N + " ");
        solution(N - 1);
        System.out.print(N + " ");

    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        T.solution(N);
    }
}