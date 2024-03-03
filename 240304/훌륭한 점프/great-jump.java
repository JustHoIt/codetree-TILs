import java.util.Scanner;

public class Main {
    static int n, k;
    static int[] array;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        k = scanner.nextInt();
        array = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            array[i] = scanner.nextInt();
        }

        search(1, array[1]);

        System.out.println(answer);
    }

    static void search(int index, int max) {
        if (index == n) {
            answer = Math.min(answer, max);
            return;
        }

        for (int i = 1; i <= k; i++) {
            if (index + i <= n) {
                search(index + i, Math.max(max, array[index + i]));
            }
        }
    }
}