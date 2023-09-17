public class ShapeArray {
    public static void main(String[] args) {    // Entry to program
        Shape[] shapeArray = new Shape[3];  // Creating array

        shapeArray[0] = new Sphere(6);  // Instantiate a sphere
        shapeArray[1] = new Cylinder(6, 12); // Instantiate a cylinder
        shapeArray[2] = new Cone(6, 12); // Instantiate a cone

        // Looping through array of each object
        for (Shape shape : shapeArray) {
            System.out.println(shape.toString()); // Printing each object
        }
    }  
}
