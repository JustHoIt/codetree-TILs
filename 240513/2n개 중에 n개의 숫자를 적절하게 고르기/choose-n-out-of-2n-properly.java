import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n * 2];

        for(int i = 0; i < n * 2; i++){
            arr[i] = sc.nextInt();
        }
        int diff = solution(arr, 0, 0, 0, n);
        System.out.println(diff);
    }

    static int solution(int [] arr, int sum1, int sum2, int idx, int n){
        if(idx == n * 2){
            return Math.abs(sum1 - sum2);
        }

        int diff1 = solution(arr, sum1 + arr[idx], sum2, idx + 1, n);

        int diff2 = solution(arr, sum1, sum2 + arr[idx], idx + 1, n);

        return Math.min(diff1, diff2);
    }
}