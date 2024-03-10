import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] matches = new int[N][2];
        for (int i = 0; i < N; i++) {
            matches[i][0] = sc.nextInt();
            matches[i][1] = sc.nextInt();
        }

        int maxWins = 0;
        for (int rock = 1; rock <= 3; rock++) {
            for (int paper = 1; paper <= 3; paper++) {
                if (rock == paper) continue; 
                int scissors = 6 - rock - paper; 
                if (scissors == rock || scissors == paper) continue;

                int wins = 0;
                for (int[] match : matches) {
                    int first = match[0], second = match[1];
                    if ((first == rock && second == scissors) ||
                        (first == scissors && second == paper) ||
                        (first == paper && second == rock)) {
                        wins++;
                    }
                }

                maxWins = Math.max(maxWins, wins);
            }
        }
        System.out.println(maxWins);
    }
}