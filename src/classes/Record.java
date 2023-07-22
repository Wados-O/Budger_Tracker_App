package classes;

import java.util.Date;
import java.util.List;

public class Record {
  private int id;
  private Date date;
  private String category;
  private String user;
  private double amount;
  private String comment;
  public int getId(){
    return id;
  }
  public Date getDate(){
    return date;
  }

  public String getCategory() {
    return category;
  }

  public String getUser() {
    return user;
  }

  public double getAmount() {
    return amount;
  }

  public String getComment() {
    return comment;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Record() {
  }

  public Record(int id, Date date, String category, String user, double amount, String comment) {
    this.id = id;
    this.date = date;
    this.category = category;
    this.user = user;
    this.amount = amount;
    this.comment = comment;
  }

//  public static int getNewRecordId(List<Record> records){
//    int max = 1;
//    for (Record record : records){
//      if (record.getId() >= max){
//        max = record.getId() + 1;
//      }
//    }
//    return  max;
//  }
}
