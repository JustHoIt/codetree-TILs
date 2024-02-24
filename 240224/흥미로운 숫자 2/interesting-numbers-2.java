import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.

        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int[] numCnt;
        int cnt = 0;

        for (int i = x; i <= y; i++) { // x ~ y 값까지  ex) 113
            numCnt = new int[10];
            String s = String.valueOf(i); // s = i / s = "113"
            for (int j = 0; j < s.length(); j++) { // 0 ~ 3 까지
                int a = s.charAt(j) - '0'; // int a = 1
                numCnt[a]++;
            }
            int soloNum = 0;
            int groupNum = 0;
            for (int j = 0; j < numCnt.length; j++) {
                if (numCnt[j] == 1) {
                    soloNum++;
                }
                if (numCnt[j] > 1){
                    groupNum++;
                }
            }
            if (soloNum == 1 && groupNum == 1) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}