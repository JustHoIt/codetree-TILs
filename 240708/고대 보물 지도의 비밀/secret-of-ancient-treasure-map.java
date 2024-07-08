import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.println(findMaxSum(arr, n, k));
    }

    public static int findMaxSum(int[] arr, int n, int k) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int negativeCount = 0;
        
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            currentSum += arr[right];
            if (arr[right] < 0) negativeCount++;
            
            while (negativeCount > k) {
                if (arr[left] < 0) negativeCount--;
                currentSum -= arr[left];
                left++;
            }
            
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}