package com.pluralsight;
// creating the properties of the class book + storing using data structures + accessibility
public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    // *** constructors ***
    public Book() {
        this.id = 0;
        this.isbn = "";
        this.title = "";
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }
    public Book(int id, String isbn, String title) {
        this();
        this.id = id;
        this.isbn = isbn;
        this.title = title;
    }
    //*** getters ***
    public int getId(){
        return id;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getTitle() {
        return title;
    }
    public boolean isCheckedOut() {
        return isCheckedOut;
    }
    public String getCheckedOutTo() {
        return checkedOutTo;
    }

}
