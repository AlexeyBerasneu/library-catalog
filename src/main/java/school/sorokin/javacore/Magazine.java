package school.sorokin.javacore;

import java.util.Objects;

public class Magazine extends Publication implements Printable {
    private int issueNumber;

    public Magazine(String title, String author, int year, int issueNumber) {
        super(title, author, year);
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    @Override
    public void printDetails() {
        System.out.println("issueNumber: " + issueNumber);
        printPublication();
    }

    @Override
    public String getType() {
        return "Magazine";
    }

    @Override
    public String toString() {
        return "Magazine{" + super.toString() + ", issueNumber=" + issueNumber + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Magazine magazine)) return false;
        if (!super.equals(o)) return false;
        return issueNumber == magazine.issueNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), issueNumber);
    }
}
