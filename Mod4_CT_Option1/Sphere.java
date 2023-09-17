public class Sphere extends Shape {
    private double radius;  // Declare attribute

    // Parameterized constructor
    public Sphere(double radius) {
        this.radius = radius;
}

@Override   // Overrides abstract method to implement one from this concrete class
public double surfaceArea() {
    return 4 * Math.PI * Math.pow(radius, 2);   // Calcs and returns surface area
}

@Override   // Overrides abstract method to implement one from this concrete class
public double volume() {
    return (4.0/3) * Math.PI * Math.pow(radius, 3); // Calcs and returns volume
}

@Override   // Overrides toString method from Object class
public String toString() {
    return "Sphere Measurements: " + // Returns what will be printed for...
            "Surface Area = " + surfaceArea() + // ...surface area and volume
            ",  Volume = " + volume();
    }
}
