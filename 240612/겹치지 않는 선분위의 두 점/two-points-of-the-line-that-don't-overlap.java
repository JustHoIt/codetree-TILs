import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int [][] arr = new int[m][2];
        int max = 0;
        for(int i = 0; i < m; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            max = Math.max(max, arr[i][1]);
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        int left = 0;
        int right = max;

        while(left < right){
            int mid = (left + right + 1) / 2;
            if(solution(arr, n, mid)){
                left = mid;
            }else {
                right = mid - 1;
            }
        }
        System.out.println(left);
    }

     private static boolean solution(int[][] arr, int n, int mid) {
        int count = 0;
        int lastPos = -1;

        for (int[] i : arr) {
            int start = i[0];
            int end = i[1];

            if (lastPos < start) {
                lastPos = start;
            }

            while (lastPos <= end) {
                count++;
                lastPos += mid;
                if (count >= n) {
                    return true;
                }
            }
        }

        return count >= n;
    }

}