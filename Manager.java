//Declare Manager class and inheriting of Employee class
public class Manager extends Employee {
    private String department;  // Declare additional field that's not in superclass

    // Initializes values for all fields
    public Manager(String firstName, String lastName, int employeeID, String department) {
        super(firstName, lastName, employeeID);
        this.department = department;
    }
    
    //Getter and Setter methods for department field
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Overrides superclass(Employee class) employeeSummary,
    // Prints all attributes from superclass and subclass
    @Override
    public void employeeSummary() {
        super.employeeSummary(); // Calls and prints common attributes from Employee class
        System.out.println("Department: " + department);
    }
}
