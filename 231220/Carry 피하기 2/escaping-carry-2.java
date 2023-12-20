import java.util.Scanner;

public class Main {
    public int solution(int n, int[] arr) {
        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((arr[i] % 10) + (arr[j] % 10) + (arr[k] % 10) < 10 &&
                            ((arr[i] % 100) / 10) + ((arr[j] % 100) / 10) + ((arr[k] % 100) / 10) < 10 &&
                            ((arr[i] % 1000) / 100) + ((arr[j] % 1000) / 100) + ((arr[k] % 1000) / 100) < 10 &&
                            arr[i] / 1000 + arr[j] / 1000 + arr[k] / 1000 < 10) {

                        int idx = arr[i] + arr[j] + arr[k];
                        if (answer < idx) {
                            answer = idx;
                        }
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, arr));
    }
}