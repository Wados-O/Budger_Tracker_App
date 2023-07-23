package classes;

import java.util.Date;
import java.util.List;

public class Output {

  /**
   * Print table with list of records
   *
   * @param records List of Record with payments (can be sorted and filtered before)
   */
  public static void printList(List<Record> records) {
    for (Record record : records) {
      String recordRow = String.format("│%6d│%24s│%25s│%22s│%24.2f│%34s│",
          record.getId(), Operations.dateToString(record.getDate()), record.getCategory(),
          record.getUser(), record.getAmount(), record.getComment());
      System.out.println(recordRow);
      System.out.println(
          "├┈┈┈┈┈┈┼┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┼┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┼┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┼┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┼┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┤");
    }
    System.out.println(
        "└┈┈┈┈┈┈┸┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┸┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┸┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┸┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┸┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┘");
    /**
     * print Chart with percents of expenses by Category
     *
     * @param records    List of Record with payments (can be sorted and filtered before)
     * @param categories List of Categories
     * @param dateBegin  Begin of payments period
     * @param dateEnd    End of payments period
     */

  }
  public static void chartCategory(List<Record> records,List<Category> categories,
      Date dateBegin,Date dateEnd){
    String color = Colors.RESET;
    System.out.println(Colors.WHITE_BRIGHT + "┎┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┒");
    System.out.println(Colors.WHITE_BRIGHT +"┃     CATEGORY     ┃                                           AMOUNT                                          ┃");
    System.out.println(Colors.WHITE_BRIGHT +"┖┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┸┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┚"+Colors.RESET);

    double totalEx = -1 * Operations.calcExpensesPeriod(records,dateBegin,dateEnd);
    for (Category category : categories){
      double categorySum = -1 * Operations.expensesByCategory(records,category.getTitle(),dateBegin,dateEnd);
      double percent = categorySum * 100 / totalEx;
      System.out.printf("| %16s |",category.getTitle());
      for (int i = 0; i < percent; i++) {
        if (percent < 10) color = Colors.YELLOW;
        if (percent > 10) color = Colors.BLUE;
        if (percent > 15) color = Colors.CYAN;
        if (percent > 30) color = Colors.RED_BRIGHT;
        System.out.print(color + "*");
        color = Colors.RESET;
      }
      percent = Math.round(percent);
      System.out.println(Colors.WHITE_BRIGHT + " " + Colors.WHITE_BRIGHT + categorySum + Colors.RESET + " (" + percent + "% )");
    }
  }


}
