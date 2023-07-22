package classes;

import java.util.ArrayList;
import java.util.List;

public class IOCrypto {

  final static int CRYPTO = -211;
  final public static String SEP = ",";
  public static List<String> list = new ArrayList<>();

  /**
   * Overwrites List of Records character-by-character by changing number ASCII -> (code)+CRYPTO
   *
   * @param records ListRecord for crypt.
   */
  public static void makeCrypto(List<Record> records) {
    list.clear();
    StringBuilder tempString = new StringBuilder();
    int j = 0;
    for (Record items : records) {
      String line = recordsToCryptoString(items);
      for (int i = 0; i < line.length(); i++) {
        int code = (int) line.charAt(i) + CRYPTO;
        tempString.append((char) code);
      }
      list.add(j, tempString.toString());
      tempString = new StringBuilder();
      j++;
    }
  }

  public static String recordsToCryptoString(Record record) {

  }

}
