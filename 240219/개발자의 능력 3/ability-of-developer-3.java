import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int [] p = new int[6];
        int allStats = 0;
        int diff = 0;
        int answer = Integer.MAX_VALUE;

        for(int i = 0; i < 6; i++){
            p[i] = sc.nextInt();
            allStats += p[i];
        }

        for(int i = 0; i < 4; i++){
            
            for(int j = i + 1; j < 5; j++){
                for(int k = j + 1; k < 6; k++){
                    int team = p[i] + p[j] + p[k];
                    diff = Math.abs(allStats - team);
                    answer = Math.min(answer, Math.abs(diff - team));
                }

            }
        }
        System.out.println(answer);
    }
}