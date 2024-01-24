import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Student[] students = new Student[n];
        for(int i = 0; i < n; i++){
            String name = sc.next();
            int kor = sc.nextInt();
            int eng = sc.nextInt();
            int math = sc.nextInt();

            students[i] = new Student(name, kor, eng, math);
        }
        Arrays.sort(students);

        for(int i = 0; i < n; i++){
            System.out.println(students[i].name + " " + students[i].kor + " " + students[i].eng + " " + students[i].math);
        }


    }
}

class Student implements Comparable<Student>{
    String name;
    int kor;
    int eng;
    int math;
    public Student(String name, int kor, int eng, int math){
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math =  math;
    }

    @Override
    public int compareTo(Student o){
        if(this.kor == o.kor){
            if(this.eng == o.eng){
                return o.math - this.math;
            }
            return o.eng - this.eng;
        }
        return o.kor - this.kor;
    }
}