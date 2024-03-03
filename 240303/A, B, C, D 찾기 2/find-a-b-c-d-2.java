import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static final int MAX_N = 15;
    public static final int MAX_A = 40;

    public static int[] arr = new int[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        for (int i = 0; i < MAX_N; i++) {
            arr[i] = sc.nextInt();
        }
        for (int a = 1; a <= MAX_A; a++) {
            for (int b = a; b <= MAX_A; b++) {
                for (int c = b; c <= MAX_A; c++) {
                    for (int d = c; d <= MAX_A; d++) {
                        int[] arr2 = new int[]{a, b, c, d, a + b, b + c, c + d, d + a,
                                a + c, b + d, a + b + c, a + b + d, a + c + d, b + c + d,
                                a + b + c + d};

                        Arrays.sort(arr2, 0, MAX_N);
                        Arrays.sort(arr, 0, MAX_N);
                        boolean issame = true;

                        for (int i = 0; i < MAX_N; i++) {
                            if (arr[i] != arr2[i])
                                issame = false;
                        }
                        if (issame)
                            System.out.print(a + " " + b + " " + c + " " + d);
                    }
                }
            }
        }
    }
}