import java.util.Scanner;

// 치즈를 먹은 정보를 나타내는 클래스 선언
class Info1{
    int p, m, t;

    public Info1(int p, int m, int t) {
        this.p = p;
        this.m = m;
        this.t = t;
    }
};

// 치즈를 먹은 정보를 나타내는 클래스 선언
class Info2{
    int p, t;

    public Info2(int p, int t) {
        this.p = p;
        this.t = t;
    }
};

public class Main {
    public static final int MAX_N = 50;
    public static final int MAX_D = 1000;
    
    public static int n, m, d, s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();
        m = sc.nextInt();
        d = sc.nextInt();
        s = sc.nextInt();

        Info1[] info1 = new Info1[MAX_D];
        Info2[] info2 = new Info2[MAX_N];

        for(int i = 0; i < d; i++) {
            int p = sc.nextInt();
            int m = sc.nextInt();
            int t = sc.nextInt();
            info1[i] = new Info1(p, m, t);
        }
        
        for(int i = 0; i < s; i++) {
            int p = sc.nextInt();
            int t = sc.nextInt();
            info2[i] = new Info2(p, t);
        }

        int ans = 0;
        
        for(int i = 1; i <= m; i++) {
            int[] time = new int[MAX_N + 1];
            for(int j = 0; j < d; j++) {
                if(info1[j].m != i)
                    continue;
                int person = info1[j].p;
                if(time[person] == 0)
                    time[person] = info1[j].t;
                else if(time[person] > info1[j].t)
                    time[person] = info1[j].t;
            }
            boolean possible = true;

            for(int j = 0; j < s; j++) {
                int person = info2[j].p;
                if(time[person] == 0)
                    possible = false;
                if(time[person] >= info2[j].t)
                    possible = false;
            }
            int pill = 0;
            if(possible) {
                for(int j = 1; j <= n; j++) {
                    if(time[j] != 0)
                        pill++;
                }
            }
            ans = Math.max(ans, pill);
        }
        System.out.print(ans);
    }
}