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

@ShellComponent
public class AuthorizationCommands {
    private BookService bookService;
    private ConsoleService consoleService;

    public AuthorizationCommands(BookService bookService, ConsoleService consoleService) {
        this.bookService = bookService;
        this.consoleService = consoleService;
    }

    @ShellMethod("authorization in system")
    public void auth(@ShellOption String username, @ShellOption String password){
        bookService.authorization(username, password);
        consoleService.write("Auth " + username);
    }

    Availability authAvailability(){
        return  !this.bookService.isAuthorization()
                ?Availability.available()
                : Availability.unavailable("You are all ready authorization");
    }

    @ShellMethod("disAuthorization in system")
    public void disAuth(){
        bookService.disAuthorization();
        consoleService.write("Dis auth");
    }

    Availability disAuthAvailability(){
        return this.bookService.isAuthorization()
                ? Availability.available()
                : Availability.unavailable(" You are not authorization");
    }

}
