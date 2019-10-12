public final class Show {

    String name;
    String dateTime;
    String[] seats;

    String[] bookingName = new String[10];
    String[][] bookedSeats = new String[10][];
    int bsSize = 0;

    Show(String name, String dateTime, String[] seats) {
        this.name = name;
        this.dateTime = dateTime;
        this.seats = seats;
    }

    public String getName() {
        return name;
    }

    public String getDateTime() {
        return dateTime;
    }

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
    public String[] remove(String s, String[] seats) {
        int pos = seats.length;
        int len = seats.length - 1;
        String[] ret = seats;
        for (int i = 0; i < ret.length; i++) {
            if (ret[i].equals(s)) {
                pos = i;
                break;
            }
        }
        for (int i = pos; i < ret.length-1; i++) {
            ret[i] = ret[i+1];
        }
        ret[len] = null;
        return ret;
    }

    public boolean bookAShow(Patron pat, String[] s) {
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
            }else {
                seats = remove(s[i],seats);
            }
        }

        bookedSeats[bsSize] = s;
        bookingName[bsSize++] = pat.getName();
        return true;
    }

    public void printTickets(Patron pat) {
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
