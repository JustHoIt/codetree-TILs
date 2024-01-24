import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Student[] students = new Student[n];
        for(int i = 0; i < n; i++){
            int num = i+1;
            int height = sc.nextInt();
            int weight = sc.nextInt();
            
            students[i] = new Student(num, height, weight); 
        }
        Arrays.sort(students);

        for(int i = 0; i < n; i++){
            System.out.println(students[i].height + " " + students[i].weight + " " + students[i].num);
        }
    }
}
class Student implements Comparable<Student>{
    int num;
    int height;
    int weight;
    public Student(int num, int height, int weight){
        this.num = num;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Student o){
        if(this.height == o.height){
            return o.weight - this.weight;
        }
        return o.height - this.height;
    }
}