
//hackthons problem 2


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student{
    private int id;
    private String name;
    private int tm;

    Student(int id,String name,int tm){
        this.id=id;
        this.name=name;
        this.tm=tm;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public int getTm(){
        return tm;
    }
    public void setTm(int tm){
        this.tm=tm;
    }
}

public class StudentProblem {
    public static String findStudentWithHigestTotal(Student[]students){
        int max=Integer.MIN_VALUE;
        for(Student s:students){
            if(s.getTm()>max){
                max=s.getTm();
            }
        }
        String ans="";
        for(Student s:students){
            if(s.getTm()==max){
              ans=s.getName();
            }
        }
        return ans.toUpperCase();
    }

    public static List<Student> searchStudentByPercentage(Student[]students){
        List<Student> list=new ArrayList<>();
        for(Student s:students){
            double per=(s.getTm()/4);
            if(per>=70.0){
                list.add(s);
            }
        }
        if(list.isEmpty()) return null;
        list.sort((i1,i2)->Integer.compare(i1.getId(),i2.getId()));
        return list;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        Student [] student=new Student[n];
        for(int i=0;i<n;i++){
            int id=sc.nextInt();
            sc.nextLine();
            String name=sc.nextLine();
            int tm=sc.nextInt();
            sc.nextLine();
            student[i]=new Student(id, name, tm);
        }
        String ans=findStudentWithHigestTotal(student);
        List<Student> ans1=searchStudentByPercentage(student);
        System.out.println(ans);
        for(Student s:ans1){
            System.out.println(s.getId());
        }
    }
}
