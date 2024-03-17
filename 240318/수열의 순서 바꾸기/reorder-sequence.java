import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            boolean flag = false;
            for(int j = i; j < n - 1; j++) {
                if(nums[j] > nums[j + 1]) {
                    flag = true;
                    break;
                }
            }
            if(flag) cnt++;
        }

        System.out.println( cnt);
    }
}