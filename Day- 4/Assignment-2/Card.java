public final class Card {

    private String title;
    private String author;
    private String subject;

    public Card(String title, String author, String subject) {
        this.title = title;
        this.author = author;
        this.subject = subject;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = title;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    
    public String getSubject() {
        return subject;
    }

    public String toString() {
        return "{ Title = " + title + ", Author = " + author
                + ", Subject = " + subject + " }";
    }
}
