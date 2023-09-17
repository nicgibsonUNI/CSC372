public class Cylinder extends Shape {
    private double radius;  // Declare attributes
    private double height;

    // Parameterized constructor
    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override   // Overrides abstract method to implement one from this concrete class
    public double surfaceArea() {
        return 2 * Math.PI * radius * (radius + height); // Calcs and returns surface area
    }                                                    

    @Override   // Overrides abstract method to implement one from this concrete class
    public double volume() {
        return Math.PI * Math.pow(radius, 2) * height; // Clacs and returns volume
    }

    @Override   // Overrides toString method from Object class
    public String toString() {  // Implements a our toString method
        return "Cylinder measurements: " + 
                "Surface Area = " + surfaceArea() +
                ", Volume = " + volume();
    }
}
