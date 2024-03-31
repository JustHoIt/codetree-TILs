import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Integer> a = new ArrayList<>();
    private static int totalBlockCnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        totalBlockCnt = n;

        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }

        simulate(sc);
        simulate(sc);

        System.out.println(totalBlockCnt);
        for (int i = 0; i < totalBlockCnt; i++) {
            System.out.println(a.get(i));
        }
    }

    private static void cutArray(int s, int e) {
        ArrayList<Integer> temp = new ArrayList<>();

        for (int i = 0; i < totalBlockCnt; i++) {
            if (!(s <= i && i <= e)) {
                temp.add(a.get(i));
            }
        }

        totalBlockCnt = temp.size();
        a = new ArrayList<>(temp);
    }

    private static void simulate(Scanner sc) {
        int start = sc.nextInt() - 1;
        int end = sc.nextInt() - 1;
        cutArray(start, end);
    }
}