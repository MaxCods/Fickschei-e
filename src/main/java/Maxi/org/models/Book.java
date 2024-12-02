package Maxi.org.models;

public class Book extends AbstractModel {
    Author author;
    String titel;
    String iSBN;
    int publishedYear;

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getiSBN() {
        return iSBN;
    }

    public void setISBN(String iSBN) {
        this.iSBN = iSBN;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }
}
