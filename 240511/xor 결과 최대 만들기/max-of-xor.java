import java.util.Scanner;

public class Main {
    static int n, m;
    static int [] arr;
    static int max = 0;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        solution(0, 0, 0);
        System.out.println(max);
    }

    static void solution(int start, int cnt, int xor){
        if(cnt == m){
            max = Math.max(max, xor);
            return;
        }

        for(int i = start; i < n; i++){
            solution(i + 1, cnt + 1, xor ^ arr[i]);
        }
    }
}