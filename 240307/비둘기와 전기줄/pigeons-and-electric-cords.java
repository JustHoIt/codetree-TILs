import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();

        int [][] pigeons = new int[n][2];
        int [] eWires = new int[11];
        
        Arrays.fill(eWires, 2);

        for(int i = 0; i < n; i++){
            pigeons[i][0] = sc.nextInt();
            pigeons[i][1] = sc.nextInt();
        } 
        int move = 0;
        for(int i = 0; i < n; i++){
            int cur = pigeons[i][1];// 비둘기의 현재 위치
            int num = pigeons[i][0] - 1; //비둘기 번호
            if(eWires[num] == 2){ // 
                eWires[num] = cur;
            }else{
                if(eWires[num] != cur){
                    move++;
                    eWires[num] = cur;
                }
            }

        }
        System.out.println(move);
    }
}