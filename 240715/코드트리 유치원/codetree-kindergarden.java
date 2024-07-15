import java.util.Scanner;

public class Main {
    public static final int MAXN = 200000;
    public static Node[] nodes = new Node[MAXN + 2];
    public static int nodeCnt;

    static class Node {
        int id;
        Node prev, next;

        public Node(int id) {
            this.id = id;
            this.prev = null;
            this.next = null;
        }
    }

    public static void connect(Node s, Node e) {
        if (s != null) s.next = e;
        if (e != null) e.prev = s;
    }

    public static void insertNextRange(Node s, Node e, Node v) {
        Node nextV = v.next;
        connect(v, s);
        connect(e, nextV);
    }

    public static void insertPrevRange(Node s, Node e, Node v) {
        connect(v.prev, s);
        connect(e, v);
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        nodeCnt = 1;
        nodes[1] = new Node(1);

        while (q-- > 0) {
            int option = sc.nextInt();

            if (option == 1) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int init = nodeCnt + 1;
                nodeCnt += b;

                for (int i = 0; i < b; i++) {
                    nodes[init + i] = new Node(init + i);
                    if (i != 0){ 
                        connect(nodes[init + i - 1], nodes[init + i]);
                    }
                }

                insertNextRange(nodes[init], nodes[init + b - 1], nodes[a]);
            }

            if (option == 2) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int init = nodeCnt + 1;
                nodeCnt += b;

                for (int i = 0; i < b; i++) {
                    nodes[init + i] = new Node(init + i);
                    if (i != 0) {
                        connect(nodes[init + i - 1], nodes[init + i]);
                    }
                }

                insertPrevRange(nodes[init], nodes[init + b - 1], nodes[a]);
            }

            if (option == 3) {
                int a = sc.nextInt();
                if (nodes[a].prev == null || nodes[a].next == null) {
                    System.out.println(-1);
                } else {
                    System.out.println(nodes[a].prev.id + " " + nodes[a].next.id);
                }
            }
        }
    }
}