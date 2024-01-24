import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = 5;
        Student[] students = new Student[n];
        for(int i = 0; i < n; i++){
            String name = sc.next();
            int height = sc.nextInt();
            float weight = sc.nextFloat();
            
            students[i] = new Student(name, height, weight); 
        }

        Arrays.sort(students);

        System.out.println("name");
        for(int i = 0; i < n; i++){
            System.out.println(students[i].name + " " +students[i].height + " " + students[i].weight);
        }

        Arrays.sort(students, new Comparator<Student>(){
            @Override
            public int compare(Student o1, Student o2){
                return o2.height - o1.height;
                
            }
        });
        System.out.println(" ");
        System.out.println("height");
        for(int i = 0; i < n; i++){
            System.out.println(students[i].name + " " + students[i].height + " " + students[i].weight);
        }
    }
}

class Student implements Comparable<Student>{
    String name;
    int height;
    float weight;
    public Student(String name, int height, float weight){
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public int compareTo(Student o){
        int result =  this.name.compareTo(o.name);
        if(result < 0){
            return -1;
        }else if(result > 0){
            return 1;
        }
        return 0;
        
    }
}