package string.class_problems;

import java.time.LocalDate;
import java.util.Scanner;

abstract class LibraryItem {

    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    abstract LocalDate getDueDate();
}

class Book extends LibraryItem {

    public Book(String title) {
        super(title);
    }

    @Override
    LocalDate getDueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(14);
    }
}

class DVD extends LibraryItem {

    public DVD(String title) {
        super(title);
    }

    @Override
    LocalDate getDueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(7);
    }
}

class Magazine extends LibraryItem {

    public Magazine(String title) {
        super(title);
    }

    @Override
    LocalDate getDueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(3);
    }
}

public class LibraryDueDate {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            int firstSpace = line.indexOf(' ');
            String type = line.substring(0, firstSpace);

            String title = line.substring(firstSpace + 1)
                               .replace("\"", "");

            LibraryItem item;

            if (type.equals("BOOK")) {
                item = new Book(title);
            } else if (type.equals("DVD")) {
                item = new DVD(title);
            } else {
                item = new Magazine(title);
            }

            System.out.println(
                title + ": " + item.getDueDate()
            );
        }

        sc.close();
    }
}