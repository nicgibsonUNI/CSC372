public class Employee {
    // 4 private fields for the Employee class
    private String firstName;
    private String lastName;
    private int employeeID;
    private double salary;

    //Constructor method initializing fields
    public Employee(String firstName, String lastName, int employeeID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeID = employeeID;
        this.salary = 0.0;  // Salary initialized to zero
    }

    //Getter and setter methods for each field
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Method for printing all employee attributes
    public void employeeSummary() {
        System.out.println("Employee Summary: ");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Salary: " + salary);
    }
}