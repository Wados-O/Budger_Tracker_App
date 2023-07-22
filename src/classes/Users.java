package classes;

import java.util.ArrayList;
import java.util.List;

public class Users {

  private static String userName;
  public static List<String> userNames = new ArrayList<>();
  private String name;
  private boolean child;

  public static void setUserName(String userName) {
    Users.userName = userName;
  }

  public static String getUserName() {
    return userName;
  }

  public Users() {

  }
  /**
   * Methods read login and password from file, check it
   *
   * @param usersFile file with password and login
   * @throws IOException can throw
   */
}
