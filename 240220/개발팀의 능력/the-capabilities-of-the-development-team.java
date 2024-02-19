import java.util.Scanner;

public class Main {
    static int N = 5;
    static int [] developers = new int[N];
    static int total = 0;

    public static int getDiff(int i, int j, int k){
        int sum1 = developers[i] + developers[j];
        int sum2 = developers[k];
        int sum3 = total - (sum1 + sum2);

        if(sum1 == sum2 || sum2 == sum3 || sum1 == sum3){
            return total;
        }
        int diff = Math.abs(sum1 - sum2);

        diff = Math.max(diff,Math.abs(sum2 - sum3));
        diff = Math.max(diff,Math.abs(sum1 - sum3));

        return diff;
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < N; i++){
            developers[i] = sc.nextInt();
            total += developers[i];
        }

        int minDiff = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                for(int k = 0; k < N; k++){
                    if(k == i || k == j){
                        continue;
                    }
                    minDiff = Math.min(minDiff, getDiff(i, j, k));
                }
            }
        }

        if(minDiff > 0){
            System.out.println(minDiff);
        }else {
            System.out.println(-1);
        }
    }
}