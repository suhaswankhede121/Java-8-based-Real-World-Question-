/*
 * create the class Course with the below Attributes.

courseId- int
courseName- String
courseAdmin- String
quiz- int
handson -int

The above methods should be private ,write getter and
setter and parametrized constructor as required.

create class courseProgram with main method.

implement two static methods-
   findAvgOfQuizByAdmin method:this method will take array
of Course objects and a String  value as input parameters.
This method will find out Average (as int) of Quiz questions
for given Course Admin (String parametre passed)
This method will return Average if found.if there is no course
that matches then the method should return 0.

sortCourseByHandsOn method:
This method will take an Array of Course Objects and int
value as input parameters.
This methods should return an Array of Course objects in an
ascending order of their  handson which are less than the
given handson(int parameter passed) value. if there is no
such course then the method should return null.

The above mentioned static methods should be called from
main methods.

for findAvgOfQuizByAdmin method: The main method
should print the average if the returned value is not 0.
if the returned value is 0 then it should print "No Course
found."


for sortCourseByHandsOn method:
                        the  main method should print the name
of the Course from the returned Course object Array if the
returned value is not null.if the returned value is null then
it should print "No Course found with mentioned attribute."

input1:
111
kubernetes
Nisha
40
10
321
cassandra
Roshini
30
15
457
Apache Spark
Nisha
30
12
987
site core
Tirth
50
20
Nisha
17

output1:
35
kubernetes
Apache Spark
cassandra

input2:
111
kubernetes
Nisha
40
10
321
cassandra
Roshini
30
15
457
Apache Spark
Nisha
30
12
987
site core
Tirth
50
20
Shubhamk
5

output 2:
No Course found
No Course found with mentioned attributes.
 */



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course{
    private int cId;
    private String cName;
    private String cAdmin;
    private int quiz;
    private int hands;

    public Course(int cId,String cName,String cAdmin,int quiz,int hands){
        this.cId=cId;
        this.cName=cName;
        this.cAdmin=cAdmin;
        this.quiz=quiz;
        this.hands=hands;
    }

    public int getCourseId(){
        return cId;
    }
    public void setCourseId(int cId){
        this.cId=cId;
    }

    public String getCourseName(){
        return cName;
    }
    public void setCourseName(String cName){
        this.cName=cName;
    }

    public String getCourseAdmin(){
        return cAdmin;
    }
    public void setCourseAdmin(String cAmin){
        this.cAdmin=cAmin;
    }

    public int getCourseQuiz(){
        return quiz;
    }
    public void setCourseQuiz(int quiz){
        this.quiz=quiz;
    }

    public int getCourseHandson(){
        return hands;
    }
    public void setCourseHandson(int hands){
        this.hands=hands;
    }

}


public class CourseProblem {
        public static int findAvgOfQuizByAdmin(Course[] courses,String cAdmin){
            double avg=0;
            int sum=0;
            int count=0;
            for(Course c:courses){
                if(c.getCourseAdmin().equalsIgnoreCase(cAdmin)){
                    sum+=c.getCourseQuiz();
                    count++;
                }
            }
            if(count>0) avg=sum/count;
            if(avg>0){
                return (int) avg;
            }
            return 0;
        }

        public static Course[] sortCourseByHandsOn(Course[] courses,int hands){
            List<Course> list=new ArrayList<>();
            for(Course course:courses){
                if(hands>course.getCourseHandson()){
                    list.add(course);
                }
            }
            if(list.isEmpty()){
                return null;
            }

            list.sort((h1,h2)->Integer.compare(h1.getCourseHandson(), h2.getCourseHandson()));
            return list.toArray(new Course[0]);
        }

        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            Course[] course=new Course[4];
            for(int i=0;i<4;i++){
                int id=sc.nextInt();
                sc.nextLine();
                String name=sc.nextLine();
                String admin=sc.nextLine();
                int q=sc.nextInt();
                sc.nextLine();
                int h=sc.nextInt();
                sc.nextLine();
                course[i]=new Course(id, name, admin, q, h);
            }
            String cAdmin=sc.nextLine();
            int r1=findAvgOfQuizByAdmin(course, cAdmin);
            if(r1>0){
                System.out.println(r1);
            }else{
                System.out.println("No Course found.");
            }

            int hands=sc.nextInt();
            Course[] r2=sortCourseByHandsOn(course, hands);
            if(r2!=null){
                for(Course c:r2){
                    System.out.println(c.getCourseName());
                }
            }else{
                System.out.println("No Course found with mentioned attribute.");
            }
        }
}
