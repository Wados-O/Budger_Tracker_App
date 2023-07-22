package classes;

public class Category {

  private int id;
  private String title;
  private boolean allowed;

  public Category() {
  }

  public Category(int id, String title, boolean allowed) {
    this.id = id;
    this.title = title;
    this.allowed = allowed;
  }
}
