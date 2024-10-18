
/*

***********************************Imaginary Question********************************
 * Creating a Employess Class 
 * id,name,dept,age,salary
 * 
 * Methods:
 * 1. searchEmployeeById(Employees [],id)
 * 2. updateEmployee(Employee old,Employee new)
 * 3. allEmployeeInAcsedingOrderById
 * 
 * 
 * Note Id : Take id as a string i.e "101" and return into asceding oder by converting into integer
 * 
 * create getter setter parameterised Constructor with super()
 * 
 * 
 * 101
suhas
mca
23
52000.0
102
shiva
mca
25
51000.00
103
pratik
mca
24
25000.0
104
banty
BE
21
27000.00
101
mca

104
sneha
mca-ai
22
53000.00

 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employess{
    private String id;
    private String name;
    private String dept;
    private int age;
    private double salary;

    public Employess(String id,String name,String dept,int age,double salary){
        this.id=id;
        this.name=name;
        this.dept=dept;
        this.age=age;
        this.salary=salary;
    }

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getDept(){
        return dept;
    }
    public void setDept(String dept){
        this.dept=dept;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }

    public double getSalary(){
        return salary;
    }
    public void setSalary(double salary){
        this.salary=salary;
    }

}

public class EmployeeProblemWithoutJava8 {
    
    public static Employess searchEmployeeById(Employess[]employesses,String id){
        for(Employess e:employesses){
            if(e.getId().equalsIgnoreCase(id)){
                return e;
            }
        }
        return null;
    }

    public static Employess updateEmployee(Employess[] old,Employess update){
        for(Employess e:old){
            if(e.getId().equalsIgnoreCase(update.getId())){
                e.setName(update.getName());
                e.setDept(update.getDept());
                e.setAge(update.getAge());
                e.setSalary(update.getSalary());
                return e;
            }
        }
        return null;
    }

    public static Employess [] allEmployeeInAcsedingOrderById(Employess[]employesses,String dept){
        List<Employess> list=new ArrayList<>();
        int count=0;
        for(Employess e:employesses){
            if(e.getDept().equalsIgnoreCase(dept)){
                count++;
                list.add(e);
            }
        }

        //java 8 
        if(list.isEmpty()) return null;
        list.sort((i1,i2)->Integer.compare(Integer.parseInt(i1.getId()), Integer.parseInt(i2.getId())));
        return list.toArray(new Employess[0]);
        // Employess [] newArray=new Employess[count];

        // //traditional way
        // int i=0;
        // for(Employess e:employesses){
        //     if(e.getDept().equalsIgnoreCase(dept)){
        //         newArray[i++]=e;
        //     }
        // }
        // //logic to sort array in asending order
        // for(int j=0;j<newArray.length;j++){
        //     for(int k=j+1;k<newArray.length;k++){
        //         if(Integer.parseInt(newArray[j].getId())>Integer.parseInt(newArray[k].getId())){
        //             //swap 
        //             Employess temp=newArray[j];
        //             newArray[j]=newArray[k];
        //             newArray[k]=temp;
        //         }
        //     }
        // }


       // return newArray;
    }


    //now we can compare how java 8 concepts reduce code hahahhah.
    //also manages the complexity too from O(n2) to O(log n)

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Employess [] employesse=new Employess[4];
        for(int i=0;i<4;i++){
            String id=sc.nextLine();
            String name=sc.nextLine();
            String dept=sc.nextLine();
            int age=sc.nextInt();
            sc.nextLine();
            double salary=sc.nextDouble();
            sc.nextLine();
            employesse[i]=new Employess(id, name, dept, age, salary);
        }

        String id=sc.nextLine();
        String dept=sc.nextLine();
        Employess r1=searchEmployeeById(employesse, id);
        System.out.println(r1.getId()+" "+r1.getName()+" "+r1.getDept()+" "+r1.getAge()+" "+r1.getSalary());
        System.out.println("*************************************************");

        Employess[]r2=allEmployeeInAcsedingOrderById(employesse, dept);
        for(Employess e:r2){
            System.out.println(e.getId()+" "+e.getName());
        }
        System.out.println("*************************************************");

        System.out.println("Enter new data to update");
        String idd=sc.nextLine();
        String name=sc.nextLine();
        String deptt=sc.nextLine();
        int age=sc.nextInt();
        sc.nextLine();
        double salary=sc.nextDouble();
        sc.nextLine();

        Employess updateEmp=new Employess(idd, name, deptt, age, salary);
        updateEmployee(employesse, updateEmp);
        for(Employess e:employesse){
            System.out.println(e.getId()+" "+e.getName()+" "+e.getDept()+" "+e.getAge()+" "+e.getSalary());
        }
    }
}
