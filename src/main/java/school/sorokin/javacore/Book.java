package school.sorokin.javacore;

import java.util.Objects;

public class Book extends Publication implements Printable {
    private String isbn;

    public Book(String title, String author, int year, String isbn) {
        super(title, author, year);
        this.isbn = isbn;
    }

    public String getisbn() {
        return isbn;
    }

    public void setisbn(String isbn) {
        this.isbn = isbn;
    }

    @Override

    public String getType() {
        return "Book";
    }

    @Override
    public void printDetails() {
        System.out.println(getType());
        printPublication();
        System.out.println("isbn: " + isbn);
    }

    @Override
    public String toString() {
        return "Book{" + super.toString() + ", isbn='" + isbn + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Book book)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isbn);
    }
}
