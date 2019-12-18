package ru.yakimov.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.yakimov.LibraryDemo;
import ru.yakimov.domain.Book;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {LibraryDemo.class})
public class BookDaoJdbcTest {

    @Autowired
    private BookDao bookDao;


    @Test
    public void getById() {
        assertEquals("WAR AND PEACE", bookDao.getById(1).getBOOK_NAME() );
    }

    @Test
    public void getByName() {
        assertSame(1,bookDao.getByName("WAR AND PEACE").getID() );
    }

    @Test
    public void getAllOfWriter() {
        assertSame(3, bookDao.getAllOfWriter("Boris Akunin").size());
    }

    @Test
    public void getAll() {
        assertSame(4, bookDao.getAll().size());

    }

    @Test
    public void insert() {
        bookDao.insert(new Book(7,"Volleyball", "Vladimir Yakimov", 500));
        assertEquals("Volleyball", bookDao.getById(7).getBOOK_NAME());
    }

    @Test
    public void deleteBook() {
        int count = bookDao.getAll().size();
        bookDao.deleteBook("WAR AND PEACE");
        assertSame(count-1, bookDao.getAll().size());

    }
}