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
        double x1 = Math.min(coordinate[0][0], Math.min(coordinate[0][2], Math.min(coordinate[1][0], coordinate[1][2])));
        double x2 = Math.max(coordinate[0][0], Math.max(coordinate[0][2], Math.max(coordinate[1][0], coordinate[1][2])));
        double y1 = Math.min(coordinate[0][1], Math.min(coordinate[0][3], Math.min(coordinate[1][1], coordinate[1][3])));
        double y2 = Math.max(coordinate[0][1], Math.max(coordinate[0][3], Math.max(coordinate[1][1], coordinate[1][3])));
        int result = (int) Math.max(Math.pow(x2 - x1, 2), Math.pow(y2 - y1, 2));

        System.out.println(result);
    }
}