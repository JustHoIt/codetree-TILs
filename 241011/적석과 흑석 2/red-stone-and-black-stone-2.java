import java.util.Scanner;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collections;

class BStone implements Comparable<BStone> {
    int b, a;

    public BStone(int b, int a) {
        this.b = b;
        this.a = a;
    }

    @Override
    public int compareTo(BStone bs) {
        return this.b - bs.b;
    }
}

public class Main {
    public static final int MAX_C = 100000;
    public static int c, n;
    
    public static int[] redStones = new int[MAX_C];
    public static TreeSet<Integer> redS = new TreeSet<>();
    public static ArrayList<BStone> blackStones = new ArrayList<>();

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        n = sc.nextInt();
        for(int i = 0; i < c; i++){
            redStones[i] = sc.nextInt();
        }
        
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            blackStones.add(new BStone(b, a));
        }

        for(int i = 0; i < c; i++){
            redS.add(redStones[i]);
        }

        Collections.sort(blackStones);
        int ans = 0;
        for(int i = 0; i < n; i++) {
            int a = blackStones.get(i).a;
            int b = blackStones.get(i).b;

            if(redS.ceiling(a) != null) {
                int ti = redS.ceiling(a);
                if(ti <= b) {
                    ans++;
                    redS.remove(ti);
                }
            }
        }
        System.out.print(ans);
    }
}