public final class Show {

    /**
     * field to store the name of the movie.
     */
    private String name;

    /**
     * field to store the date and time of show.
     */
    private String dateTime;

    /**
     * field to store the information regarding seats.
     */
    private String[] seats;

    /**
     * field to store the names of patrons who booked tickets.
     */
    private String[] bookingName;

    /**
     * field to store the seats booked by respective person.
     */
    private String[][] bookedSeats;

    /**
     * field to know the size of the above fields.
     */
    private int bsSize;

    Show(final String name, final String dateTime, final String[] seats) {
        this.name = name;
        this.dateTime = dateTime;
        this.seats = seats;

        final int limit = 10;
        bookingName = new String[limit];
        bookedSeats = new String[limit][]
        bsSize = 0;
    }

    /**
     * function to get the name of the show.
     *
     * @return the name of the show.
     */
    public String getName() {
        return name;
    }

    /**
     * function to get the date and time of the show.
     *
     * @return the date and time of show.
     */
    public String getDateTime() {
        return dateTime;
    }

    /**
     * function to get the seats available for the show.
     *
     * @return the seats availble.
     */
    public String[] getSeats() {
        return seats;
    }

    // public void toString() {
    //     String seatsString = "[";
    //     for (int i = 0; i < seats.length; i++) {
    //         seatsString += seats[i] + ",";
    //     }
    //     seatsString += "]";
    //     System.out.println("Name: " + name + "\nDate and Time: " + dateTime
    //                     + "Seats: " + seatsString);
    // }


    /**
     * Helper function for removing the booked seats from the list.
     *
     * @param s the list of seats available for booking.
     * @param seats the seat that is being booked.
     * @return the new list of seats that are available now.
     */
    public String[] remove(final String s, final String[] seats) {
        int pos = seats.length;
        int len = seats.length - 1;
        String[] ret = seats;
        for (int i = 0; i < ret.length; i++) {
            if (ret[i].equals(s)) {
                pos = i;
                break;
            }
        }
        for (int i = pos; i < ret.length - 1; i++) {
            ret[i] = ret[i + 1];
        }
        ret[len] = null;
        return ret;
    }

    /**
     * function to book seats for the show.
     *
     * @param pat the details of the person booking the seats.
     * @param s the seats that he/she chooses to book.
     * @return true if seats available or false otherwise.
     */
    public boolean bookAShow(final Patron pat, final String[] s) {
        for (int i = 0; i < s.length; i++) {
            boolean flag = true;
            for (int j = 0; j < seats.length; j++) {
                if (seats[j] == null) {
                    return false;
                }
                if (seats[j].equals(s[i])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return false;
            } else {
                seats = remove(s[i], seats);
            }
        }

        bookedSeats[bsSize] = s;
        bookingName[bsSize++] = pat.getName();
        return true;
    }

    /**
     * function to print the tickets based on the information
     * of the person provided.
     *
     * @param pat the details of the person booking the seats.
     */
    public void printTickets(final Patron pat) {
        String seatsBooked = "";
        boolean flag = true;
        for (int i = 0; i < bsSize; i++) {
            if (pat.getName().equals(bookingName[i])) {
                flag = false;
                for (int j = 0; j < bookedSeats[i].length; j++) {
                    seatsBooked += bookedSeats[i][j] + ",";
                }
            }
        }
        if (flag) {
            System.out.println("Sorry, no seats booked.\n");
        } else {
            System.out.println("Name: " + pat.getName());
            System.out.println("Mobile Number: " + pat.getMobileNumber());
            System.out.println("Movie Name: " + name);
            System.out.println("Time: " + dateTime);
            System.out.println("Seats: " + seatsBooked + "\n");
        }
    }
}
