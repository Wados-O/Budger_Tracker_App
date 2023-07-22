package classes;

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

  public static void recordsMAnu(List<Record> records, List<Category> categories)
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

  public static void addRecord(List<Record> records,List<Category> categories)
      throws IOException,ParseException,UnsupportedAudioFileException,LineUnavailableException,AWTException{
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
}
