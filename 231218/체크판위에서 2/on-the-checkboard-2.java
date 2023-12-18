import java.util.Scanner;

public class Main {

    public static int solution(int R, int C, char[][] arr) {
        int maxCnt = 0;

        for (int i = 0; i < R - 2; i++) {
            for (int j = 0; j < C - 2; j++) {
                for (int k = i + 1; k < R - 1; k++) {
                    for (int l = j + 1; l < C - 1; l++) {
                        if(arr[i][j] != arr[k][l] && arr[i][j] != arr[0][0] && arr[k][l] == arr[0][0] && arr[0][0] != arr[R-1][C-1]){
                            maxCnt++;
                        }
                    }
                }
            }
        }
        return maxCnt;
    }


    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();

        char[][] arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                arr[i][j] = sc.next().charAt(0);
            }
        }

        System.out.println(T.solution(R, C, arr));
    }
}