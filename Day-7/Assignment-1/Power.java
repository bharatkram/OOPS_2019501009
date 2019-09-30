/**
 * Given "a" an integer or float value, and b as an integer value,
 * Find a power b.
 *
 * @author Siva Sankar
 */

 public class Power {
   /**
    * This method finds a^b where both a and b are integers.
    * @param  a the base
    * @param  b the exponential
    * @return a^b which is a long value.
    */
   public static long pow(final int a, final int b) {
      long answer = 1;
      for (int i = 0; i < b; i++) {
         answer *= a;
      }
      return answer;
   }

   /**
    * This method finds a^b where both variable a is a double
    * and b is an integer.
    * @param  a the base
    * @param  b the exponential
    * @return a^b which is a long value.
    */
   public static double pow(final float a, final int b) {
      double answer = 1;
      for (int i = 0; i < b; i++) {
         answer *= a;
      }
      return answer;
   }
}
