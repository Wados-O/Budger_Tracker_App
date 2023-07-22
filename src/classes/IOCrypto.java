package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
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
  /**
   * Methods decrypt file, parse it and add records to ListRecord.
   * Use methods parseRecordFromString().
   * <p>
   * Check empty file.
   *
   * @param cryptoFile - File for decrypts.
   * @throws IOException throw.
   */
  public static void makeUnCrypt(File cryptoFile ,List<Record> records)
      throws IOException, ParseException{
    if (cryptoFile.length() ==0){
      System.out.println("Empty file");
    }else {
      try{
        BufferedReader inputFileReader = new BufferedReader(new FileReader(cryptoFile));
        for (String row = inputFileReader.readLine(); row!=null;row =inputFileReader.readLine()){
          StringBuilder tempString = new StringBuilder();
          for (int i = 0; i < row.length(); i++) {
            int code =(int) row.charAt(i) -CRYPTO;
            tempString.append((char) code);
          }
          parseRecordFromString();
        }
      }
    }
  }



  /**
   * Parse and add record from String to List Record.
   *
   * @param line    String from file.
   * @param records records for adding.
   * @throws ParseException can throw.
   */
  public static void parseRecordFromString(String line,List<Record> records)throws ParseException{
    String[] temp = line.split(SEP);
    Record record = new Record();
    record.setId(Integer.parseInt(temp[0]));
    record.setDate(Operations.stringToDate(temp[1]));
    record.setUser(temp[2]);
    record.setAmount(Double.parseDouble(temp[3]));
    record.setCategory(temp[4]);
    record.setComment(temp[5]);
    records.add(record);
  }


  public static String recordsToCryptoString(Record record) {

  }

}
