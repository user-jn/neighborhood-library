package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        //title
        System.out.println("*** Welcome to the Neighborhood Library! ***");

        // Array of books (id, isbn, title)
        Book[] inventory = {
                new Book(1, "9780544336261", "The Giver"),
                new Book(2, "9781954839243", "The Great Gatsby"),
                new Book(3, "9780316769174", "The Catcher in the Rye"),
                new Book(4, "9780452262935", "1984"),
                new Book(5, "9780141439518", "The Republic"),
                new Book(6, "9780393356250", "The Odyssey"),
                new Book(7, "9781365854088", "The Iliad"),
                new Book(8, "9781451673319", "The Lessons of History"),
                new Book(9, "9780060935467", "Leonardo da Vinci"),
                new Book(10, "9781594631931", "The Kite Runner"),
                new Book(11, "9781594483851", "Napoleon: A Life"),
                new Book(12, "9780525432722", "American Prometheus"),
                new Book(13, "9781982185824", "The Power Broker"),
                new Book(14, "9780679734505", "The Beginning of Infinity"),
                new Book(15, "9781335430991", "Superintelligence"),
                new Book(16, "9780525562047", "Because of Winn-Dixie"),
                new Book(17, "9780618706419", "The Player of Games"),
                new Book(18, "9780375842207", "Steve Jobs"),
                new Book(19, "9780143127550", "Why Nations Fail"),
                new Book(20, "9780062060624", "The Help"),
        };

                // display menu
                String currentChoice = "";

                // keep showing menu until user enter x
                while (!currentChoice.equalsIgnoreCase("X")) {

                    displayMenuOptions();

                    // Get user choice
                    currentChoice = scnr.nextLine().trim();

                    // Navigate through menu options
                    switch (currentChoice.toUpperCase()) {

                        case "1":
                            // Show available books
                            showAvailableBooks(inventory);

                            // Allow user to check out a book
                            checkOut(inventory, scnr);
                            break;

                        case "2":
                            // Show checked out books
                            showCheckedOutBooks(inventory);

                            // Ask user to check in or return
                            String checkInChoice = "";

                            while (!checkInChoice.equalsIgnoreCase("X")) {

                                System.out.print("Press C to check in a book, or X to return: ");
                                checkInChoice = scnr.nextLine().trim();

                                if (checkInChoice.equalsIgnoreCase("C")) {
                                    checkIn(inventory, scnr);
                                    break;

                                }
                                else if (!checkInChoice.equalsIgnoreCase("X")) {
                                    System.out.println("Invalid choice! Enter C or X.");
                                }
                            }
                            break;

                        case "X":
                            System.out.println("Thank you for visiting!");
                            break;

                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }

                scnr.close();

    }

        // methods
        // display menu options
        public static void displayMenuOptions () {


            System.out.print("""
                \n--------------------------------
                What would you like to do?
                    1. Show Available Books
                    2. Show Checked Out Books
                    X. Exit
                Enter choice (1, 2, X):\s""");
        }

        // show available books method
        public static void showAvailableBooks (Book[]inventory){


            System.out.println("--- AVAILABLE BOOKS ---");

            // using loop to iterate through array
            for (Book book : inventory) {

                // Display books that are NOT checked out
                if (!book.isCheckedOut()) {

                    System.out.println("ID: " + book.getId()
                            + " | ISBN: " + book.getIsbn()
                            + " | Title: " + book.getTitle());
                }
            }
        }

        // show checked out books
        public static void showCheckedOutBooks (Book[]inventory){

            System.out.println("\n--- CHECKED OUT BOOKS ---");

            // Loop through each book
            for (Book book : inventory) {

                // Only display checked out books
                if (book.isCheckedOut()) {

                    System.out.println("ID: " + book.getId()
                            + " | ISBN: " + book.getIsbn()
                            + " | Title: " + book.getTitle()
                            + " | Checked Out To: " + book.getCheckedOutTo());
                }
            }
        }

        // Check out a book
        public static void checkOut (Book[]inventory, Scanner scnr){

            // Ask user for book ID
            System.out.print("\nEnter Book ID to check out, or (0 to return home): ");

            int bookId;

            // handling invalid number input

            // Handle invalid number input
            try {
                bookId = Integer.parseInt(scnr.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid book ID.");
                return;
            }

            // Return to main menu
            if (bookId == 0) {
                return;
            }

            // search for matching book ID
            for (Book book : inventory) {

                if (book.getId() == bookId) {

                    // Check if book is available
                    if (!book.isCheckedOut()) {

                        System.out.print("Enter your full name: ");
                        String name = scnr.nextLine().trim();

                        if (name.isEmpty()) {
                            System.out.println("Name cannot be empty.");
                            return;
                        }

                        // Call checkOut() from Book class
                        book.checkOut(name);
                    } else {
                        System.out.println("This book is already checked out. Please try again.");
                    }
                    return;

                }
            }

            System.out.println("Book not found.");
        }
        //check in a book
        public static void checkIn (Book[]inventory, Scanner scnr){

            // Ask user for book ID
            System.out.print("Enter Book ID to check in: ");

            int bookId;

            // Handle invalid input
            try {
                bookId = Integer.parseInt(scnr.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid book ID.");
                return;
            }

            // Search for matching book
            for (Book book : inventory) {

                if (book.getId() == bookId) {

                    // Check if book is checked out
                    if (book.isCheckedOut()) {

                        // Call checkIn() from Book class
                        book.checkIn();
                    } else {
                        System.out.println("This book is already available.");
                    }

                    return;
                }
            }

            System.out.println("Book not found.");
        }
    }



