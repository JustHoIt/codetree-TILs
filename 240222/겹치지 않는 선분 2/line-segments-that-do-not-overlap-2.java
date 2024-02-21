import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static int OFFSET = 1000000;
    static int[][] arr;
    static int n;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt() + OFFSET;
            arr[i][1] = sc.nextInt() + OFFSET;
        }

        Arrays.sort(arr, Comparator.comparingInt((int[] o) -> o[0])); //배열을 x값으로 오름차순 정렬

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (solution(i)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static boolean solution(int i) {
        boolean answer = true;
        if (i > 0 && i < n - 1) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i][1] >= arr[j][1]) {
                    answer = false;
                    break;
                }
            }
            for (int j = i - 1; j >= 0; j-- ){
                if (arr[i][1] < arr[j][1]) {
                    answer = false;
                    break;
                }
            }
        } else if (i == 0) { //i가 0일때
            for (int j = i + 1; j < n; j++) {
                if (arr[i][1] >= arr[j][1]) {
                    answer = false;
                    break;
                }
            }
        } else if (i == n - 1) { //1가 배열의 마지막 값
            for (int j = i - 1; j >= 0; j-- ){
                if (arr[i][1] < arr[j][1]) {
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }
}