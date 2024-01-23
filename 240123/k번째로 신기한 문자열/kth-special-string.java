import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Main {
    static int k;
    static String T;

    public static String solution(int k, String T, String[] arr) {
        String answer = "";

        Arrays.sort(arr);
        List<String> ls = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            String target = arr[i];
            if (target.startsWith(T)) {
                ls.add(target);
            }
        }

        answer = ls.get(k-1);

        return answer;
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        k = sc.nextInt();
        T = sc.next();
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        System.out.println(solution(k, T, arr));
    }
}