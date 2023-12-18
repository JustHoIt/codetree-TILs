import java.util.Scanner;
public class Main {
    public void solution(int N, int[][] arr){
        int maxCoin = Integer.MIN_VALUE;

        for(int i = 0; i < N - 2; i++){
            int coin = 0;
            for(int j = 0; j < N - 2; j++){
                if(arr[i][j] == 1){
                    coin++;
                }
                if(arr[i][j+1] == 1){
                    coin++;
                }
                if(arr[i][j+2] == 1){
                    coin++;
                }
                if(coin> maxCoin){
                    maxCoin = coin;
                }
                coin = 0;
            }
        }
        System.out.println(maxCoin);
    }


    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] arr = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        T.solution(N, arr);
    }
}