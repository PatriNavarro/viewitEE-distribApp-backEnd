package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.Stateless;

@Stateless
public class CalendarConverter implements CalendarConverterLocal {

    public Calendar stringToCalendar(String sdate, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date ddate = sdf.parse(sdate);
        return dateToCalendar(ddate);
    }
    
    public Calendar dateToCalendar(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
    
}
