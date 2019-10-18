import java.util.Objects;
import java.util.Scanner;

public final class CardCatalog {

    Card[] orderByTitle;
    Card[] orderByAuthor;
    Card[] orderBySubject;

    int obtSize;
    int obaSize;
    int obsSize;

    CardCatalog() {
        orderByTitle = new Card[10];
        orderByAuthor = new Card[10];
        orderBySubject = new Card[10];

        obtSize = 0;
        obaSize = 0;
        obsSize = 0;
    }

    public void addACard(Card card) {
        if (obtSize == 0) {
            orderByTitle[obtSize++] = card;
        } else {
            int pos = obtSize;
            for (int i = 0; i < obtSize; i++) {
                System.out.println(obtSize);
                if (orderByTitle[i].getTitle().compareTo(card.getTitle())
                                                                        > 0) {
                    pos = i;
                    break;
                }
            }
            for (int i = obtSize; i > pos + 1; i--) {
                orderByTitle[i] = orderByTitle[i-1];
            }
            obtSize++;
            orderByTitle[pos] = card;
        }

        if (obaSize == 0) {
            orderByAuthor[obaSize++] = card;
        } else {
            int pos = obaSize;
            for (int i = 0; i < obaSize; i++) {
                if (orderByAuthor[i].getAuthor().compareTo(card.getAuthor())
                                                                        > 0) {
                    pos = i;
                    break;
                }
            }
            for (int i = obaSize; i > pos + 1; i--) {
                orderByAuthor[i] = orderByAuthor[i-1];
            }
            orderByAuthor[pos] = card;
            obaSize++;
        }

        if (obsSize == 0) {
            orderBySubject[obsSize++] = card;
        } else {
            int pos = obsSize;
            for (int i = 0; i < obsSize; i++) {
                if (orderBySubject[i].getSubject().compareTo(card.getSubject())
                                                                        > 0) {
                    pos = i;
                    break;
                }
            }
            for (int i = obsSize; i > pos + 1; i++) {
                orderBySubject[i] = orderBySubject[i-1];
            }
            orderBySubject[pos] = card;
            obsSize++;
        }
    }

    public String getATitle(String title) {
        int min = 0;
        int max = obtSize-1;
        int mid;
        while (min < max) {
            mid = (min + max) / 2;
            if (orderByTitle[mid].getTitle().compareTo(title) > 0) {
                min = mid;
            } else if (orderByTitle[mid].getTitle().compareTo(title) < 0) {
                max = mid;
            } else {
                return "Title: " + orderByTitle[mid].getTitle() + "\nAuthor: "
                       + orderByTitle[mid].getAuthor() + "\nSubject: "
                       + orderByTitle[mid].getSubject() + "\n";
            }
        }
        return null;
    }

    public String[] getAnAuthor(String author) {
        String[] books = new String[obaSize];
        int len = 0;
        for (int i = 0; i < obaSize; i++) {
            if (orderByAuthor[i].getAuthor().equals(author)) {
                books[len++] = orderByAuthor[i].getTitle();
            }
        }
        return books;
    }

    // public String getSubject(String subject)

    public void removeATitle(String title) {
        int pos = -1;
        for (int i = 0; i < obtSize; i ++) {
            if (title.equals(orderByTitle[i].getTitle())) {
                pos = i;
                break;
            }
        }
        if (pos == -1) {
            System.out.println("Book not found.");
            return;
        } else {
            for (int i = pos; i < obtSize; i++) {
                orderByTitle[i] = orderByTitle[i + 1];
            }
            orderByTitle[obtSize--] = null;
        }

        for (int i = 0; i < obaSize; i++) {
            if (title.equals(orderByAuthor[i].getTitle())) {
                pos = i;
                break;
            }
        }
        for (int i = pos; i < obaSize; i++) {
            orderByAuthor[i] = orderByAuthor[i + 1];
        }
        orderByAuthor[obaSize--] = null;

        for (int i = 0; i< obsSize; i++) {
            if (title.equals(orderBySubject[i].getTitle())) {
                pos = i;
                break;
            }
        }
        for (int i = pos; i < obsSize; i++) {
            orderBySubject[i] = orderBySubject[i + 1];
        }
        orderBySubject[obsSize--] = null;
    }

    public String toString(Card[] cards) {
        String out = "";
        for (int i = 0; i < cards.length; i++) {
            out += cards[i].getTitle() + "\n";
        }
        return out;
    }

    public void printTheCatalog() {
        int choice;
        System.out.println("Enter choice:");
        System.out.println("1.orderByTitle\n2.orderByAuthor\n3.orderBySubject");
        Scanner input = new Scanner(System.in);
        choice = input.nextInt();
        switch(choice) {
            case 1 : System.out.println(toString(orderByTitle));
                     break;
            case 2 : System.out.println(toString(orderByAuthor));
                     break;
            case 3 : System.out.println(toString(orderBySubject));
                     break;
            default: System.out.println("Wrong choice.");
        }
    }

    public static void main(String[] args) {
        CardCatalog cc = new CardCatalog();

        cc.addACard(new Card("ShakeSpeare", "Hamlet", "Drama"));
        cc.addACard(new Card("Enid Bliton", "Famous 5: The Island", "Fiction"));
        cc.addACard(new Card("Enid Bliton", "Famous 5: The castle", "Fiction"));
        cc.addACard(new Card("APJ Abdul Kalam", "Wings of Fire", "Autobiography"));

        cc.printTheCatalog();
    }
}
