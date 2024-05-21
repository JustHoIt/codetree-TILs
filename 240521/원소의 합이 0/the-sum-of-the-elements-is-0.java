import java.util.Scanner;
import java.util.HashMap;

public class Main {
    static int n;
    static int [][] arr;

    public static int solution(){ 
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int sum = arr[0][i] + arr[1][j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

         for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int sum = -(arr[2][i] + arr[3][j]);
                cnt += map.getOrDefault(sum, 0);
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[4][n];

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        
        int ans = solution();

        System.out.println(ans);
    }
}