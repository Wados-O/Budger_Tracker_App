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
import java.util.Random;
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


  /**
   * Calculate payment balance in period
   *
   * @param records   List of Record with payments
   * @param dateBegin Begin of payments period minus one day
   * @param dateEnd   End of payments period plus one day
   * @return Sum of payments in this period
   */
  public static double calcBalance(List<Record> records, Date dateBegin, Date dateEnd) {
    return records.stream()
        .filter(x -> x.getDate().after(dateBegin))
        .filter(x -> x.getDate().before(dateEnd))
        .mapToDouble(Record::getAmount)
        .sum();
  }


  /**
   * Calculate Expenses in period
   *
   * @param records   List of Record with payments
   * @param dateBegin Begin of payments period minus one day
   * @param dateEnd   End of payments period plus one day
   * @return Sum of expenses in this period
   */


  public static double calcExpensesPeriod(List<Record> records, Date dateBegin, Date dateEnd) {
    return records.stream()
        .filter(x -> x.getDate().after(dateBegin))
        .filter(x -> x.getDate().before(dateEnd))
        .filter(x -> x.getAmount() < 0)
        .mapToDouble(Record::getAmount)
        .sum();
  }

  /**
   * Calculate expenses in period by User
   *
   * @param records   List of Record with payments
   * @param user      Username to find their expenses
   * @param dateBegin Begin of payments period minus one day
   * @param dateEnd   End of payments period plus one day
   * @return Sum of expenses by User in this period
   */
  public static double expensesByUser(List<Record> records, String user, Date dateBegin,
      Date dateEnd) {
    return records.stream()
        .filter(x -> x.getDate().after(dateBegin))
        .filter(x -> x.getDate().before(dateEnd))
        .filter(x -> x.getAmount() < 0)
        .filter(x -> x.getUser().equals(user))
        .mapToDouble(Record::getAmount)
        .sum();
  }

  /**
   * Calculate expenses in period by Category
   *
   * @param records   List of Record with payments
   * @param category  Category to find expenses by it
   * @param dateBegin Begin of payments period minus one day
   * @param dateEnd   End of payments period plus one day
   * @return Sum of expenses by User in this period
   */
  public static double expensesByCategory(List<Record> records, String category, Date dateBegin,
      Date dateEnd) {
    return records.stream()
        .filter(x -> x.getDate().after(dateBegin))
        .filter(x -> x.getDate().before(dateEnd))
        .filter(x -> x.getAmount() < 0)
        .filter(x -> x.getCategory().equals(category))
        .mapToDouble(Record::getAmount)
        .sum();
  }

  /**
   * Calculate expenses in period by Date
   *
   * @param records List of Record with payments
   * @param date    Date of expenses
   * @return Sum of expenses by User in this Date
   */

  public static double expensesByDate(List<Record> records, Date date) {
    return records.stream()
        .filter(x -> x.getDate().equals(date))
        .filter(x -> x.getAmount() < 0)
        .mapToDouble(Record::getAmount)
        .sum();
  }

  /**
   * Sort LIst of All Records by Date
   *
   * @param records List of Record with payments
   * @return new sorted LIst of Records
   */
  public static List<Record> sortByDate(List<Record> records) {
    List<Record> result;
    result = records.stream()
        .sorted(Comparator.comparing(Record::getDate))
        .collect(Collectors.toList());
    return result;
  }

  /**
   * Sort LIst of All Records by User
   *
   * @param records List of Record with payments
   * @return new sorted LIst of Records
   */
  public static List<Record> sortByUser(List<Record> records) {
    List<Record> result;
    result = records.stream()
        .sorted(Comparator.comparing(Record::getUser))
        .collect(Collectors.toList());
    return result;
  }

  /**
   * Sort LIst of All Records by Category
   *
   * @param records List of Record with payments
   * @return new sorted LIst of Records
   */
  public static List<Record> sortByCategory(List<Record> records) {
    List<Record> result;
    result = records.stream()
        .sorted(Comparator.comparing(Record::getCategory))
        .collect(Collectors.toList());
    return result;
  }

}
