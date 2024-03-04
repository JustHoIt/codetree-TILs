import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int [] bombs = new int[n];

        for(int i = 0; i < n; i++){
            bombs[i] = sc.nextInt();
        }
        int num = 0;
        int max = 0;
        for(int i = 0 ; i < n; i++){
            int cnt = 0;
            for(int j= i + 1; j <= i + k; j++){
                if(j < n){
                    if(bombs[i] == bombs[j]){
                        cnt++;
                    }
                }
            }
            if(max  < cnt){
                max = cnt;
                num = bombs[i];
            }
        }

        System.out.println(num);
    }
}