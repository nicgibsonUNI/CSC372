public class Cone extends Shape {
    private double radius;  // Declare attributes
    private double height;   

    // Parameterized constructor
    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override   // Overrides abstract method to implement one from this concrete class
    public double surfaceArea() {   // Next line use Pythagorean theorem to calc slant height
        double slantHeight = Math.sqrt(Math.pow(radius, 2) + Math.pow(height, 2));
        return Math.PI * radius * (radius + slantHeight); // Calcs return for surfaceArea
    }

    @Override   // Overrides abstract method to implement one from this concrete class
    public double volume() {
        return (Math.PI * Math.pow(radius, 2) * height) / 3; // Calcs return for volume
    }

    @Override   // Overrides toString method from Object class
    public String toString() {  // Implements our toString method
        return "Cone Measurements: " +  // Returns what will be printed for...
                "Surface Area = " + surfaceArea() + // ... surface area and volume
                ", Volume = " + volume();
    }
}

    