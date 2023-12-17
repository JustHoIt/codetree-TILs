import java.util.Scanner;

public class Main {
    public static void solution(int n, int[] arr){
        int minDistance = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            int totalDistance = 0;

            for(int j = 0; j < n; j++){
                int distnace = Math.abs(i - (j + 1));
                totalDistance += distnace * arr[j];
            }

            minDistance = Math.min(minDistance, totalDistance);
        }

        System.out.println(minDistance);
    
    }


    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
    
        solution(n, arr);

    }
}