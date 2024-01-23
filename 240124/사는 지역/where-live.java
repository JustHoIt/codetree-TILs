import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        ArrayList<Information> list =new ArrayList<>();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            String name = sc.next();
            String phone = sc.next();
            String city = sc.next();
            Information info = new Information(name, phone, city);
            list.add(info);
        }
        Collections.sort(list);
        System.out.println("name " + list.get(n-1).name);
        System.out.println("addr " + list.get(n-1).phone);
        System.out.println("city " + list.get(n-1).city);
    }


}
class Information implements Comparable<Information>{
    String name;
    String phone;
    String city;
    public Information(String name, String phone, String city){
        this.name = name;
        this.phone = phone;
        this.city = city;

    }
    @Override
    public int compareTo(Information o) {
        int result = this.name.compareTo(o.name);
        if(result < 0){
            return -1;
        }else if(result > 0){
            return 1;
        }
        return 0;
    }
}