/**
 * We'll say that a number is "teen" if it is in the range 13..19 inclusive. 
 * Given 3 int values, return true if 1 or more of them are teen.
 * 
 * Input : hasTeen(13, 20, 10)
 * Output : true
 * 
 * Input : hasTeen(20, 19, 10)
 * Output : true
 * 
 * Input : hasTeen(20, 10, 13)
 * Output : true
 * 
 * @author Siva Sankar
 */

 public class HasTeen {

    /**
     * 
     * We'll say that a number is "teen" if it is in the range 13..19 inclusive. 
     * 
     * @param a the first numebr as parameter to the method
     * @param b the second numebr as parameter to the method
     * @param c the third numebr as parameter to the method
     * 
     * @return return true if 1 or more of them are teen, otherwise false
     * 
     */
    public static boolean hasTeen(int a, int b, int c) {
        // Your code goes here....
        if (a>12 && a<20)
        {
            return true;
        }
        else if(b>12 && b<20)
        {
            return true;
        }
        else if(c>12 && c<20)
        {
            return true;
        }
        return false;
    }
}