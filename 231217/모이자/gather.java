import java.util.Scanner;

public class Main {
    public static void solution(int n, int[] arr){
        int minD = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            int totalD = distance(i, arr);
            minD = Math.min(minD, totalD);
        }

        System.out.println(minD);

    }


     public static int distance(int p, int[] arr){
        int totalD = 0;

        for (int i = 0; i < arr.length; i++) {
            totalD += Math.abs(p - i - 1) * arr[i];
        }

        return totalD;
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