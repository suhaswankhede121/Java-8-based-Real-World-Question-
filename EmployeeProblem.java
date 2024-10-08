/*
 * Create a class named "Employee" with the following attributes:

id (int)
name (String)
designation (String)
salary (double)

The above attributes should be private, and the class should have a parameterized constructor to initialize them.

Implement the following methods in the Employee class:

getSalary(): This method should return the salary of the employee.
getDesignation(): This method should return the designation of the employee.

Create a class named "Company" with the following attributes:

companyName (String)
employees (Employee array)
numEmployees (int)

The above attributes should be private, and the class should have a parameterized constructor to initialize them.

Implement the following methods in the Company class:

getAverageSalary(): This method should return the average salary of all the employees in the company.
getMaxSalary(): This method should return the highest salary of all the employees in the company.
getEmployeesByDesignation(String designation): This method should return an array of all employees with the given designation.

In the main method, use a Scanner object to read the values of the company name, number of employees, and the employee details 
(id, name, designation, and salary) in a loop. Once all employee details have been read, create a Company object and pass the 
appropriate parameters. Finally, call the three methods mentioned above and print the output.

Note:

All searches should be case-insensitive.
You may assume that the input is valid and in the correct format.

Sample input:
---------------------
Enter company name: ABC Company
Enter number of employees: 3
Enter employee details:
Employee 1:
Enter id: 101
Enter name: John Smith
Enter designation: Manager
Enter salary: 5000
Employee 2:
Enter id: 102
Enter name: Jane Doe
Enter designation: Engineer
Enter salary: 4000
Employee 3:
Enter id: 103
Enter name: Bob Johnson
Enter designation: Engineer
Enter salary: 4500

Sample Output:
--------------------
Average salary: 4500.0
Max salary: 5000.0
Employees with designation: Engineer
ID: 102, Name: Jane Doe, Designation: Engineer, Salary: 4000.0
ID: 103, Name: Bob Johnson, Designation: Engineer, Salary: 4500.0
 */



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee{
    private int id;
    private String name;
    private int age;
    private String gen;
    private double salary;

    public Employee(int id,String name,int age,String gen,double salary){
        this.id=id;
        this.name=name;
        this.age=age;
        this.gen=gen;
        this.salary=salary;
    }

    public int getEmployeeId(){
        return id;
    }
    public void setEmployeeId(int id){
        this.id=id;
    }

    public String getEmployeeName(){
        return name;
    }
    public void setEmployeeName(String name){
        this.name=name;
    }

    public int getEmployeeAge(){
        return age;
    }
    public void setEmployeeAge(int age){
        this.age=age;
    }

    public String getEmployeeGender(){
        return gen;
    }
    public void setEmployeeGender(String gen){
        this.gen=gen;
    }

    public double getEmployeeSalary(){
        return salary;
    }
    public void setEmployeeSalary(double salary){
        this.salary=salary;
    }
}


public class EmployeeProblem {
    public static Employee getEmployeeWithSecondLowestSalary(Employee []employees){
        List<Employee> list=new ArrayList<>();
        for(Employee e:employees){
            list.add(e);
        }
        if(list.size()<2) return null;

        list.sort((s1,s2)->Double.compare(s2.getEmployeeSalary(), s1.getEmployeeSalary()));
        return list.get(list.size()-2);
    }

    public static int countEmployeesBasedOnAge(Employee []employees,int age){
        int count=0;
        for(Employee e:employees){
            if(e.getEmployeeAge()==age){
                count++;
            }
        }
        if(count>0) return count;
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Employee []employee=new Employee[4];
        for(int i=0;i<4;i++){
            int id=sc.nextInt();
            sc.nextLine();
            String name=sc.nextLine();
            int age=sc.nextInt();
            sc.nextLine();
            String gen=sc.nextLine();
            double sal=sc.nextDouble();
            sc.nextLine();
            employee[i]=new Employee(id, name, age, gen,sal);
        }
        Employee r1=getEmployeeWithSecondLowestSalary(employee);
        int age=sc.nextInt();
        if(r1!=null){
            System.out.println(r1.getEmployeeId()+"#"+r1.getEmployeeName());
        }else{
            System.out.println("Null");
        }
        sc.nextLine();
        int r2=countEmployeesBasedOnAge(employee, age);
        if(r2>0){
            System.out.println(r2);
        }else{
            System.out.println( "No employee found for the given age");
        }
    }
}
