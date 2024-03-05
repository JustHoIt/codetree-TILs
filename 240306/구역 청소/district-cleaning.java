import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int [] area = new int [101];
        int cnt = 0;

        for(int i = 0; i < 2; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            for(int j = x; j <= y; j++){
                if(area[j] == 0){
                    cnt++;
                }
                area[j] = 1;
            }
        }

        System.out.println(cnt - 1);
    }
}