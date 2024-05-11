import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(arr, m, 0, 0));
    }

    static int solution(int [] arr, int m, int cur, int idx){
        if(cur == m){
            return idx;
        }

        int ans = 0;
        for(int i = 0; i < arr.length; i++){
            int max = idx ^ arr[i]; 
            ans = Math.max(ans, solution(arr, m, cur + 1, max));
        }
        return ans;
    }
}