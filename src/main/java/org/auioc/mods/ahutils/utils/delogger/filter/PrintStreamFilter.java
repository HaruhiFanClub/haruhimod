package org.auioc.mods.ahutils.utils.delogger.filter;

import java.io.PrintStream;
import org.auioc.mods.ahutils.utils.delogger.Delogger;

public class PrintStreamFilter extends PrintStream {

    public PrintStreamFilter(PrintStream stream) {

        super(stream);
    }

    @Override
    public void println(String s) {
        if (!Delogger.shouldFilterMessage(s)) {
            super.println(s);
        }
    }

    @Override
    public void print(String s) {

        if (!Delogger.shouldFilterMessage(s)) {
            super.print(s);
        }
    }
}
