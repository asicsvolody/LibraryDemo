/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

package ru.yakimov.shell;

import org.springframework.stereotype.Service;

import java.io.PrintStream;

@Service
public class ConsoleService {
    private final String ANSI_YELLOW = "\u001B[33m";
    private final String ANSI_RESET = "\u001B[0m";
    PrintStream out = System.out;

    public void write(String msg, Object ... args){
        this.out.print("> ");
        this.out.print(ANSI_YELLOW);
        this.out.printf(msg, args);
        this.out.print(ANSI_RESET);
        this.out.println();
    }


}
