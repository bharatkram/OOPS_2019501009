/**
 * This class is to find the area and perimeter of a cirlce.
 * 
 * @author Siva Sankar
 */
public class AreaOfCircle {
    
    private static final double PI = 3.14159;

    /**
     * This method calculates the area of the circle.
     * Use the PI variable defined in the line number 8.
     * 
     * @param radius, the radius of the circle
     * @return the area of the circle
     */
    public static double areaOfCircle(double r) {
        return PI * r * r;
        //  Your code goes here....
    }

    /**
     * This method returns the perimiter of the circle.
     * Use the PI variable defined in the line number 8.
     * 
     * @param radius, the radius of the circle.
     * @return the perimeter of the circle.
     */
    public static double perimeterOfCircle(double r) {
        return 2 * PI * r;
        //  Your code goes here....
    }
}