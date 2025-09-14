package school.sorokin.javacore;

import java.util.Objects;

public class Newspaper extends Publication implements Printable {
    private final String publicationDay;

    public Newspaper(String title, String author, int year, String publicationDay) {
        super(title, author, year);
        this.publicationDay = publicationDay;
    }

    @Override
    public void printDetails() {
        System.out.println("publicationDay: " + publicationDay);
        printPublication();
    }

    @Override
    public String getType() {
        return "Newspaper";
    }

    @Override
    public String toString() {
        return "Newspaper{" + super.toString() + ", publicationDay: " + publicationDay + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Newspaper newspaper)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(publicationDay, newspaper.publicationDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), publicationDay);
    }
}
