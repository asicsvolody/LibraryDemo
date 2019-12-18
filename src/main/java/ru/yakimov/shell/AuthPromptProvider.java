/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

package ru.yakimov.shell;

import org.jline.utils.AttributedString;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.stereotype.Component;
import ru.yakimov.bookService.BookService;

@Component
public class AuthPromptProvider implements PromptProvider {

    private BookService bookService;

    public AuthPromptProvider(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public AttributedString getPrompt() {
        String message = String.format("testing (%s) >", this.bookService.isAuthorization()? this.bookService.getUser() : "dis-auth");
        return new AttributedString(message);
    }
}
