package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
    public static Date parseToDate(String s) throws ParseException {
        DateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        return parser.parse(s);
    }
}
