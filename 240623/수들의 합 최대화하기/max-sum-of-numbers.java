import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static int n, max;
    public static int[][] arr = new int[11][11];
    public static boolean[] col = new boolean[11];
    public static ArrayList<Integer> sum = new ArrayList<>();

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=1; i<=n; i++)
            for(int j=1; j<=n; j++)
                arr[i][j] = sc.nextInt();

        solution(1);
        System.out.println(max);
    }

    public static void solution(int row){
        if(row == n+1){
            int cnt = 0;
            for(int i=0; i<sum.size(); i++){
                cnt += sum.get(i);
            }
            max = Math.max(max, cnt);
            return ;
        }

        for(int j=1; j<=n; j++) {
            if(!col[j]){
                sum.add(arr[row][j]);
                col[j] = true;
                solution(row + 1);
                sum.remove(sum.size() - 1);
                col[j] = false;
            }
        }
    }
}