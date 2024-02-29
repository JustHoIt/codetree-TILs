import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        int[] seats = new int[n];
        String s = sc.next();

        for (int i = 0; i < n; i++) {
            seats[i] = s.charAt(i) - '0';
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) { //좌석이 이미 붙어 있을 경우
                if (i + 1 < n && seats[i + 1] == 1) {
                    ans = 1; //좌석의 최대는 1로 잡고 종료.
                    break;
                } else {
                    continue;
                }
            }
            int tmp = Integer.MAX_VALUE;
            List<Integer> indices = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (seats[j] == 1 || i == j) {
                    indices.add(j);
                }
            }
            int m = indices.size();
            for (int j = 0; j < m - 1; j++) {
                tmp = Math.min(tmp, indices.get(j + 1) - indices.get(j));
            }
            ans = Math.max(ans, tmp);
        }
        System.out.println(ans);
    }
}