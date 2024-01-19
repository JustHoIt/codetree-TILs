import java.util.Scanner;

public class Main {
    static int [] arr;

    public static int solution(int N){
        if(N== 0){
            return arr[0];
        }
        return Math.max(solution(N - 1), arr[N]);

    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(N - 1));
    }
}