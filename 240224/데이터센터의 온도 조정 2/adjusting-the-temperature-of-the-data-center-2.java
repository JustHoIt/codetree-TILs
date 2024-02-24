import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 장비 갯수
        int C = sc.nextInt(); // Ta보다 낮을시 작업 수
        int G = sc.nextInt(); // Ta ~ Tb사이일 경우 작업 수
        int H = sc.nextInt(); // Tb보다 높을 시 작업수
        int [][] temperatures = new int[N][2];

        for (int i = 0; i < N; i++) {
            temperatures[i][0] = sc.nextInt();
            temperatures[i][1] = sc.nextInt();
        }

        int maxWork = 0;
        for (int i = 0; i <= 1000; i++) {  //데이터의 온도 범위?
            int cnt = 0;
            for (int j = 0; j < temperatures.length ; j++) {;
                if(i < temperatures[j][0]){
                    cnt += C;
                } else if (i >= temperatures[j][0] && i <= temperatures[j][1]) {
                    cnt += G;
                }else{
                    cnt += H;
                }
            }
            maxWork = Math.max(maxWork, cnt);
        }

        System.out.println(maxWork);
    }
}