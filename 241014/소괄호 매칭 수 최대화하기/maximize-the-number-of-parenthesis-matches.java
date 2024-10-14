import java.util.Scanner;
import java.util.Arrays;

class Element implements Comparable<Element> {
    int open, closed;

    public Element(int open, int closed) {
        this.open = open;
        this.closed = closed;
    }

    @Override
    public int compareTo(Element e) {
        return e.open * this.closed - this.open * e.closed; 
    }
}

public class Main {
    public static final int MAX_N = 100000;
    public static int n;
    public static Element[] brackets = new Element[MAX_N];
    public static long ans;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            int open = 0, closed = 0; 
            for(int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == '(') {
                    open++;
                } else {
                    closed++;
                    ans += open;
                }
            }
            brackets[i] = new Element(open, closed);
        }

        Arrays.sort(brackets, 0, n);

        int openSum = 0;
        for(int i = 0; i < n; i++) {
            int open = brackets[i].open;
            int closed = brackets[i].closed;
            ans += (long) openSum * closed;
            openSum += open;
        }

        System.out.print(ans);
    }
}