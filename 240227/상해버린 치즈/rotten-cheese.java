import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 사람의 수
        int M = sc.nextInt(); // 치즈의 수
        int D = sc.nextInt(); // 먹은 기록의 수
        int S = sc.nextInt(); // 아픈 기록의 수
        int[][] eatenRecords = new int[D][3]; // 먹은 기록
        int[][] sickRecords = new int[S][2]; //아픈 기록
        int[] cheeseCond = new int[M]; // 치즈 상태
        int[] personCond = new int[N]; // 사람 상태

        for (int i = 0; i < D; i++) {
            eatenRecords[i][0] = sc.nextInt();
            eatenRecords[i][1] = sc.nextInt();
            eatenRecords[i][2] = sc.nextInt();
        }

        for (int i = 0; i < S; i++) {
            sickRecords[i][0] = sc.nextInt();
            sickRecords[i][1] = sc.nextInt();
        }


        for (int i = 0; i < S; i++) {
            for (int j = 0; j < D; j++) {
                if (eatenRecords[j][2] < sickRecords[i][1] && eatenRecords[j][0] == sickRecords[i][0]) {
                    // 아픈 시간 보다 빠르고 아픈 사람이 동일 하다면
                    cheeseCond[eatenRecords[j][1] - 1]++; // 해당하는 치즈번호 + 1 해주기
                }
            }
        }
        int cnt = 0;
        for(int i = 0; i < cheeseCond.length; i++){
            for(int j = 0; j < D; j++){
                if(cheeseCond[i] == S){
                    if(i == eatenRecords[j][1]){
                        personCond[eatenRecords[j][0] - 1]++; // 해당 하는 사람 + 1해주기
                    }
                }
            }
        }
        for(int i = 0; i < personCond.length; i++){
            if(personCond[i] >= 1){
                cnt++;
            }
        }
        
        System.out.println(cnt);
    }
}