import java.util.Scanner;

public class Main {

    static class Node {
        String data;
        Node prev, next;

        Node(String data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private static void connect(Node s, Node e) {
        if (s != null) s.next = e;
        if (e != null) e.prev = s;
    }

    private static void insertNext(Node target, Node s) {
        connect(s, target.next);
        connect(target, s);
    }

    private static void pop(Node u) {
        connect(u.prev, u.next);
        u.prev = u.next = null;
    }

    public static void main(String[] args) {
        //여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        Node pin = null, prev = null;

        for (int i = 1; i <= n; i++) {

            String x = sc.next();
            Node target = new Node(x);

            if (i == 1) {
                pin = target;
            } else {
                connect(prev, target);
            }

            if (i == n) {
                connect(target, pin);
            }

            prev = target;
        }

        while (q-- > 0) {
            int option = sc.nextInt();

            if (option == 1) {
                if (pin.next != null) {
                    pin = pin.next;
                }
            }

            if (option == 2) {
                if (pin.prev != null) {
                    pin = pin.prev;
                }
            }

            if (option == 3) {
                if (pin.next != pin){
                    pop(pin.next);
                }
            }

            if (option == 4) {
                String x = sc.next();
                insertNext(pin, new Node(x));
            }

            if (pin.next == pin.prev || pin.next == null || pin.prev == null) {
                System.out.println(-1);
            } else {
                System.out.println(pin.prev.data + " " + pin.next.data);
            }
        }
    }
}