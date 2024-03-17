import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        // n 입력받기
        int n = sc.nextInt();
        List<Integer> nums = new ArrayList<>();

        //최대값의 위치
        int index = Integer.MIN_VALUE;
        int value = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            nums.add(a);
            if (value < a) {
                index = i;
                value = a;
            }
        }

        int cnt = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= index; j--) {
                if (nums.get(0) > nums.get(j)) {
                    nums.add(j + 1, nums.get(0));
                    nums.remove(0);
                    cnt++;
                    index = nums.indexOf(value);
                    break;
                }else if (j == index) {
                    nums.add(index + 1, nums.get(0));
                    nums.remove(0);
                    cnt++;
                    index = nums.indexOf(value);
                    break;
                }
            }

            boolean isSorted = true;
            for (int j = 1; j < nums.size(); j++) {
                if (nums.get(j) < nums.get(j - 1)) {
                    isSorted = false;
                    break;
                }
            }
            if (isSorted) {
                break;
            }
        }
        System.out.println(cnt);
    }
}