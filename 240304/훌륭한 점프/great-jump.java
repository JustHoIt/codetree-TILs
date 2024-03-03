import java.util.Scanner;

public class Main {
    public static int n, k;
    public static int[] arr;

    public static boolean isPossible(int maxVal) {
        int lastPos = 0;

        for(int i = 0; i < n; i++) {
            if(arr[i] <= maxVal) {
                if(i - lastPos > k){
                    return false;
                } 
                lastPos = i;
            }
        }

        return (n - 1 - lastPos <= k);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();   
        }
        int left = arr[0], right = 100;
        int minMax = right;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(isPossible(mid)) {
                minMax = Math.min(minMax, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(minMax);
    }
}