package school.sorokin.javacore;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Publication> publications;

    public Library() {
        this.publications = new ArrayList<>();
    }

    public void addPublication(Publication pub) {
        if (pub != null) {
            this.publications.add(pub);
        } else {
            System.out.println("Publication is null");
        }
    }

    public void listPublications() {
        if (this.publications.size() > 0) {
            System.out.println("List of publications: ");
            for (Publication pub : this.publications) {
                castPublication(pub);
            }
        } else {
            System.out.println("Publication is empty.");
        }
    }

    public void searchByAuthor(String author) {
        boolean found = false;
        for (Publication pub : publications) {
            if (pub.getAuthor().equalsIgnoreCase(author)) {
                castPublication(pub);
                found = true;
            }
        }
        if (!found) {
            System.out.printf("Author '%s' wasn't found", author);
            System.out.println();
        }
    }

    //detect Class of Publication
    private void castPublication(Publication pub) {
        if (pub.getType().equals("Book")) {
            System.out.println((Book) pub);
        } else if (pub.getType().equals("Magazine")) {
            System.out.println((Magazine) pub);
        } else {
            System.out.println((Newspaper) pub);
        }
    }
}
