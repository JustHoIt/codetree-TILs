import java.util.Scanner;

public class Main {
    public static final int maxV = 1000000;

    public static int[] a_go = new int[maxV];
    public static int[] b_go = new int[maxV];

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int cnt_a = 0;
        for(int i = 0; i < n; i++) {
            int dir = sc.next().equals("L") ? -1 : 1;
            int path = sc.nextInt();

            for(int j = 0; j < path; j++) {
                a_go[cnt_a+1] = a_go[cnt_a] + 1 * dir;  
                cnt_a += 1;
            }              
        }

        int cnt_b = 0;
        for(int i = 0; i < m; i++) {
            int dir = sc.next().equals("L") ? -1 : 1;
            int path = sc.nextInt();

            for(int j = 0; j < path; j++) {
                b_go[cnt_b+1] = b_go[cnt_b] + 1 * dir;  
                cnt_b += 1;
            }              
        }

        int ans = 0;
        for(int i = 1; i < cnt_a; i++) {
            if(a_go[i] == b_go[i]) {
                ans = i;
                break;
            }
        }

        System.out.println(ans == 0 ? -1 : ans);

    }
}