/**
 * Clock data type. Write a data type Clock.java that
 * represents time on a 24-hour clock, such as 00:00, 13:30, or
 * 23:59. Time is measured in hours (00–23) and minutes (00–59).
 * To do so, implement the following public API:
 *
 * @author Siva Sankar
 * @author Bharat Ram Koppu
 */

public class Clock {
    /**
     * attribute for hours.
     */
    private int h;

    /**
     * attribute for minutes.
     */
    private int m;

    // Creates a clock whose initial time is h hrs and m min.
    /**
     * The parameterised constructor will instatiates the object with the
     * values of the parameters h and m to the respective hrs nad min.
     * @param h the parameter for the measure of hours.
     * @param m the parameter for the measure of minutes.
     */
    public Clock(final int h, final int m) {
        this.h = h;
        this.m = m;
    }

    /**
     * Creates a clock whose initial time is specified as a string,
     * using the format HH:MM.
     * @param s the string containing the time details.
     */

    public Clock(final String s) {
        String[] str = s.split(":");
        h = Integer.parseInt(str[0]);
        // h = (int) str[0];
        m = Integer.parseInt(str[1]);
        // m = (int) str[1];
    }

    /**
     * Returns a string representation of this clock, using the format HH:MM.
     * @return time in string format.
     */

    public String toString() {
        return String.format("%02d:%02d", h, m);
    }

    /**
     * Is the time on this clock earlier than the time on that one?
     * @param that the Clock object which has to be compared to.
     * @return true if clock is earlier else false.
     */

    public boolean isEarlierThan(final Clock that) {
        // System.out.println(this.toString());
        // System.out.println(that);
        if (this.h < that.h) {
            return true;
        } else if (this.h > that.h) {
            return false;
        } else if (this.m < that.m) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds 1 minute to the time on this clock.
     */

    public void tic() {
        m += 1;
        int maxmin = 60;
        int maxhour = 24;
        if (m >= maxmin) {
            m -= maxmin;
            h += 1;
            if (h >= maxhour) {
                h -= maxhour;
            }
        }
    }

    /**
     * Adds Δ min to the time on this clock.
     * @param delta the number of minutes to be added to the clock.
     */

    public void toc(final int delta) {
        int maxmin = 60;
        int maxhour = 24;
        if (delta >= 0) {
            m += delta;
            while (m >= maxmin) {
                m -= maxmin;
                h += 1;
                if (h >= maxhour) {
                    h -= maxhour;
                }
            }
        }
    }

    // Test client (see below).
    public static void main(final String[] args) {
        Clock clock = new Clock("13:01");
        clock.toc(660);
        System.out.println(clock);
    }
}
