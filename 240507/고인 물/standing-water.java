import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n이 실제로 계산에 사용되지 않음
        int m = sc.nextInt();

        int [] blocks = new int[m];

        for(int i = 0; i < m; i++){
            // 벽의 크기 행을 입력 받는다.
            blocks[i] = sc.nextInt();
        }

        int [] lMax = new int[m];
        lMax[0] = blocks[0];
        for(int i = 1; i < m; i++){
            lMax[i] = Math.max(lMax[i - 1], blocks[i]);
        }
        
        int [] rMax = new int [m];
        rMax[m - 1] = blocks[m - 1];
        for(int i = m - 2; i >= 0; i--){
            rMax[i] = Math.max(rMax[i + 1], blocks[i]);
        }

        int cnt = 0;

        for(int i = 0; i < m; i++){
            cnt += Math.min(lMax[i], rMax[i]) - blocks[i];
        }

        System.out.println(cnt);
    }
}