import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] icebergs = new int[n];
        for (int i = 0; i < n; i++) {
            icebergs[i] = sc.nextInt();
        }

        //빙산 최대 높이 찾기
        int maxHigh = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxHigh = Math.max(maxHigh, icebergs[i]);
        }
        int maxCnt = Integer.MIN_VALUE;

        for (int i = 1; i < maxHigh; i++) {
            boolean block = false;
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if(icebergs[j] > i){
                    if(block){
                        continue;
                    }
                    block = true;
                    cnt++;
                }else{
                    block = false;
                }
            }
            maxCnt = Math.max(cnt, maxCnt);
        }
        System.out.println(maxCnt);
    }
}