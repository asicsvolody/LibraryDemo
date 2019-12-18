/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

package ru.yakimov.shell;

import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.yakimov.bookService.BookService;
import ru.yakimov.dao.BookDao;
import ru.yakimov.domain.Book;

@ShellComponent
public class DaoCommands {
    private BookDao dao;
    private ConsoleService console;
    private BookService bookService;

    public DaoCommands(BookDao dao, ConsoleService console, BookService bookService) {
        this.dao = dao;
        this.console = console;
        this.bookService = bookService;
    }

    @ShellMethod("Get book for id")
    public void getBookById(int id){
        Book book = dao.getById(id);
        this.console.write("Book id: %s\n" +
                "name: %s\n" +
                "writer: %s\n" +
                "pages: %s",
                book.getID(),
                book.getBOOK_NAME(),
                book.getWRITER(),
                book.getPAGES());
    }
    Availability getBookByIdAvailability(){
        return this.bookService.isAuthorization() ? Availability.available() : Availability.unavailable(" You are not auth");
    }

    @ShellMethod("Insert into table")
    public void insertBook(Book book){
        int res = this.dao.insert(book);
        this.console.write(res==1? "OK": "ERROR");
    }






}
