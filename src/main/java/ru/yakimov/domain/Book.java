/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

package ru.yakimov.domain;

import java.util.Objects;

public class Book {
    private final int ID;
    private final String BOOK_NAME;
    private final String WRITER;
    private final int PAGES;

    public Book(int ID, String BOOK_NAME, String WRITER, int PAGES) {
        this.ID = ID;
        this.BOOK_NAME = BOOK_NAME;
        this.WRITER = WRITER;
        this.PAGES = PAGES;
    }

    public int getID() {
        return ID;
    }

    public String getBOOK_NAME() {
        return BOOK_NAME;
    }

    public String getWRITER() {
        return WRITER;
    }

    public int getPAGES() {
        return PAGES;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ID=" + ID +
                ", NAME='" + BOOK_NAME + '\'' +
                ", WRITER='" + WRITER + '\'' +
                ", PAGES=" + PAGES +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return ID == book.ID &&
                PAGES == book.PAGES &&
                BOOK_NAME.equals(book.BOOK_NAME) &&
                WRITER.equals(book.WRITER);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, BOOK_NAME, WRITER, PAGES);
    }
}
