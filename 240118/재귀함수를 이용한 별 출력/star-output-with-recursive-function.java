import java.util.Scanner;
public class Main {
    public void solution(int n){
        if(n == 0){
            return;
        }
        solution(n - 1);
        for(int i = 0; i < n; i++){
            System.out.print("*");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        T.solution(n);
    }
}