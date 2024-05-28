import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> set;

        int n = sc.nextInt();

        for(int i = 0; i < n; i++){ 
            int k = sc.nextInt();
            set = new TreeSet<>();
            for(int j = 0;  j < k; j++){
                String str = sc.next();
                int num = sc.nextInt();
                if(str.equals("I")){
                    set.add(num);
                }else{
                    if(!set.isEmpty()){                        
                        if(num == 1){
                            set.remove(set.last());
                        }else{
                            set.remove(set.first());
                        }
                    }
                }
            }
            if(set.isEmpty()){
                System.out.println("EMPTY");
            }else{
                System.out.println(set.last() + " " + set.first());
            }
        }
    }
}