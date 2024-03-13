import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Game> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String user = sc.next();
            int point = sc.nextInt();
            arr.add(new Game(user, point));
        }

        int[] point = new int[3];
        int cnt = 0;
        String prevRank = "ABC";

        for (int i = 0; i < n; i++) {
            int p = arr.get(i).point;
            if (p == 0) {
                continue;
            }
            if (arr.get(i).user.equals("A")) {
                point[0] += p;
            } else if (arr.get(i).user.equals("B")) {
                point[1] += p;
            } else {
                point[2] += p;
            }

            int maxPoint = Math.max(point[0], Math.max(point[1], point[2]));
            String currentRank = "";
            if(maxPoint == point[0]){
                currentRank += "A";
            }
            if(maxPoint == point[1]){
                currentRank += "B";
            }
            if(maxPoint == point[2]){
                currentRank += "C";
            }
            if(!prevRank.equals(currentRank)){
                cnt++;
                prevRank = currentRank;
            }
        }
        System.out.println(cnt);
    }
}