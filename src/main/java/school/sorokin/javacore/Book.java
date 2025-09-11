package school.sorokin.javacore;

import java.util.Objects;

public class Book extends Publication implements Printable {
    private String ISBN;

    public Book(String title, String author, int year, String ISBN) {
        super(title, author, year);
        this.ISBN = ISBN;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override

    public String getType() {
        return "Book";
    }

    @Override
    public void printDetails() {
        System.out.println("ISBN: " + ISBN);
        printPublication();
    }

    @Override
    public String toString() {
        return "Book{" + super.toString() + ", ISBN='" + ISBN + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Book book)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(ISBN, book.ISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ISBN);
    }
}
