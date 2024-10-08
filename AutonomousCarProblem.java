/*
 * Create a class AutonomousCar with the below attributes:

carld – int
brand – String 
noOfTestsConducted – int
noOfTestsPassed- int
environment – String

Write getters, setters for the above attributes . Create constructor which takes parameter in the above sequence 
except grade.

Create class Solution with main method. Implement two static methods – findTestPassedByEnv and updateCarGrade in 
Solution class.

findTestPassedByEnv method:

This method will take two input parameters -array of AutonomousCar objects and string parameter environment. The method 
will return the sum of the noOfTestsPassed attribute from autonomousCar objects for the environment passed as parameter. 
If no autonomousCar with the given environment is present in the array of AutonomousCar objects, then the method should 
return 0.

updateCarGrade method:

This method will take a String parameter brand, along with the array of AutonomousCar objects. The method will return 
the autonomousCar object, if the input String parameter matches with the brand attribute of the autonomousCar object. 
Before returning the object, the grade should be derived based on the rating calculation mentioned below. This grade 
value should be assigned to the object. If any of the above conditions are not met, then the method should return null. 
The grade attribute should be calculated as follows: rating .(noOfTestsPassed * 100)/noOfTestsConducted 
If the rating > = 80 then grade should be ‘A1’, otherwise the grade should be ‘B2’.

The above mentioned static methods should be called from the main method. For findTestPassedByEnv method – The main 
method should print the totalTestPassed as it is, if the returned value is greater than 0, or it should print “There 
are no tests passed in this particular environment”.

For updateCarGrade method – The main method should print the brand and grade of the returned autonomousCar object. 
The brand and grade should be concatinated with :: while printing. eg:- Tesla::A1, where Tesla is the brand and Al 
is the grade.

If the returned value is null then it should print “No Car is available with the specified brand”. Before calling these 
static methods in main, use Scanner object to read the values of four autonomousCar objects referring attributes in the 
above mentioned attribute sequence (except grade attribute). Next, read the value for environment and brand.

Input
----------------
100
Tesla
1000
500
Hills
200
Ford
2000
1500
Desert
300
Royce
3000
1700
Hills
400
Mercedez
1000
400
Desert
Desert
Mercedez

Output
-----------
1900
Mercedez::B2
 */





import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class AutonomousCar{
    private int id;
    private String brand;
    private int nooftestcon;
    private int nooftestpass;
    private String env;
    private String grade;

    AutonomousCar(int id,String brand,int nooftestcon,int nooftestpass,String env){
        this.id=id;
        this.brand=brand;
        this.nooftestcon=nooftestcon;
        this.nooftestpass=nooftestpass;
        this.env=env;
    }

    public int getCarId(){
        return id;
    }
    public void setCarId(int id){
        this.id=id;
    }

    public String getCarBrand(){
        return brand;
    }
    public void setCarBrand(String brand){
        this.brand=brand;
    }
    
    public int getCarCon(){
        return nooftestcon;
    }
    public void setCarCon(int nooftestcon){
        this.nooftestcon=nooftestcon;
    }

    public int getCarPass(){
        return nooftestpass;
    }
    public void setCarPass(int nooftestpass){
        this.nooftestpass=nooftestpass;
    }

    public String getCarEnv(){
        return env;
    }
    public void setCarEnv(String env){
        this.env=env;
    }

    public void setGrade(String grade){
        this.grade=grade;
    }
    public String getGrade(){
        return grade;
    }
}

class AutonomousCarProblem{
    public static int findTestPassedByEnv(AutonomousCar[]autonomousCars,String env){
        int sum=0;
        for(AutonomousCar c:autonomousCars){
            if(c.getCarEnv().equalsIgnoreCase(env)){
                sum+=c.getCarPass();
            }
        }
        if(sum>0) return sum;
        return 0;
    }

    public static AutonomousCar updateCarGrade(AutonomousCar[] autonomousCars,String brand){
        int rating=0;
        List<AutonomousCar> list=new ArrayList<>();
        for(AutonomousCar c:autonomousCars){
            if(c.getCarBrand().equalsIgnoreCase(brand)){
                rating=(c.getCarPass()*100)/c.getCarCon();
                list.add(c);
                if(rating>=80){

                    c.setGrade("A1");
                }else{
                    c.setGrade("B2");
                }
            }
        }
        if(!list.isEmpty()) return list.get(0);
        return null;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        AutonomousCar[] c=new AutonomousCar[4];
        for(int i=0;i<4;i++){
            int id=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            int con=sc.nextInt();
            sc.nextLine();
            int pass=sc.nextInt();
            sc.nextLine();
            String e=sc.nextLine();
            c[i]=new AutonomousCar(id, b, con, pass, e);
        }
        String env=sc.nextLine();
        String brand=sc.nextLine();
        int r1=findTestPassedByEnv(c, env);
        if(r1>0){
            System.out.println(r1);
        }else{
            System.out.println("There are no tests passed in this particular environment");
        }
        AutonomousCar r2=updateCarGrade(c, brand);
        if(r2!=null){
            System.out.println(r2.getCarBrand()+"::"+r2.getGrade());
        }else{
            System.out.println("No Car is available with the specified brand");
        }
    }
}