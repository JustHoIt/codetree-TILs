import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Jewel implements Comparable<Jewel> {
    int weight, value;

    public Jewel(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
    @Override
    public int compareTo(Jewel j) {
        double x = (double)j.value / j.weight - (double) this.value / this.weight;
        if(x < 0)
            return -1;
        else if(x == 0)
            return 0;
        else
            return 1;
    }
}

public class Main {    
    public static final int MAX_N = 100000;
    public static int n, m;
    public static ArrayList<Jewel> jewels = new ArrayList<>();
    public static double ans;

    public static void main(String[] args) {
        //여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();
            jewels.add(new Jewel(w, v));
        }
        Collections.sort(jewels);

        for(int i = 0; i < n; i++) {
            int w = jewels.get(i).weight;
            int v = jewels.get(i).value;
            if(m >= w) {
                m -= w;
                ans += v;
            } else {
                ans += (double)m / w * v;
                break;
            }
        }
        System.out.printf("%.3f", ans);
    }
}