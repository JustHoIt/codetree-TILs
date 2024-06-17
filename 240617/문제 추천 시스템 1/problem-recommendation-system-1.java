import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        TreeSet<Problem> ts = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();
            int difficulty = sc.nextInt();
            ts.add(new Problem(number, difficulty));
        }

        int m = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < m; i++) {
            String[] command = sc.nextLine().split(" ");
            String cmd = command[0];

            if (cmd.equals("ad")) {
                int number = Integer.parseInt(command[1]);
                int difficulty = Integer.parseInt(command[2]);
                ts.add(new Problem(number, difficulty));
            } else if (cmd.equals("sv")) {
                int number = Integer.parseInt(command[1]);
                int difficulty = Integer.parseInt(command[2]);
                ts.remove(new Problem(number, difficulty));
            } else if (cmd.equals("rc")) {
                int x = Integer.parseInt(command[1]);
                if (x == 1) {
                    System.out.println(ts.last().number);
                } else if (x == -1) {
                    System.out.println(ts.first().number);
                }
            }
        }
    }
}

class Problem implements Comparable<Problem> {
    int number;
    int difficulty;

    Problem(int number, int difficulty) {
        this.number = number;
        this.difficulty = difficulty;
    }

    @Override
    public int compareTo(Problem other) {
        if (this.difficulty != other.difficulty) {
            return Integer.compare(this.difficulty, other.difficulty);
        } else {
            return Integer.compare(this.number, other.number);
        }
    }   
}