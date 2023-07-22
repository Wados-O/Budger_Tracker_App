package classes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

public class Operations {


  /**
   * Convert Date to String with pattern "dd.MM.yyyy"
   *
   * @param date date to be converted
   * @return String of date according to pattern
   */
  public static String dateToString(Date date) {
    DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    return dateFormat.format(date);
  }

}
