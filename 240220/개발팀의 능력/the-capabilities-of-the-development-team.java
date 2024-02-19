import java.util.Scanner;

public class Main {
    static int [] developers = new int[5];
    static int [] tmp = new int[5];
    static int total = 0;
    public static void sort(int start, int end){
        if (start < end) {
            int mid = (start + end) / 2;
            sort(start, mid);
            sort(mid + 1, end);

            int p = start;
            int q = mid + 1;
            int idx = p;

            while (p <= mid || q <= end) {
                if (q > end || (p <= mid && developers[p] < developers[q])) {
                    tmp[idx++] = developers[p++];
                } else {
                    tmp[idx++] = developers[q++];
                }
            }

            for (int i = start; i <= end; i++) {
                developers[i] = tmp[i];
            }

        }
        
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int [] developers = new int[5];

        for(int i = 0; i < 5; i++){
            developers[i] = sc.nextInt();
            total += developers[i];
        }
        sort(0,4);

        int teamA = developers[0] + developers[2];
        int teamB = developers[1] + developers[3];
        int teamC = developers[4];

        int teamMin = Math.min(teamA, Math.min(teamB, teamC));
        int teamMax = Math.max(teamA, Math.min(teamB, teamC));

        if(teamMax != teamMin){
            System.out.println(Math.abs(teamMax - teamMin));
        }else{
            System.out.println("-1");
        }

        

    }
}