import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.next();
        char [] c = A.toCharArray();
        int count = 0;
        for(int i = 0; i < c.length; i++){
            for(int j = i + 1; j < c.length; j++){
                if(c[i] == '(' && c[j]== ')'){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}