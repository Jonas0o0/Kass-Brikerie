package src.main.java.inputs;

import java.util.Date;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

public class tickInputs {
    public static char inputKey() throws Exception{
        Terminal terminal = TerminalBuilder.builder()
                .system(true)
                .jna(true)
                .build();
        
        terminal.enterRawMode();
        var reader = terminal.reader();
        terminal.reader().close();

        Date adate = new Date();
        long atime = adate.getTime();
        System.out.println(atime);
        int ch = reader.read(100);
        Date bdate = new Date();

        long btime = bdate.getTime();
        if (btime - atime < 100) {
            Thread.sleep(100 - (btime - atime));
            System.out.println(new Date().getTime() - atime);
        }
        reader.close();
        terminal.close();

        return ((char)ch);
    }
}
