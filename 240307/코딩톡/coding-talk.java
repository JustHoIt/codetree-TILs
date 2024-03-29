import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 인원 수
        int m = sc.nextInt(); // 메시지 수
        int p = sc.nextInt() - 1; // 메시지 번호
        boolean[] checks = new boolean[27]; //알파벳 A ~ Z 갯수
        Message[] messages = new Message[m];
        for (int i = 0; i < m; i++) {
            String sender = sc.next();
            int view = sc.nextInt();
            messages[i] = new Message(sender, view);
        }

        Arrays.fill(checks, false);

        // 메시지 보낸 이후 읽은 사람을 읽음 처리 하기
        for (int i = p; i < m; i++) {
            char c = messages[i].sender.charAt(0);
            checks[c - 'A'] = true;
        }

        //보내기 전 view 수가 같다면 읽음 처리 하기
        int previousView = messages[p].view;
        for (int i = p - 1; i >= 0; i--) {
            if (messages[i].view != previousView) {
                break;
            }
            char c = messages[i].sender.charAt(0);
            checks[c - 'A'] = true;
        }



        for (int i = 0; i < n; i++) {
            char c = (char) (i + 'A');
        }
        if (messages[p].view != 0) {
            for (int i = 0; i < n; i++) {
                if (!checks[i]) {
                    char c = (char) (i + 'A');
                    System.out.print(c + " ");
                }
            }
        } else {
            System.out.println();
        }
    }
}

class Message {
    String sender;
    int view;

    Message(String sender, int view) {
        this.sender = sender;
        this.view = view;
    }
}