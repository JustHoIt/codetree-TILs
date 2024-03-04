import java.util.Scanner;

public class Main {
    static int N;
    static int[] sum, arr;
    static boolean[] visited;
    static boolean isFound;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sum = new int[N];
        arr = new int[N];
        visited = new boolean[N + 1];
        isFound = false;

        for (int i = 0; i < N - 1; i++) {
            sum[i] = sc.nextInt();
        }

        search(0);
    }

    static void search(int depth) {
        if (isFound) {
            return;
        }

        if (depth == N) {
            for (int i = 0; i < N; i++) {
                System.out.print(arr[i]);
                if (i != N - 1) {
                    System.out.print(" ");
                }
            }
            isFound = true;
            return;
        }

        for (int i = 1; i <= N; i++) {
            arr[depth] = i;
            if (check(depth) && !visited[i]) {
                visited[i] = true;
                search(depth + 1);
                visited[i] = false;
            }
        }
    }

    static boolean check(int depth) {
        if (depth == 0) {
            return true;
        }
        if (arr[depth] + arr[depth - 1] != sum[depth - 1]) {
            return false;
        }
        return true;
    }
}