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
            eatenRecords[i][0] = sc.nextInt() - 1;
            eatenRecords[i][1] = sc.nextInt() - 1;
            eatenRecords[i][2] = sc.nextInt();
        }
        for (int i = 0; i < S; i++) {
            sickRecords[i][0] = sc.nextInt() - 1;
            sickRecords[i][1] = sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
            boolean spoilsYn = true;
            for (int j = 0; j < S; j++) {
                boolean flag = false;
                for (int k = 0; k < D; k++) {
                    if (eatenRecords[k][0] == sickRecords[j][0] && eatenRecords[k][2] < sickRecords[j][1]) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    spoilsYn = false;
                    break;
                }
            }
            if (spoilsYn) {
                cheeseCond[i] = 1;
            }
        }
        for (int i = 0; i < D; i++) {
            if (cheeseCond[eatenRecords[i][1]] == 1 && eatenRecords[i][2] < 101) {
                personCond[eatenRecords[i][0]] = 1;
            }
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (personCond[i] == 1) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}