import java.util.Scanner;

public class Main {
    public void solution(int N){
        if(N == 0){
            return;
        }

        solution(N - 1);
        System.out.print(N + " ");
    }

    public void solution2(int N){
        if(N == 0){
            return;
        }
        System.out.print(N + " ");
        solution2(N - 1);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        T.solution(N);
        System.out.println();
        T.solution2(N);
    }
}