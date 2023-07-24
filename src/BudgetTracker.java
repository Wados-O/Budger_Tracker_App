import classes.Category;
import classes.IOCrypto;
import classes.Intro;
import classes.Menu;
import classes.Output;
import classes.Record;
import classes.Users;
import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class BudgetTracker {

  public static List<Record> records = new ArrayList<>();
  //public static List<Category> categories = new ArrayList<>();
  public static List<Category> categories = Category.createCategories();

  public static void main(String[] args)
      throws IOException, ParseException, AWTException, UnsupportedAudioFileException, LineUnavailableException {
//    File budgetFile = new File("src/res/budget.txt"); //***===DO NOT DELETE===***
//    IOCrypto.parseFileUnencrypted(budgetFile,records); //***===DO NOT DELETE===***
    File loginFile = new File("src/rec/login,txt");
    File crypto = new File("src/rec/crypto.txt");

    intro();

    System.out.println();
    Users.showLogin(loginFile);
    Menu.clearAll();

    IOCrypto.makeUnCrypt(crypto, records);
    IOCrypto.makeNewOutputCryptoFile(records, IOCrypto.list);

    System.out.println();
    Menu.delaySecond();
    Menu.printHeader();
    Menu.delaySecond();
    Output.printList(records);
    Output.printFinance(records);
    System.out.println(Menu.SHOW_ALL_MENU_MAIN);
    System.out.println(Menu.SHOW_SYSTEM_MENU_MAIN);
    Menu.recordsMenu(records, categories);

  }

  public static void intro()
      throws UnsupportedAudioFileException, IOException, LineUnavailableException, AWTException {
    File file = new File("src/classes/11.wav");
    AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
    Clip clip = AudioSystem.getClip();
    clip.open(audioStream);
    clip.start();
    Intro.circle_1();
    clip.close();
    Menu.delaySecond();
  }
}