/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

package ru.yakimov.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.yakimov.domain.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookDaoJdbc implements BookDao {

    private NamedParameterJdbcOperations jdbc;

    public BookDaoJdbc(NamedParameterJdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Book getById(int id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        return jdbc.queryForObject("SELECT * FROM books WHERE ID = :id"
                ,params
                , new BookMapper() );
    }

    @Override
    public Book getByName(String bookName) {
        Map<String, Object> params = Collections.singletonMap("book_name", bookName);
        return jdbc.queryForObject("SELECT * FROM books WHERE book_name= :book_name"
                ,params
                , new BookMapper() );    }

    @Override
    public List<Book> getAllOfWriter(String writer) {
        Map<String, Object> params = Collections.singletonMap("writer", writer);

        return jdbc.query("SELECT * FROM books WHERE writer = :writer"
                , params
                , new BookMapper());
    }

    @Override
    public List<Book> getAll() {
        return jdbc.query("SELECT * FROM books", new BookMapper());
    }

    @Override
    public int insert(Book book) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", book.getID());
        params.put("book_name", book.getBOOK_NAME());
        params.put("writer", book.getWRITER());
        params.put("pages", book.getPAGES());

        return jdbc.update("INSERT INTO books(id, book_name, writer,pages) values (:id, :book_name, :writer, :pages)", params);
    }

    @Override
    public int deleteBook(String name) {
        Map<String, Object> params = Collections.singletonMap("book_name", name);
        return jdbc.update("DELETE FROM books WHERE book_name = :book_name", params);
    }

    private static class BookMapper implements RowMapper<Book>{
        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            String bookName = resultSet.getString("book_name");
            String writer = resultSet.getString("writer");
            int pages = resultSet.getInt("pages");
            return new Book(id, bookName, writer, pages);
        }
    }

}
