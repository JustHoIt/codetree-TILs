import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = i + 1;
        }

        boolean a = false;
        Arrays.sort(nums, Comparator.comparingInt((int[] o) -> o[0]));

        int cnt = 0;
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (num == nums[i][0]) { 
                continue;
            }
            num = nums[i][0];
            cnt++;

            if (cnt == 2) {
                if(i + 1 < n && nums[i+1][0] == num){
                    num = -1;
                }else{
                    num = nums[i][1];
                }
                break;
            }
        }

        if(cnt != 2){
            num = -1;
        }

        System.out.println(num);
    }
}