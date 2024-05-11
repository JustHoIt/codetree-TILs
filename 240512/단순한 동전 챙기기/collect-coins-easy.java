import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static final int MAX_N = 20;

    static int n;
    static String[] s = new String[MAX_N];
    static List<Integer> nums = new ArrayList<>();
    static List<Integer> selected = new ArrayList<>();
    static int[][] loc = new int[10][2];
    static int[] start_loc = new int[2];
    static int[] end_loc = new int[2];
    static int ans = Integer.MAX_VALUE;

    public static void Choose(int idx, int cur, int r, int c) {
        if (selected.size() == 3) {
            ans = Math.min(ans, cur + Math.abs(r - end_loc[0]) + Math.abs(c - end_loc[1]));
            return;
        }
        for (int i = idx; i < nums.size(); i++) {
            selected.add(nums.get(i));
            Choose(i + 1, cur + Math.abs(r - loc[nums.get(i)][0]) + Math.abs(c - loc[nums.get(i)][1]),
                  loc[nums.get(i)][0], loc[nums.get(i)][1]);
            selected.remove(selected.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
            for (int j = 0; j < n; j++) {
                if (s[i].charAt(j) == 'S') {
                    start_loc[0] = i;
                    start_loc[1] = j;
                } else if (s[i].charAt(j) == 'E') {
                    end_loc[0] = i;
                    end_loc[1] = j;
                } else if ('1' <= s[i].charAt(j) && s[i].charAt(j) <= '9') {
                    int num = s[i].charAt(j) - '0';
                    nums.add(num);
                    loc[num][0] = i;
                    loc[num][1] = j;
                }
            }
        }

        Collections.sort(nums);
        Choose(0, 0, start_loc[0], start_loc[1]);
        if (ans == Integer.MAX_VALUE)
            ans = -1;
        System.out.println(ans);
    }
}