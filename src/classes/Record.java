package classes;

import java.util.Date;
import java.util.List;

public class Record {
  private int id;
  private Date date;
  private String category;
  private String user; // must decide, may be use class Users
  private double amount;
  private String comment;

  public int getId() {
    return id;
  }

  public Date getDate() {
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

  public Record(int id) {
    this.id = id;
  }

  public Record(int id, Date date, String user, String category, String comment, double amount) {
    this.id = id;
    this.date = date;
    this.user = user;
    this.category = category;
    this.comment = comment;
    this.amount = amount;
  }

  /**
   * Calculate new ID in List of records
   *
   * @param records List of records
   * @return new ID
   */
  public static int getNewRecordId(List<Record> records) {
    int max = 1;
    for (Record record : records) {
      if (record.getId() >= max) {
        max = record.getId() + 1;
      }
    }
    return max;
  }

  /**
   * Override method to String
   * @return string
   */
  @Override
  public String toString() {
    return "Record{" +
        "id=" + id +
        ", date=" + Operations.dateToString(date) +
        ", category='" + category + '\'' +
        ", user='" + user + '\'' +
        ", amount=" + amount +
        ", comment='" + comment + '\'' +
        '}';
  }
}