import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 좌석의 수 입력 받기
        String s = sc.next();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.charAt(i) - '0';
        }

        int ans = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;

                // getMinDiff 로직을 여기에 직접 포함
                int cnt = 0;
                int minDiff = Integer.MAX_VALUE;
                boolean isFirst = true;
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] == 1) {
                        if (isFirst) {
                            isFirst = false;
                        } else {
                            minDiff = Math.min(minDiff, cnt);
                        }
                        cnt = 0;
                    }
                    cnt++;
                }

                ans = Math.max(minDiff, ans);
                arr[i] = 0;
            }
        }

        System.out.println(ans);
    }
}