import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < arr.size(); i++) { // i = 2배할 배열 idx
            arr.set(i, arr.get(i) * 2);

            for (int j = 0; j < arr.size(); j++) { // j =  삭제할 idx
                int sumDiff = 0;
                if (i != j) {
                    int a = arr.remove(j);

                    for (int k = 0; k < arr.size() - 1; k++) {
                        sumDiff += Math.abs(arr.get(k) - arr.get(k + 1));
                    }
                    minDiff = Math.min(minDiff, sumDiff);

                    arr.add(j, a);
                }
            }
            arr.set(i, arr.get(i) / 2);
        }
        System.out.println(minDiff);
    }
}