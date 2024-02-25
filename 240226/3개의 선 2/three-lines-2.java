import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int MAX_X = 10;

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] points = new int[n][2];

        for (int i = 0; i < n; i++) {
            points[i][0] = scanner.nextInt();
            points[i][1] = scanner.nextInt();
        }

        for (int i = 0; i <= MAX_X; i++) {
            for (int j = 0; j <= MAX_X; j++) {
                for (int k = 0; k <= MAX_X; k++) {
                    String[] combs = {"xxx", "xxy", "xyx", "yxx", "yyy"};
                    for (String comb : combs) {
                        if (isPossible(comb, new int[]{i, j, k}, points)) {
                            System.out.println(1);
                            System.exit(0);
                        }
                    }
                }
            }
        }

        System.out.println(0);
    }

    private static boolean isPossible(String comb, int[] vals, int[][] points) {
        for (int[] point : points) {
            boolean passed = false;
            for (int i = 0; i < comb.length(); i++) {
                char c = comb.charAt(i);
                int val = vals[i];
                int x = point[0];
                int y = point[1];

                if ((c == 'x' && x == val) || (c == 'y' && y == val)) {
                    passed = true;
                }
            }

            if (!passed) {
                return false;
            }
        }

        return true;
    }
}