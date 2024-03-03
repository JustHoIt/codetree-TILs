import java.util.Scanner;

public class Main {
    static int n, k;
    static int[] arr;

    public static boolean isPossible(int a) {
        int idx = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] <= a) {
                if(i - idx > k){
                    return false;
                }
                idx = i;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();  // 5
        k = sc.nextInt();  // 2
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt(); // [2, 3, 5, 4, 1]
        }

        for (int i = Math.max(arr[0], arr[n - 1]); i <= 100 ; i++) {
            if (isPossible(i)) {
                System.out.println(i);
                break;
            }
        }
    }
}