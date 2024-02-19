import java.util.Scanner;

public class Main {
    static int[] devStats = new int[6];
    static int[] tmp = new int[6];

    public static void solution(int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            solution(start, mid);
            solution(mid + 1, end);

            int p = start;
            int q = mid + 1;
            int idx = p;

            while (p <= mid || q <= end) {
                if (q > end || (p <= mid && devStats[p] < devStats[q])) {
                    tmp[idx++] = devStats[p++];
                } else {
                    tmp[idx++] = devStats[q++];
                }
            }

            for (int i = start; i <= end; i++) {
                devStats[i] = tmp[i];
            }

        }
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            devStats[i] = sc.nextInt();
        }
        solution(0, 5);

        int numMax = Integer.MIN_VALUE;
        int numMin = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            int num = Math.abs(devStats[i] + devStats[5 - i]);
            if (numMin > num) {
                numMin = num;
            }
            if (numMax < num) {
                numMax = num;
            }
        }
        System.out.println(Math.abs(numMax - numMin));
    }
}