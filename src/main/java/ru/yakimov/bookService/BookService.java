/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

package ru.yakimov.bookService;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class BookService {
    private String user;
    private String password;

    private AtomicBoolean isAuthorisation = new AtomicBoolean();

    public void authorization(String user, String password){
        this.user = user;
        this.password= password;
        isAuthorisation.set(true);
    }

    public void disAuthorization(){
        this.user = null;
        this.password = null;
        isAuthorisation.set(false);
    }

    public boolean isAuthorization(){
        return this.isAuthorisation.get();
    }

    public String getUser() {
        return user;
    }
}
