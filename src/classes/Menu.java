package classes;

import com.sun.tools.javac.Main;
import java.awt.AWTException;
import java.awt.PageAttributes;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Menu {

  public static final String LINEOPEN = "┌┈┈┈┈┈┈┰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┒";
  public static final String HEADER = "│  ID  │          DATA          │         CATEGORY        │         USER         │         AMOUNT         │             COMMENTS             │";
  public static final String LINECLOSE = "┠┈┈┈┈┈┈┼┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┼┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┼┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┼┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┼┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┤";

  /**
   * Print header for table of records
   */

  public static void printHeader() {
    System.out.println(Colors.WHITE_BOLD_BRIGHT + LINEOPEN + Colors.RESET);
    System.out.println(Colors.WHITE_BOLD_BRIGHT + HEADER + Colors.RESET);
    System.out.println(Colors.WHITE_BOLD_BRIGHT + Colors.RESET);
  }

  /**
   * make delay for 2000ms
   */

  public static void delayMain() {
    int delay = 2000;
    long start = System.currentTimeMillis();
    while (start > System.currentTimeMillis() - delay)
      ;
  }

  /**
   * make delay for 100ms
   */
  public static void delaySecond() {
    int delay = 100;
    long start = System.currentTimeMillis();
    while (start >= System.currentTimeMillis() - delay)
      ;
  }

  /**
   * clear console
   *
   * @throws AWTException
   */
  public static void clearAll() throws AWTException {
    Robot r = new Robot();
    r.keyPress(KeyEvent.VK_CONTROL);
    r.keyPress(KeyEvent.VK_Q);
    r.keyRelease(KeyEvent.VK_CONTROL);
    r.keyRelease(KeyEvent.VK_Q);
  }

  public static final String LEGEND = ""
      + "\n"
      + Colors.GREEN_BRIGHT + "LEGEND:      "
      + Colors.YELLOW + " 0 < 10% " + Colors.RESET + " | "
      + Colors.BLUE + "11 < 20% " + Colors.RESET + " | "
      + Colors.CYAN + "21 < 30% " + Colors.RESET + " | "
      + Colors.RED + " > 30% " + Colors.RESET + " | "
      + "\n";

  public static final String SHOW_SYSTEM_MENU_MAIN = ""
      + "\n\n"
      + Colors.WHITE_BACKGROUND + Colors.BLACK_BOLD + " e - Edit " + Colors.RESET + " "
      + Colors.WHITE_BACKGROUND + Colors.BLACK_BOLD + " a - Add " + Colors.RESET + " "
      + Colors.WHITE_BACKGROUND + Colors.BLACK_BOLD + " d - Delete " + Colors.RESET + " "
      + Colors.WHITE_BACKGROUND + Colors.BLACK_BOLD + " q - Exit " + Colors.RESET + " ";
  public static final String SHOW_SYSTEM_MENU = ""
      + "\n\n"
      + Colors.WHITE_BACKGROUND + Colors.BLACK_BOLD + " r - Return " + Colors.RESET + " "
      + Colors.WHITE_BACKGROUND + Colors.BLACK_BOLD + " e - Edit " + Colors.RESET + " "
      + Colors.WHITE_BACKGROUND + Colors.BLACK_BOLD + " a - Add " + Colors.RESET + " "
      + Colors.WHITE_BACKGROUND + Colors.BLACK_BOLD + " d - Delete " + Colors.RESET + " "
      + Colors.WHITE_BACKGROUND + Colors.BLACK_BOLD + " q - Exit " + Colors.RESET + " ";
  public static final String SHOW_ALL_MENU_MAIN = ""
      + Colors.YELLOW_BRIGHT + "SORT BY:      " + Colors.YELLOW_BACKGROUND
      + Colors.WHITE_BOLD_BRIGHT + " 1-Id " + Colors.RESET + " "
      + Colors.YELLOW_BACKGROUND + Colors.WHITE_BOLD_BRIGHT + " 2-User " + Colors.RESET + " "
      + Colors.YELLOW_BACKGROUND + Colors.WHITE_BOLD_BRIGHT + " 3-Category " + Colors.RESET + " "
      + Colors.YELLOW_BACKGROUND + Colors.WHITE_BOLD_BRIGHT + " 4-Amount " + Colors.RESET + " "
      + Colors.YELLOW_BACKGROUND + Colors.WHITE_BOLD_BRIGHT + " 5-Date " + Colors.RESET
      + "                        "
      + Colors.GREEN_BRIGHT + "CHART BY:     " + Colors.WHITE_BOLD_BRIGHT + Colors.GREEN_BACKGROUND
      + "  6 - Date  " + Colors.RESET + " "
      + Colors.WHITE_BOLD_BRIGHT + Colors.GREEN_BACKGROUND + "  7 - Category  " + Colors.RESET + " "
      + Colors.WHITE_BOLD_BRIGHT + Colors.GREEN_BACKGROUND + "  8 - User  " + Colors.RESET + " ";
  public static final String SHOW_ALL_MENU_ID = ""
      + Colors.YELLOW_BRIGHT + "SORT BY:      " + Colors.BLUE_BACKGROUND + Colors.WHITE_BOLD_BRIGHT
      + " 1-Id " + Colors.RESET + " "
      + Colors.YELLOW_BACKGROUND + Colors.WHITE_BOLD_BRIGHT + " 2-User " + Colors.RESET + " "
      + Colors.YELLOW_BACKGROUND + Colors.WHITE_BOLD_BRIGHT + " 3-Category " + Colors.RESET + " "
      + Colors.YELLOW_BACKGROUND + Colors.WHITE_BOLD_BRIGHT + " 4-Amount " + Colors.RESET + " "
      + Colors.YELLOW_BACKGROUND + Colors.WHITE_BOLD_BRIGHT + " 5-Date " + Colors.RESET
      + "                        "
      + Colors.GREEN_BRIGHT + "CHART BY:     " + Colors.WHITE_BOLD_BRIGHT + Colors.GREEN_BACKGROUND
      + "  6 - Date  " + Colors.RESET + " "
      + Colors.WHITE_BOLD_BRIGHT + Colors.GREEN_BACKGROUND + "  7 - Category  " + Colors.RESET + " "
      + Colors.WHITE_BOLD_BRIGHT + Colors.GREEN_BACKGROUND + "  8 - User  " + Colors.RESET + " ";
  public static final String SHOW_ALL_MENU_USER = ""
      + Colors.YELLOW_BRIGHT + "SORT BY:      " + Colors.YELLOW_BACKGROUND
      + Colors.WHITE_BOLD_BRIGHT + " 1-Id " + Colors.RESET + " "
      + Colors.BLUE_BACKGROUND + Colors.WHITE_BOLD_BRIGHT + " 2-User " + Colors.RESET + " "
      + Colors.YELLOW_BACKGROUND + Colors.WHITE_BOLD_BRIGHT + " 3-Category " + Colors.RESET + " "
      + Colors.YELLOW_BACKGROUND + Colors.WHITE_BOLD_BRIGHT + " 4-Amount " + Colors.RESET + " "
      + Colors.YELLOW_BACKGROUND + Colors.WHITE_BOLD_BRIGHT + " 5-Date " + Colors.RESET
      + "                        "
      + Colors.GREEN_BRIGHT + "CHART BY:     " + Colors.WHITE_BOLD_BRIGHT + Colors.GREEN_BACKGROUND
      + "  6 - Date  " + Colors.RESET + " "
      + Colors.WHITE_BOLD_BRIGHT + Colors.GREEN_BACKGROUND + "  7 - Category  " + Colors.RESET + " "
      + Colors.WHITE_BOLD_BRIGHT + Colors.GREEN_BACKGROUND + "  8 - User  " + Colors.RESET + " ";
  public static final String SHOW_ALL_MENU_CATEGORY = ""
      + Colors.YELLOW_BRIGHT + "SORT BY:      " + Colors.YELLOW_BACKGROUND
      + Colors.WHITE_BOLD_BRIGHT + " 1-Id " + Colors.RESET + " "
      + Colors.YELLOW_BACKGROUND + Colors.WHITE_BOLD_BRIGHT + " 2-User " + Colors.RESET + " "
      + Colors.BLUE_BACKGROUND + Colors.WHITE_BOLD_BRIGHT + " 3-Category " + Colors.RESET + " "
      + Colors.YELLOW_BACKGROUND + Colors.WHITE_BOLD_BRIGHT + " 4-Amount " + Colors.RESET + " "
      + Colors.YELLOW_BACKGROUND + Colors.WHITE_BOLD_BRIGHT + " 5-Date " + Colors.RESET
      + "                        "
      + Colors.GREEN_BRIGHT + "CHART BY:     " + Colors.WHITE_BOLD_BRIGHT + Colors.GREEN_BACKGROUND
      + "  6 - Date  " + Colors.RESET + " "
      + Colors.WHITE_BOLD_BRIGHT + Colors.GREEN_BACKGROUND + "  7 - Category  " + Colors.RESET + " "
      + Colors.WHITE_BOLD_BRIGHT + Colors.GREEN_BACKGROUND + "  8 - User  " + Colors.RESET + " ";
  public static final String SHOW_ALL_MENU_AMOUNT = ""
      + Colors.YELLOW_BRIGHT + "SORT BY:      " + Colors.YELLOW_BACKGROUND
      + Colors.WHITE_BOLD_BRIGHT + " 1-Id " + Colors.RESET + " "
      + Colors.YELLOW_BACKGROUND + Colors.WHITE_BOLD_BRIGHT + " 2-User " + Colors.RESET + " "
      + Colors.YELLOW_BACKGROUND + Colors.WHITE_BOLD_BRIGHT + " 3-Category " + Colors.RESET + " "
      + Colors.BLUE_BACKGROUND + Colors.WHITE_BOLD_BRIGHT + " 4-Amount " + Colors.RESET + " "
      + Colors.YELLOW_BACKGROUND + Colors.WHITE_BOLD_BRIGHT + " 5-Date " + Colors.RESET
      + "                        "
      + Colors.GREEN_BRIGHT + "CHART BY:     " + Colors.WHITE_BOLD_BRIGHT + Colors.GREEN_BACKGROUND
      + "  6 - Date  " + Colors.RESET + " "
      + Colors.WHITE_BOLD_BRIGHT + Colors.GREEN_BACKGROUND + "  7 - Category  " + Colors.RESET + " "
      + Colors.WHITE_BOLD_BRIGHT + Colors.GREEN_BACKGROUND + "  8 - User  " + Colors.RESET + " ";
  public static final String SHOW_ALL_MENU_DATE = ""
      + Colors.YELLOW_BRIGHT + "SORT BY:      " + Colors.YELLOW_BACKGROUND
      + Colors.WHITE_BOLD_BRIGHT + " 1-Id " + Colors.RESET + " "
      + Colors.YELLOW_BACKGROUND + Colors.WHITE_BOLD_BRIGHT + " 2-User " + Colors.RESET + " "
      + Colors.YELLOW_BACKGROUND + Colors.WHITE_BOLD_BRIGHT + " 3-Category " + Colors.RESET + " "
      + Colors.YELLOW_BACKGROUND + Colors.WHITE_BOLD_BRIGHT + " 4-Amount " + Colors.RESET + " "
      + Colors.BLUE_BACKGROUND + Colors.WHITE_BOLD_BRIGHT + " 5-Date " + Colors.RESET
      + "                        "
      + Colors.GREEN_BRIGHT + "CHART BY:     " + Colors.WHITE_BOLD_BRIGHT + Colors.GREEN_BACKGROUND
      + "  6 - Date  " + Colors.RESET + " "
      + Colors.WHITE_BOLD_BRIGHT + Colors.GREEN_BACKGROUND + "  7 - Category  " + Colors.RESET + " "
      + Colors.WHITE_BOLD_BRIGHT + Colors.GREEN_BACKGROUND + "  8 - User  " + Colors.RESET + " ";

  public static final String SHOW_ALL_MENU_CHART_DATE = ""

      + Colors.GREEN_BRIGHT + "CHART BY:     " + Colors.WHITE_BOLD_BRIGHT + Colors.BLUE_BACKGROUND
      + "  6 - Date  " + Colors.RESET + " "
      + Colors.WHITE_BOLD_BRIGHT + Colors.GREEN_BACKGROUND + "  7 - Category  " + Colors.RESET + " "
      + Colors.WHITE_BOLD_BRIGHT + Colors.GREEN_BACKGROUND + "  8 - User  " + Colors.RESET + " ";

  public static final String SHOW_ALL_MENU_CHART_CATEGORY = ""

      + Colors.GREEN_BRIGHT + "CHART BY:     " + Colors.WHITE_BOLD_BRIGHT + Colors.GREEN_BACKGROUND
      + "  6 - Date  " + Colors.RESET + " "
      + Colors.WHITE_BOLD_BRIGHT + Colors.BLUE_BACKGROUND + "  7 - Category  " + Colors.RESET + " "
      + Colors.WHITE_BOLD_BRIGHT + Colors.GREEN_BACKGROUND + "  8 - User  " + Colors.RESET + " ";

  public static final String SHOW_ALL_MENU_CHART_USER = ""

      + Colors.GREEN_BRIGHT + "CHART BY:     " + Colors.WHITE_BOLD_BRIGHT + Colors.GREEN_BACKGROUND
      + "  6 - Date  " + Colors.RESET + " "
      + Colors.WHITE_BOLD_BRIGHT + Colors.GREEN_BACKGROUND + "  7 - Category  " + Colors.RESET + " "
      + Colors.WHITE_BOLD_BRIGHT + Colors.BLUE_BACKGROUND + "  8 - User  " + Colors.RESET + " ";

  public static final String SHOW_SUB_MENU_CHART = ""
      + "\n"
      + Colors.WHITE_BACKGROUND + Colors.BLACK_BOLD + " r - Main menu  " + Colors.RESET + " ";

  /**
   * Main menu for all program
   *
   * @param records    List of Record with payments (can be sorted and filtered before)
   * @param categories List of Categories
   * @throws ParseException                Signals that an error has been reached unexpectedly while
   *                                       parsing.
   * @throws UnsupportedAudioFileException File format not valid
   * @throws IOException                   File input error
   * @throws LineUnavailableException      line cannot be opened because it is unavailable.
   * @throws AWTException                  Signals that an Abstract Window Toolkit exception has
   *                                       occurred.
   */


  public static void recordsMenu(List<Record> records, List<Category> categories)
      throws IOException, ParseException, AWTException, UnsupportedAudioFileException, LineUnavailableException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.print(Colors.GRAY + "Choose command: " + Colors.RESET);
      String key = br.readLine();
      switch (key) {
        case "1": {
          soundClick();
          Menu.printHeader();
          Menu.delaySecond();
          Output.printList(Operations.sortByID(records));
          Output.printFinance(records);
          System.out.println(SHOW_ALL_MENU_ID);
          System.out.println(SHOW_SYSTEM_MENU_MAIN);
          Menu.recordsMenu(records, categories);
          break;
        }
        case "2": {
          soundClick();
          Menu.printHeader();
          delaySecond();
          Output.printList(Operations.sortByUser(records));
          Output.printFinance(records);
          System.out.println(SHOW_ALL_MENU_USER);
          System.out.println(SHOW_ALL_MENU_MAIN);
          Menu.recordsMenu(records, categories);
          break;
        }
        case "3": {
          soundClick();
          Menu.printHeader();
          delaySecond();
          Output.printList(Operations.sortByCategory(records));
          Output.printFinance(records);

          System.out.println(SHOW_ALL_MENU_CATEGORY);
          System.out.println(SHOW_ALL_MENU_MAIN);
          Menu.recordsMenu(records, categories);
          break;
        }
        case "4": {
          soundClick();
          Menu.printHeader();
          delaySecond();
          Output.printList(Operations.sortByAmount(records));
          Output.printFinance(records);

          System.out.println(SHOW_ALL_MENU_AMOUNT);
          System.out.println(SHOW_SYSTEM_MENU);
          Menu.recordsMenu(records, categories);
          break;
        }
        case "5": {
          soundClick();
          Menu.printHeader();
          delaySecond();
          Output.printList(Operations.sortByDate(records));
          Output.printFinance(records);

          System.out.println(SHOW_ALL_MENU_AMOUNT);
          System.out.println(SHOW_SYSTEM_MENU);
          Menu.recordsMenu(records, categories);
          break;
        }
        case "6": {
          soundClick();
          Output.chartDate(records, Operations.getMinDate(records), Operations.getMaxDate(records));

          Output.printFinance(records);
          System.out.println(LEGEND);
          System.out.println(SHOW_ALL_MENU_CHART_DATE);
          System.out.println(SHOW_SUB_MENU_CHART);
          break;
        }
        case "7": {
          soundClick();
          Output.chartCategory(records, categories, Operations.getMinDate(records),
              Operations.getMaxDate(records));
          Output.printFinance(records);

          System.out.println(LEGEND);
          System.out.println(SHOW_ALL_MENU_CHART_CATEGORY);
          System.out.println(SHOW_SUB_MENU_CHART);
          break;
        }
        case "8": {
          soundClick();
          Output.chartUser(records, Users.userNames, Operations.getMinDate(records),
              Operations.getMaxDate(records));
          Output.printFinance(records);

          System.out.println(LEGEND);
          System.out.println(SHOW_ALL_MENU_CHART_USER);
          System.out.println(SHOW_SUB_MENU_CHART);
          break;

        }
        case "r": {
          soundClick();
          Menu.printHeader();
          Menu.delaySecond();
          Output.printList(records);
          Output.printFinance(records);
          System.out.println(Menu.SHOW_ALL_MENU_MAIN);
          System.out.println(SHOW_SYSTEM_MENU_MAIN);
          Menu.recordsMenu(records, categories);
          break;
        }
        case "q": {
          soundClick();
          System.exit(0);
          break;
        }


      }
    }
  }

  /**
   * make sound "mouse click"
   *
   * @throws UnsupportedAudioFileException File format not valid
   * @throws IOException                   File input error
   * @throws LineUnavailableException      line cannot be opened because it is unavailable.
   * @throws AWTException                  Signals that an Abstract Window Toolkit exception has
   *                                       occurred.
   */
  public static void soundClick()
      throws UnsupportedAudioFileException, IOException, LineUnavailableException, AWTException {
    File file = new File("src/classes/1.wav");
    AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
    Clip clip = AudioSystem.getClip();
    clip.open(audioStream);
    clip.start();
    clearAll();
    delaySecond();
  }

  public static void addRecord(List<Record> records, List<Category> categories)
      throws IOException, ParseException, UnsupportedAudioFileException, LineUnavailableException, AWTException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
    Record record = new Record();

    Calendar today = Calendar.getInstance();
    Date currentDate = today.getTime();
    Date stDate = currentDate;
    String categoryName = "Income";
    boolean income = false;
    int multiply = 1;
    int id = Record.getNewRecordId(records);


  }

  /**
   * Edit existing record, only fields: Income/Expenses; Comment; Amount; Category
   *
   * @param records    List of Record with payments (can be sorted and filtered before)
   * @param categories List of Categories
   * @throws IOException IO error
   */

  public static void editRecord(List<Record> records, List<Category> categories)
      throws IOException, UnsupportedAudioFileException, LineUnavailableException, AWTException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print(Colors.BLUE_BRIGHT + "Input ID of record:                       |   ");
    boolean income = false;
    double amount = -0;
    int multiply = 1;
    String comment = "";
    String categoryName = "";

    int id = Integer.parseInt(br.readLine());

    System.out.print("Do you want to change INCOME/EXPENSES? [y/n]  |   ");
    String input = br.readLine();
    if (input.equalsIgnoreCase("y")) {
      System.out.print(Colors.BLUE + "Is this income or expenses(i/e):     ");
      String incomeOrExpenses = br.readLine();
      if (incomeOrExpenses.equalsIgnoreCase("i")) {
        income = true;
      }
    }
    System.out.print("Do you want to change Comment? [y/n]     |   ");
    input = br.readLine();
    if (input.equalsIgnoreCase("y")) {
      System.out.print(Colors.WHITE_BRIGHT + "Input comment:     ");
      comment = br.readLine();
    }
    System.out.print(Colors.BLUE + "Do you want to change Category? [y/n] ");
    input = br.readLine();
    if (input.equalsIgnoreCase("y")) {
      for (int i = 0; i < categories.size(); i++) {
        System.out.println("" + i + "" + categories.get(i).getTitle());
      }
      System.out.print(Colors.WHITE_BRIGHT + "Choose category from list(0-9):    ");
      int cat = Integer.parseInt(br.readLine());
      categoryName = categories.get(cat).getTitle();
    }
    System.out.print("Do you want to change AMOUNT?[y/n]");
    input = br.readLine();
    if (input.equalsIgnoreCase("y")) {
      System.out.print("Input amount:     ");
      amount = Math.abs(Double.parseDouble(br.readLine()));
    }
    System.out.println();
    System.out.print(Colors.WHITE_BACKGROUND_BRIGHT + Colors.BLACK_BOLD + " s - SAVE" +
        Colors.RESET + " " + Colors.WHITE_BACKGROUND_BRIGHT +
        Colors.BLACK_BOLD + " r-RETURN: " + Colors.RESET);
    while (true) {
      String command = br.readLine();
      if (command.equalsIgnoreCase("r")) {
        soundClick();
        return;
      } else if (command.equalsIgnoreCase("s")) {
        soundClick();
      }
      for (Record record : records) {
        if (record.getId() == id) {
          if (categoryName.equals(record.getCategory())) {
            record.setCategory(categoryName);
          }
          if (!income) {
            multiply = -1;
          }
          amount *= multiply;
          if (amount != record.getAmount()) {
            record.setAmount(amount);
          }
          if (!comment.equals(record.getComment())) {
            record.setComment(comment);
          }
          IOCrypto.makeNewOutputCryptoFile(records, IOCrypto.list);
        }
      }
      return;


    }


  }
}
