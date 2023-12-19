import java.util.Scanner;

public class Main {
    static int n,  answer;

    public void solution(int [] arr){
        answer = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            int dist = 0;
            for(int j = 0; j < n; j++){
                int idx = (j + n - i) % n;
                dist += idx * arr[j];
            }
            answer = Math.min(answer, dist);
        }
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        T.solution(arr);
        System.out.println(answer);
    }
}