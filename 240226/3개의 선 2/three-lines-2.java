import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        int result = 0;

        for (int i = 0; i <= 10; i++) {
            for (int j = i; j <= 10; j++) {
                for (int k = 0; k <= 10; k++) {
                    for (int l = k; l <=  10; l++) {
                        boolean cover = true;
                        for (int[] a : arr) {
                            if (!(i <= a[0] && a[0] <= j && k <= a[1] && a[1] <= l)) {
                                cover = false;
                                break;
                            }
                        }
                        if (cover) {
                            result = 1;
                            break;
                        }
                    }
                    if(result == 1){
                        break;
                    }
                }
                if(result == 1){
                    break;
                }

            }
            if(result == 1){
                break;
            }
        }
        System.out.println(result);
    }
}