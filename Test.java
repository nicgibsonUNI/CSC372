public class Test {
    public static void main(String[] args) {
        Employee employee = new Employee("Al", "Pacino", 1111);
        employee.setSalary(90000);
        employee.employeeSummary();

        System.out.println();

        Manager manager = new Manager("Robert", "DeNiro", 2222, "Movies");
        manager.setSalary(150000);
        manager.employeeSummary();
    }
}
