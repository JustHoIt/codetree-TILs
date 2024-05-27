import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet<Integer> s = new TreeSet<>();
        for(int i = 0; i < n; i++){
            String str = sc.next();
            if(str.equals("add")){
                int num = sc.nextInt();
                s.add(num);
            }else if(str.equals("largest")){
                if(!s.isEmpty()){
                    System.out.println(s.last());
                }else{
                    System.out.println("None");
                }

            }else if(str.equals("smallest")){
                if(!s.isEmpty()){
                    System.out.println(s.first());
                }else{
                    System.out.println("None");
                }

            }else if(str.equals("find")){
                int num = sc.nextInt();
                System.out.println(s.contains(num));

            }else if(str.equals("lower_bound")){
                int num = sc.nextInt();
                if(s.ceiling(num) != null){
                    System.out.println(s.ceiling(num));
                }else{
                    System.out.println("None");
                }  

            }else if(str.equals("upper_bound")){
                int num = sc.nextInt();
                if(s.higher(num) != null){
                    System.out.println(s.higher(num));
                }else{
                    System.out.println("None");
                }

            }else{
                int num = sc.nextInt();
                s.remove(num);
            }

        }
    }
}