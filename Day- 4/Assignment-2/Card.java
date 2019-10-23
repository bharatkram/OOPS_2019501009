public class Card {
    private String title;
    private String author;
    private String subject;
    //constructor
    Card(String title, String author, String subject) {
        this.title = title;
        this.author = author;
        this.subject = subject;
    }
    //getTitle
    public String getTitle() {
        return title;
    }
    //getAuthor
    public String getAuthor() {
        return author;
    }
    //getSubject
    public String getSubject() {
        return subject;
    }
}
