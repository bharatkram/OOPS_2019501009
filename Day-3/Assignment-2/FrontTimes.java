/**
 * Given a string and a non-negative int n, we'll say that the front
 * of the string is the first 3 chars, or whatever is there if the
 * string is less than length 3. Return n copies of the front;
 *
 * Input : frontTimes("Chocolate", 2)
 * Output : ChoCho
 *
 * Input : frontTimes("Chocolate", 3)
 * Output : ChoChoCho
 *
 * Input : frontTimes("Abc", 3)
 * Output : AbcAbcAbc
 *
 * @author: Siva Sankar
 * @author: Bharat Ram Koppu
 */

public final class FrontTimes {
    /**
    * Empty Constructor.
    */
    private FrontTimes() {
        //Empty Constructor.
    }

    /**
     * This method returns n copies of the front.
     * @param str, the string to be considered.
     * @param n, the non-negative integer value.
     * @return the n copies of the front string.
     */
    public static String frontTimes(final String str, final int n) {
        //  Your code goes here....
        if (str.length() >= 3) {
            String subStr = str.substring(0, 3);
            String retStr = "";
            for (int i = 0; i < n; i++) {
                retStr = retStr + subStr;
            }
        return retStr;
        }else {
            String retStr = "";
            for (int i = 0; i < n; i++) {
                retStr = retStr + str;
            }
            return retStr;
        }
    }
}
