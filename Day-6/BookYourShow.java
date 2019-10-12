public class BookYourShow {

    Show[] shows;
    Patron[] patrons;
    int showSize;
    int patronSize;

    BookYourShow() {
        shows = new Show[10];
        patrons = new Patron[10];
        showSize = 0;
        patronSize = 0;
    }

    public void addAShow(Show show) {
        shows[showSize++] = show;
    }

    public Show[] getAShow(String name) {
        Show[] wanted = new Show[10];
        int wantedSize = 0;
        for (int i = 0; i < showSize; i++) {
            if (shows[i].getName().equals(name)) {
                wanted[wantedSize++] = shows[i];
            }
        }
        return wanted;
    }

    public Show getAShow(String name, String dateTime) {
        for (int i = 0; i < showSize; i++) {
            if (shows[i].getName().equals(name) &&
                    shows[i].getDateTime().equals(dateTime)) {
                return shows[i];
            }
        }
        return null;
    }

    public void removeAMovie(String name) {
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
            shows[showSize-i] = null;
        }
        showSize -= count;
    }
}
