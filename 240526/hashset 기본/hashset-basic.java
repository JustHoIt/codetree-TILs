import java.util.HashSet;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> s = new HashSet<>();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            String str = sc.next();
            int num = sc.nextInt();
            if(str.equals("find")){
                System.out.println(s.contains(num));
            }else if(str.equals("add")){
                s.add(num);
            }else{
                s.remove(num);
            }
        }

    }
}