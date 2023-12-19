import java.util.Scanner;

public class Main {
    static int n,  answer;

    public void solution(int [] x, int [] y){
        answer = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            int dist = 0;
            int idx = 0;
            for(int j = 0; j < n; j++){
                if(j == i){
                    continue;
                }
                dist += Math.abs(x[idx] - x[j]) + Math.abs(y[idx] - y[j]);
                idx = j;
            }
            answer = Math.min(answer, dist);
        }

    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];

        for(int i = 0; i < n; i++){
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        T.solution(x, y);

        System.out.println(answer);
    }
}