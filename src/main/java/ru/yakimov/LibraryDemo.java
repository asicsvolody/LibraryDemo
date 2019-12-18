/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

package ru.yakimov;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.yakimov.dao.BookDao;

import java.sql.SQLException;


@SpringBootApplication
public class LibraryDemo {
    public static void main(String[] args) throws SQLException {
        SpringApplication.run(LibraryDemo.class);
    }
}
