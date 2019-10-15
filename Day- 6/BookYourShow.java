public class BookYourShow {

    /**
     * field to store the shows list.
     */
    private Show[] shows;

    /**
     * field to store the patrons list.
     */
    private Patron[] patrons;

    /**
     * field to know the number of shows stored.
     */
    private int showSize;

    /**
     * field to know the number of patrons stored.
     */
    private int patronSize;

    /**
     * Unparameterized constructor that initializes the values of
     * the fields of the class.
     */
    BookYourShow() {
        final int limit = 10;
        shows = new Show[limit];
        patrons = new Patron[limit];
        showSize = 0;
        patronSize = 0;
    }

    /**
     * function to add a new show to the array.
     * @param show the show details that have to be added.
     */
    public void addAShow(final Show show) {
        shows[showSize++] = show;
    }

    /**
     * function to get the details of the show based on the given name.
     * @param name the name of the movie that has to be searched for.
     * @return the details of the show asked for.
     */
    public Show[] getAShow(final String name) {
        final int limit = 10;
        Show[] wanted = new Show[limit];
        int wantedSize = 0;
        for (int i = 0; i < showSize; i++) {
            if (shows[i].getName().equals(name)) {
                wanted[wantedSize++] = shows[i];
            }
        }
        return wanted;
    }

    /**
     * function to get the show details based on the name and time given.
     * @param name the name of the movie that has to be searched for.
     * @param dateTime the date and time at which the show has to be scheduled.
     * @return the show that matches the requirements.
     */
    public Show getAShow(final String name, final String dateTime) {
        for (int i = 0; i < showSize; i++) {
            if (shows[i].getName().equals(name)
                    && shows[i].getDateTime().equals(dateTime)) {
                return shows[i];
            }
        }
        return null;
    }

    /**
     * function to remove the show from the list based on the name given.
     * @param name the name of the movie.
     */
    public void removeAMovie(final String name) {
        for (int i = 0; i < showSize; i++) {
            if (shows[i].getName().equals(name)) {
                shows[i] = null;
            }
        }
        int count = 0;
        for (int i = 0; i < showSize; i++) {
            if (shows[i] == null) {
                count += 1;
            }
            shows[i] = shows[i + count];
        }
        for (int i = 0; i < count; i++) {
            shows[showSize - i] = null;
        }
        showSize -= count;
    }
}
