import java.util.Scanner;
import java.util.Arrays;

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

        Arrays.sort(arr);

        for(int i = 0; i < m; i++){
            int left = 0;
            int right = n - 1;
            int idx = -1;
            int target = sc.nextInt();
            while(left <= right ){
                int mid = (left + right) / 2;
                if(arr[mid] == target) {
                    idx = mid + 1;
                    break;
                }

                if(arr[mid] > target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            System.out.println(idx);  
        }
    }
}