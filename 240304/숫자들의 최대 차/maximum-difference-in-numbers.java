import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int [] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();    
        }

        Arrays.sort(arr);
        int max = 0;

        for(int i = 0; i < n; i++){
            int cnt = 0;
            for(int j = 0; j < n; j++){
                if(j != i){
                    if(arr[i] <= arr[j] || arr[j] >= arr[i] + k){
                        cnt++;
                    }
                }
                max = Math.max(cnt, max);
            }     
        }
        System.out.println(max);
    }
}