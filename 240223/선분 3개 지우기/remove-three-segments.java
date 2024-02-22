import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] line = new int[n][2];
        int [] coordinate = new int [101];
        for(int i = 0; i < n; i++){
            line[i][0] = sc.nextInt();
            line[i][1] = sc.nextInt();
            for(int j = line[i][0]; j <= line[i][1]; j++){
                coordinate[j]++;
            }
        }

        int cnt = 0;

        for(int i = 0; i < n - 2; i++){
            for(int j = i + 1; j < n - 1; j++){
                for(int k = j + 1; k < n; k++){
                    for(int l = line[i][0]; l <= line[i][1]; l++){
                        coordinate[l]--;
                    }
                    for(int l = line[j][0]; l <= line[j][1]; l++){
                        coordinate[l]--;
                    }
                    for(int l = line[k][0]; l <= line[k][1]; l++){
                        coordinate[l]--;
                    }

                    boolean flag = true;
                    for(int l = 0; l <= 100; l++){
                        if(coordinate[l] > 1){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        cnt++;
                    }
                    for(int l = line[i][0]; l <= line[i][1]; l++){
                        coordinate[l]++;
                    }
                    for(int l = line[j][0]; l <= line[j][1]; l++){
                        coordinate[l]++;
                    }
                    for(int l = line[k][0]; l <= line[k][1]; l++){
                        coordinate[l]++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}