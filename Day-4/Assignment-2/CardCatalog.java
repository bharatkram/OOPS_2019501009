import java.util.Objects;

public final class CardCatalog {
    
    int number;

    Card[] cards = new Card[10];
    int cardCount = 0;

    public void addACard(Card card) {
        cards[cardCount++] = card;
    }

    public String getATitle(String title) {
        for (int i = 0; i < cardCount; i++) {
            if (Objects.equals(cards[i].getTitle, title)) {
                return cards[i];
            }
        }
        return "No books found.";
    }

    public void getAnAuthor(String author) {
        int count = 0;
        for (int i = 0; i < cardCount; i++) {
            if (Objects.equals(cards[i].getAuthor, author)) {
                System.out.println(cards[i].getTitle);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No books found");
        }
    }

    public void getSubject(String subject) {
        int count = 0;
        for (int i = 0; i < cardCount; i++) {
            if (Objects.equals(cards[i].getSubject, subject)) {
                System.out.println(cards[i].getSubject);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No books found.")
        }
    }

    public void removeATitle(String author) {
        for (int i = 0; i < cardCount; i++) {
            if (Objects.equals(cards[i].getAuthor, author)) {
                count += 1;
                for (int j = i; j < cardCount; i++) {
                    cards[j] = cards[j+1];
                }
                cards[cardCount--] = null;
            }
        }
        if (count != 0)
            return true;
        return false;
    }

    public void printTheCatalog() {
        for (int i = 0; i < cardCount; i++) {
            System.out.println(cards[i]);
        }
    }

    public static void main(String[] args) {
        boolean continue = true;
        do {
            
        }
    }
}
