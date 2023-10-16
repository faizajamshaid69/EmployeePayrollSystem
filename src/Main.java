import java.util.ArrayList;

abstract class Employee{
    private String name;
    private int id;
    Employee(String name,int id){
        this.name=name;
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
  public abstract double calculateSalary();
    @Override
    public String toString(){
        return "Employee[name="+name+",id="+id+",salary="+calculateSalary()+"]";
    }
}
class FullTimeEmployee extends Employee{
    private double monthlySalary;
    FullTimeEmployee(String name,int id,double monthlySalary){
        super(name,id);
        this.monthlySalary=monthlySalary;
    }


    @Override
    public double calculateSalary() {
      return monthlySalary;
    }

}
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}
    class PayRollSystem{
        private ArrayList<Employee>  employeeArrayList;
     public   PayRollSystem(){
         employeeArrayList=new ArrayList<>();

        }
        public void addEmployee(Employee employee){
         employeeArrayList.add(employee);

        }
        public void removeEmployee(int id){
         Employee employeeToRemove=null;
            for (Employee employee:employeeArrayList) {
                if(employee.getId()==id){
                    employeeToRemove=employee;
                    break;
                }

                
            }
            if(employeeToRemove!=null){
                employeeArrayList.remove(employeeToRemove);
                System.out.println( employeeToRemove+" Employee removed successfully");
            }

        }
        public void displayEmployee(){
            for (Employee employee:employeeArrayList) {
                System.out.println(employee);

            }
        }


    }

public class Main {
    public static void main(String[] args) {
        PayRollSystem payRollSystem=new PayRollSystem();


        FullTimeEmployee fullTimeEmployee=new FullTimeEmployee("Ahsan",2,3800);
        PartTimeEmployee partTimeEmployee=new PartTimeEmployee("kashif Bhatti",1,4,800);
        payRollSystem.addEmployee(new FullTimeEmployee("Faiz Hameed",12,8000000));
        payRollSystem.addEmployee(new FullTimeEmployee("raza",13,700000));


        payRollSystem.addEmployee(fullTimeEmployee);
        payRollSystem.addEmployee(partTimeEmployee);
        payRollSystem.displayEmployee();
        payRollSystem.removeEmployee(1);
        System.out.println();
        payRollSystem.displayEmployee();

    }
}