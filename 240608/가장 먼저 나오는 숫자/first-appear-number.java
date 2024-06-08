import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static int n, m;
    static int [] arr;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < m; i++) {
            int num = sc.nextInt();
            int result = binaryS(num);
            System.out.println(result);
        }
    }

    public static int binaryS(int x) {
        int low  = 0; 
        int high = n - 1;
        int result = -1;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(arr[mid] == x) {
                result = mid;
                high = mid - 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return (result == -1) ? -1 : result + 1;
    }
}