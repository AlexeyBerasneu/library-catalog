package school.sorokin.javacore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int presentYear = 2025;
    private static final int startYear = 1500;
    private static final Library library = new Library();

    public static void main(String[] args) {
        while (true) {
            printMenu();
            String input = scanner.nextLine().trim();
            switch (input) {
                case "1" -> {
                    System.out.println(" Choose type of publication: \n " +
                            "1. Book 2. Magazine 3. Newspaper");
                    String type = scanner.nextLine();
                    switch (type) {
                        case "1" -> {
                            createBook();
                        }
                        case "2" -> {
                            createMagazine();
                        }
                        case "3" -> {
                            createNewspaper();
                        }
                        default -> {
                            System.out.println("Invalid input. Try again.");
                        }
                    }
                }
                case "2" -> {
                    library.listPublications();
                }
                case "3" -> {
                    library.searchByAuthor(validName("author's name"));
                }
                case "4" -> {
                    System.out.printf("Common quantity of publications is %d\n", Publication.getPublicationCount());
                }
                case "5" -> {
                    return;
                }
                default -> {
                    System.out.println("Invalid input. Try again.");
                }
            }
        }
    }

    public static void printMenu() {
        System.out.println();
        System.out.println("Menu:");
        System.out.println("1. Add publication");
        System.out.println("2. List of publications");
        System.out.println("3. Search by author");
        System.out.println("4. Common quantity of publications");
        System.out.println("5. Exit");
        System.out.print("Enter number of command: ");
    }

    //validation name
    private static String validName(String nameOfField) {
        System.out.printf("Enter %s : ", nameOfField);
        while (true) {
            String name = scanner.nextLine().trim();
            if (!name.isEmpty() && name != null) {
                return name;
            } else {
                System.out.printf("Invalid %s try again.\n", nameOfField);
            }
        }
    }

    //get common field for Publication
    private static List<String> baseField() {
        List<String> fields = new ArrayList<>();
        fields.add(validName("title"));
        fields.add(validName("author"));
        while (true) {
            Integer year = validateNumber("year");
            if (startYear <= year && year <= presentYear) {
                fields.add(String.valueOf(year));
                break;
            } else {
                System.out.printf("The year is out of range '%d-%d' try again.\n", startYear, presentYear);
            }
        }
        return fields;
    }

    //validate number
    private static int validateNumber(String nameOfField) {
        while (true) {
            System.out.printf("Enter %s : ", nameOfField);
            String number = scanner.nextLine().trim();
            try {
                return Integer.parseInt(number);
            } catch (NumberFormatException e) {
                System.out.printf("Invalid %s try again.\n", nameOfField);
            }
        }
    }

    //validate Day from ENUM
    private static String validateDay(String nameOfField) {
        while (true) {
            System.out.printf("Enter %s : ", nameOfField);
            String day = scanner.nextLine().trim();
            try {
                Enum.valueOf(Days.class, day.toUpperCase());
                return day;
            } catch (Exception e) {
                System.out.printf("Invalid %s try again.\n", nameOfField);
            }
        }
    }

    //create Book
    private static void createBook() {
        List<String> publicationField = baseField();
        Book book = new Book(
                publicationField.get(0),
                publicationField.get(1),
                Integer.parseInt(publicationField.get(2)),
                validName("ISBN")
        );
        library.addPublication(book);
        System.out.println("Book added successfully.");
    }

    //crete Magazine
    private static void createMagazine() {
        List<String> publicationField = baseField();
        Magazine magazine = new Magazine(
                publicationField.get(0),
                publicationField.get(1),
                Integer.parseInt(publicationField.get(2)),
                validateNumber("issueNumber")
        );
        library.addPublication(magazine);
        System.out.println("Magazine added successfully.");
    }

    //create Newspaper
    private static void createNewspaper() {
        List<String> publicationField = baseField();
        Newspaper newspaper = new Newspaper(
                publicationField.get(0),
                publicationField.get(1),
                Integer.parseInt(publicationField.get(2)),
                validateDay("day of week").toUpperCase()
        );
        library.addPublication(newspaper);
        System.out.println("Newspaper added successfully.");
    }
}