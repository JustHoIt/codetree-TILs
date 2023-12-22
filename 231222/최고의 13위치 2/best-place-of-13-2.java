import java.util.Scanner;

public class Main {
    static int n;
    static int [][] arr;

    public static int solution(){
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - 2; j++){
                for(int k = 0; k < n; k++){
                    for(int l = 0; l < n - 2; l++){
                        if(i == k && Math.abs(j - l) <= 2){
                            continue;
                        }
                        int cnt1 = arr[i][j] + arr[i][j+1] + arr[i][j+2];
                        int cnt2 = arr[k][l] + arr[k][l+1] + arr[k][l+2];
                        cnt = Math.max(cnt, cnt1 + cnt2);
                    }
                }
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution());
    }
}