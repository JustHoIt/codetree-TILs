import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] x = new int[n];
        int [] y = new int[n];

        for(int i = 0; i < n; i++){
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int minSquare = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int minX = Integer.MAX_VALUE;
            int minY = Integer.MAX_VALUE;
            int maxX = Integer.MIN_VALUE;
            int maxY = Integer.MIN_VALUE;
            for(int j = 0; j < n; j++){
                if(i != j){
                    minX = Math.min(minX, x[j]);
                    minY = Math.min(minY, y[j]);
                    maxX = Math.max(maxX, x[j]);
                    maxY = Math.max(maxY, y[j]);
                }
            }
            int square = (maxX - minX) * (maxY - minY);
            minSquare = Math.min(minSquare, square);
        }
        System.out.println(minSquare);
    }
}