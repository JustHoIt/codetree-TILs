import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = sc.nextInt();
        }
        String s = "";
        int cnt = 0;
        while (true) {
            int diff1 = arr[1] - arr[0];
            int diff2 = arr[2] - arr[1];
            if (diff1 == 1 && diff2 == 1) {
                break;
            }

            if (diff1 > diff2) {
                int tmp = arr[1];
                arr[1] = tmp - 1;
                arr[2] = tmp;
                cnt++;
            } else {
                int tmp = arr[1];
                arr[1] = tmp + 1;
                arr[0] = tmp;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}