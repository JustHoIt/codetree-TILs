import java.util.Scanner;

public class Main {
    static final int MAX_N = 100000;
    static final int MAX_M = 10;
    static class Node {
        int id;
        Node prev, next;

        Node(int id) {
            this.id = id;
            this.prev = null;
            this.next = null;
        }
    }

    static Node[] nodes = new Node[MAX_N + 1];
    static Node[] head = new Node[MAX_M + 1], tail = new Node[MAX_M + 1];
    static int[] lineNum = new int[MAX_N + 1];
    static void connect(Node s, Node e) {
        if (s != null) { 
            s.next = e;
        }
        if (e != null) {
            e.prev = s;
        }
    }
    
    static void pop(Node i) {
        int l = lineNum[i.id];
        if (l == 0) {
            return;
        }
        if (head[l] == i) {
            head[l] = head[l].next;
        }
        if (tail[l] == i) {
            tail[l] = tail[l].prev;
        }
        if (i.prev != null) {
            i.prev.next = i.next;
        }
        if (i.next != null) {
            i.next.prev = i.prev;
        }
        lineNum[i.id] = 0;
        i.next = i.prev = null;
    }
    static void insertFront(Node a, Node b) {
        int lineNumB = lineNum[b.id];
        if (head[lineNumB] == b) { 
            head[lineNumB] = a;
        }
        pop(a);
        connect(b.prev, a);
        connect(a, b);
        lineNum[a.id] = lineNumB;
    }
    static void popRangeAndInsertPrev(Node a, Node b, Node c) {
        int lineNumA = lineNum[a.id];
        int lineNumC = lineNum[c.id];
        if (head[lineNumA] == a) { 
            head[lineNumA] = b.next;
        }
        if (tail[lineNumA] == b) {
            tail[lineNumA] = a.prev;
        }
        connect(a.prev, b.next);
        if (head[lineNumC] == c) {
            connect(b, c);
            head[lineNumC] = a;
        } else {
            connect(c.prev, a);
            connect(b, c);
        }

        Node cur = a;
        while (cur != b.next) {
            lineNum[cur.id] = lineNumC;
            cur = cur.next;
        }
    }

    static void printLine(int l) {
        Node cur = head[l];

        if (cur == null) {
            System.out.println(-1);
            return;
        }

        while (cur != null) {
            System.out.print(cur.id + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        for (int i = 1; i <= m; i++) {
            int l = sc.nextInt();
            for (int j = 0; j < l; j++) {
                int t = sc.nextInt();
                lineNum[t] = i;
                nodes[t] = new Node(t);
                if (j == 0) {
                    head[i] = tail[i] = nodes[t];
                } else {
                    connect(tail[i], nodes[t]);
                    tail[i] = nodes[t];
                }
            }
        }

        while (q-- > 0) {
            int option = sc.nextInt();
            if (option == 1) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                insertFront(nodes[a], nodes[b]);
            } else if (option == 2) {
                int a = sc.nextInt();
                pop(nodes[a]);
            } else if (option == 3) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                popRangeAndInsertPrev(nodes[a], nodes[b], nodes[c]);
            }
        }

        for (int i = 1; i <= m; i++) {
            printLine(i);
        }
    }
}