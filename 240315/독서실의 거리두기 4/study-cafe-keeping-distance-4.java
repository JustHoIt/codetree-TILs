import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String seats = sc.next();


        int maxDistance = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (seats.charAt(i) == '0' && seats.charAt(j) == '0') {
                    StringBuilder modifiedSeats = new StringBuilder(seats);
                    modifiedSeats.setCharAt(i, '1');
                    modifiedSeats.setCharAt(j, '1');
                    int currentDistance = Integer.MAX_VALUE;

                    int lastOccupied = -1;
                    for (int k = 0; k < n; k++) {
                        if (modifiedSeats.charAt(k) == '1') {
                            if (lastOccupied != -1) {
                                currentDistance = Math.min(currentDistance, k - lastOccupied);
                            }
                            lastOccupied = k;
                        }
                    }

                    maxDistance = Math.max(maxDistance, currentDistance);
                }
            }
        }
        System.out.println(maxDistance);
    }
}