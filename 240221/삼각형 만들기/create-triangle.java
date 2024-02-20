import java.util.Scanner;

public class Main {
    static int OFFSET = 10000;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] coordinate = new int[n][2];

        for(int i = 0; i < n; i++){
            coordinate[i][0] = sc.nextInt() + OFFSET;
            coordinate[i][1] = sc.nextInt() + OFFSET;
        }

        int maxSize =Integer.MIN_VALUE;
        for(int i = 0; i < n - 2; i++){
            for(int j = i + 1; j < n - 1; j++){
                for(int k = j + 1; k < n; k++){
                    int size = 0;
                    if((coordinate[i][0] == coordinate[j][0] || coordinate[j][0] == coordinate[k][0] ||coordinate[i][0] == coordinate[k][0]) &&
                    (coordinate[i][1] == coordinate[j][1] || coordinate[j][1] == coordinate[k][1] ||coordinate[i][1] == coordinate[k][1])){
                    int a = coordinate[i][0] * coordinate[j][1] + coordinate[j][0] * coordinate[k][1] + coordinate[k][0] * coordinate[i][1];
                    int b = coordinate[j][0] * coordinate[i][1] + coordinate[k][0] * coordinate[j][1] + coordinate[i][0] * coordinate[k][1];
                    size = Math.abs(a - b);
                    maxSize = Math.max(maxSize, size);
                    }
                }
            }
        }
        System.out.println(maxSize);
    }
}