import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // T = 알파벳 갯수
        int a = sc.nextInt(); // a, b 특별한 위치가 존재하는 구간 정하기
        int b = sc.nextInt(); //

        List<Integer> Nx = new ArrayList<>();
        List<Integer> Sx = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            char c = sc.next().charAt(0);
            if (c == 'N') {
                Nx.add(sc.nextInt());
            } else {
                Sx.add(sc.nextInt());
            }
        }

        int cnt = 0;
        for (int i = a; i <= b; i++) {
            int minN = Integer.MAX_VALUE;
            for (int j = 0; j < Nx.size(); j++) {
                minN = Math.min(minN, Math.abs(Nx.get(j) - i));
            }
            int minS = Integer.MAX_VALUE;
            for (int j = 0; j < Sx.size(); j++) {
                minS = Math.min(minS, Math.abs(Sx.get(j) - i));
            }
            
            if (minS <= minN) {
                cnt++;
            }

        }
        System.out.println(cnt);


    }
}