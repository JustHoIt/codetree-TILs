import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int [] arr = new int[n];
        int [] result = new int[m];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < m; i++){
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            for(int j = a; j <= b; j++){
                result[i] += arr[j];
            }
        }

        for(int i = 0; i < m; i++){
            System.out.println(result[i]);
        }
    }
}