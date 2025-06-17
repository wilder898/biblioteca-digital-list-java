package com.sena.app.models;

public class Book {
    private static int nextId = 1;
    private int id;
    private String title;
    private String edititionDate;
    private String editorial;
    private String isbn;

    public Book(String title, String edititionDate, String editorial, String isbn) {
        this.id = nextId++;
        this.title = title;
        this.edititionDate = edititionDate;
        this.editorial = editorial;
        this.isbn = isbn;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Book.nextId = nextId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEdititionDate() {
        return edititionDate;
    }

    public void setEdititionDate(String edititionDate) {
        this.edititionDate = edititionDate;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    

}
