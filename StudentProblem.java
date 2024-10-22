
//hackthons problem 2
//Recent RPA Question 

//It was memory based question from recent PRA and I Just made my logic accordigly 
//helps to understand the pattern of pra exam

/*
 * 5
104
uma
223
102
classy
283
105
eva
295
101
jenny
241
100
jisha
372
101
jennis
245



 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Student{
    private int id;
    private String name;
    private int tm;
    private String date;
    boolean flag;

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

    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date=date;
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

    public static void updateDataById(Student[]students,Student newStudents){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Mail Id an Password to update date");
        String username=sc.nextLine();
        String password=sc.nextLine();
        if(isValidEmail(username)){
            if(isValidPassword(password)){
                for(Student s: students){
                    if(validateUserAccess(username, password)){
                        if(s.getId()==newStudents.getId()){
                            s.setId(newStudents.getId());
                            s.setName(newStudents.getName());
                            s.setTm(newStudents.getTm());
                            String date=new SimpleDateFormat().format(new Date());
                            s.setDate(date);
                            s.flag=true;
                        }
                    }else{
                        System.out.println("Email Id and Passoword not Matched try again later");
                        return;
                    }
                }   
            }else{
                System.out.println("Enter valid password pattern");
                return;
            }
        }else{
            System.out.println("Enter Valid Email Pattern");
            return;
        }
    }
    public static boolean idPasswordMatched(String username,String password){
        if(username.equals("suhaswankhede121@gmail.com") && password.equals("Wankhede@9999")){
            return true;
        }
        return false;
    }

    public static boolean validateUserAccess(String username,String password){
        return idPasswordMatched(username, password);
    }

    public static boolean isValidPassword(String password){
        String specialChars="!@#$%^&*()-+";
        boolean hasDigit=false;
        boolean hasUppercase=false;
        boolean hasLowercase=false;
        boolean hasLength=false;
        boolean hasspecialChars=false;
        if(password.length()<8){
            return false;
        }
        for(char ch:password.toCharArray()){
           if(Character.isDigit(ch)){
                hasDigit=true;
            }else if(Character.isLowerCase(ch)){
                hasLowercase=true;
            }else if(Character.isUpperCase(ch)){
                hasUppercase=true;
            }else if(specialChars.indexOf(ch)>=0){
                hasspecialChars=true;
            }
        }
        return hasDigit && hasLowercase && hasUppercase && hasspecialChars;
    }

    public static boolean isValidEmail(String emailId){
        String regexPattern="^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"; //means has char a-z||A-Z|| 0-9|| .-_
        Pattern pattern=Pattern.compile(regexPattern);
        Matcher matcher=pattern.matcher(emailId);
        return matcher.matches();
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

        int id=sc.nextInt();
        sc.nextLine();
        String name=sc.nextLine();
        int tmb=sc.nextInt();
        String ans=findStudentWithHigestTotal(student);
        List<Student> ans1=searchStudentByPercentage(student);
        System.out.println(ans);
        for(Student s:ans1){
            System.out.println(s.getId());
        }
        System.out.println("*****************************************");
        Student newStudent=new Student(id, name, tmb);
        updateDataById(student, newStudent);
        for(Student s:student){
            System.out.println("Student Id: "+s.getId()+", Student Name: "+s.getName());
            if(s.flag){
                System.out.println("Update Date: "+s.getDate());
            }
        }
    }
}
