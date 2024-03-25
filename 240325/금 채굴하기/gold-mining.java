import java.util.Scanner;

public class Main {
    static int MAX_NUM = 20;
    static int n, m;
    static int [][] grid = new int[MAX_NUM][MAX_NUM];
    public static int getArea(int k){
        return k * k + (k + 1) * (k + 1);
    }

    public static int getGold(int a, int b, int c){
        int num = 0;

         for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(Math.abs(a - i) + Math.abs(b - j) <= c){
                    num += grid[i][j];
                }
            }
         }
         return num;
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        int maxGold = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k <= 2 * (n - 1); k++){
                    int num = getGold(i, j, k);

                    if(num * m >= getArea(k)){
                        maxGold = Math.max(maxGold, num);
                    }
                }
            }
        }
        System.out.println(maxGold);
    }
}