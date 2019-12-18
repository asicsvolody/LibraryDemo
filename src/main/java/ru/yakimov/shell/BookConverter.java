/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

package ru.yakimov.shell;

import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import ru.yakimov.domain.Book;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class BookConverter implements Converter<String, Book> {

    private final Pattern pattern = Pattern.compile("\\(#(\\d+//\\w+//\\w+//\\d+)\\)");

    @Override
    public Book convert(String source) {
        Matcher matcher = this.pattern.matcher(source);
        if(matcher.find()){
            String group = matcher.group(1);
            if(StringUtils.hasText(group)){
                String[] data = group.split("//");
                int id = Integer.parseInt(data[0]);
                String bookName = data[1];
                String writer = data[2];
                int pages = Integer.parseInt(data[3]);
                return new Book(id, bookName, writer, pages);
            }
        }
        return null;
    }
}
