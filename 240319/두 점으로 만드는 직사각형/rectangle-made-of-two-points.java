import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int[][] coordinate = new int[2][4];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                coordinate[i][j] = sc.nextInt();
            }
        }
        
        System.out.println(Math.abs((coordinate[1][0] - coordinate[0][3]) * (coordinate[0][0] - coordinate[1][3])));
    }
}