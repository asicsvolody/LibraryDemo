/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

package ru.yakimov.dao;

import ru.yakimov.domain.Book;

import java.util.List;

public interface BookDao{
    Book getById(int id);

    Book getByName(String name);

    List<Book> getAllOfWriter(String writer);

    List<Book> getAll();

    int insert(Book book);

    int deleteBook(String name);

}
