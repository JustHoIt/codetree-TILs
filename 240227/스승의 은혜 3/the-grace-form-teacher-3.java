import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //학생 수
        int cost = sc.nextInt(); //비용
        int maxCnt = Integer.MIN_VALUE;
        int[][] costs = new int[n][2]; // [][0] : 선물 가격 + 배송비 , [][1] : (선물 가격 / 2) + 배송비

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            costs[i][0] = a + b;
            costs[i][1] = a / 2 + b;
        }

        Arrays.sort(costs, new Comparator<int[]>() { // 첫번째 비용을 기준 으로 정렬 후 같다면 두번째 정렬
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });

        for (int i = 0; i < n; i++) {
            int curCost = cost - costs[i][1];// i를 이용 해서 50% 먹인 비용을 잡아줌
            int cnt = 1;
            for (int j = 0; j < n; j++) {
                if (i != j && curCost > costs[j][0]) {
                    curCost -= costs[j][0];
                    cnt++;
                }
            }
            maxCnt = Math.max(cnt, maxCnt);
        }
        System.out.println(maxCnt);
    }
}