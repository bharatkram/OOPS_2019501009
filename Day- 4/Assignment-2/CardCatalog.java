
public class CardCatalog {
    Card[] catalog;
    Card[] sortedTitle;
    Card[] sortedAuthor;
    Card[] sortedSubject;

    public CardCatalog() {
        //instantiate 3 arrays to sort based on title,
        //author and subject respectively
        cardNum = 0;
        catalog = new Card[10];
        sortedTitle = new Card[10];
        sortedAuthor = new Card[10];
        sortedSubject = new Card[10];
    }
    //catalog array of Card objects
    // catalog = new Card[10];

    // card number- no of cards in the catalog
    int cardNum;
    
    //sort array method - by Title
    public Card[] sortByTitle(Card[] catalog) {
        for (int i = 0; i < cardNum; i++) {
            for (int j = 0; j < cardNum; j++) {
                int x = catalog[j].getTitle().compareTo(catalog[j+1].getTitle());
                if (x > 0) {
                    // swap temp and arr[i]
                    Card temp = catalog[j];
                    catalog[j] = catalog[j+1];
                    catalog[j+1] = temp;
                }
            }
        }
        return catalog;
    }
    //sort array method - by Author
    public Card[] sortByAuthor(Card[] catalog) {
        for (int i = 0; i < cardNum; i++) {
            for (int j = 0; j < cardNum; j++) {
                int x = catalog[j].getAuthor().compareTo(catalog[j+1].getAuthor());
                if (x > 0) {
                    // swap temp and arr[i]
                    Card temp = catalog[j];
                    catalog[j] = catalog[j+1];
                    catalog[j+1] = temp;
                }
            }
        }
        return catalog;
    }
    //sort array method - by Subject
    public Card[] sortBySubject(Card[] catalog) {
        for (int i = 0; i < cardNum; i++) {
            for (int j = 0; j < cardNum; j++) {
                int x = catalog[j].getSubject().compareTo(catalog[j+1].getSubject());
                if (x > 0) {
                    // swap temp and arr[i]
                    Card temp = catalog[j];
                    catalog[j] = catalog[j+1];
                    catalog[j+1] = temp;
                }
            }
        }
        return catalog;
    }
    //printing main catalog array to the user desired by him
    public void printTheCatalog(String sortType) {
        if (sortType == "title") {
            for (int i = 0; i < cardNum; i++) {
                System.out.println(sortedTitle[i].getTitle());
                System.out.println(sortedTitle[i].getAuthor());
                System.out.println(sortedTitle[i].getSubject());
                System.out.println("===========================");
            }
        } else if (sortType == "author") {
            for (int i = 0; i < cardNum; i++) {
                System.out.println(sortedAuthor[i].getTitle());
                System.out.println(sortedAuthor[i].getAuthor());
                System.out.println(sortedAuthor[i].getSubject());
                System.out.println("===========================");
            }
        } else if (sortType == "subject") {
            for (int i = 0; i < cardNum; i++) {
                System.out.println(sortedSubject[i].getTitle());
                System.out.println(sortedSubject[i].getAuthor());
                System.out.println(sortedSubject[i].getSubject());
                System.out.println("===========================");
            }
        } else {
            System.out.println("Please enter a valid type");
        }
    }
    //adding a card to the catalog
    public void addACard(Card card) {
        catalog[cardNum] = card;
        sortedTitle[cardNum] = card;

        sortedTitle = sortByTitle(sortedTitle);
        sortedAuthor = sortByAuthor(catalog);
        sortedSubject = sortBySubject(catalog);
        cardNum++;
    }
    
    //returns the first card with the given title
    public Card getATitle(String title) {
        for (int i = 0; i < cardNum; i++) {
            if ( title.equals(catalog[i].getTitle()) ) {
                return catalog[i];
            }
        }
        return null;
    }

    //returns all the books written by the given author
    public Card[] getAnAuthor(String author) {
        int count  = 0;
        for (int i = 0; i < cardNum; i++) {
            if ( author.equals(catalog[i].getAuthor()) ) {
                count++;
            }
        }
        Card[] arr = new Card[count];
        int x = 0;
        for (int i = 0; i < cardNum; i++) {
            if ( author.equals(catalog[i].getAuthor()) ) {
                arr[x++] = catalog[i];
            }
        }
        return arr;
    }

    //returns an array of books with the given subject
    public Card[] getASubject(String subject) {
        int count  = 0;
        for (int i = 0; i < cardNum; i++) {
            if ( subject.equals(catalog[i].getSubject()) ) {
                count++;
            }
        }
        Card[] arr = new Card[count];
        int x = 0;
        for (int i = 0; i < cardNum; i++) {
            if ( subject.equals(catalog[i].getSubject()) ) {
                arr[x++] = catalog[i];
            }
        }
        return arr;
    }

    //updates the main catalog array by removing the book with the given title
    public void removeATitle(String title) {
        for (int i = 0; i < cardNum; i++) {
            if ( title.equals(catalog[i].getTitle()) ) {
                for ( int j = i; j < cardNum - 1; j++) {
                    catalog[j] = catalog[j+1];
                    i++;
                }
                catalog[cardNum - 1] = null;
            }
        }
        for (int i = 0; i < cardNum; i++) {
            if ( title.equals(sortedTitle[i].getTitle()) ) {
                for ( int j = i; j < cardNum - 1; j++) {
                    sortedTitle[j] = sortedTitle[j+1];
                    i++;
                }
                sortedTitle[cardNum - 1] = null;
            }
        }for (int i = 0; i < cardNum; i++) {
            if ( sortedAuthor[i] != null && title.equals(sortedAuthor[i].getTitle()) ) {
                for ( int j = i; j < cardNum - 1; j++) {
                    sortedAuthor[j] = sortedAuthor[j+1];
                    i++;
                }
                sortedAuthor[cardNum - 1] = null;
                
            }
        }for (int i = 0; i < cardNum; i++) {
            if ( sortedSubject[i] != null && title.equals(sortedSubject[i].getTitle()) ) {
                for ( int j = i; j < cardNum - 1; j++) {
                    sortedSubject[j] = sortedSubject[j+1];
                    i++;
                }
                sortedSubject[cardNum - 1] = null;
                
            }
        }
        cardNum--;
    }
}
