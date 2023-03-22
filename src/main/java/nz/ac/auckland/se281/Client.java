package nz.ac.auckland.se281;

public class Client {
  // instance fields
  private String userName;
  private String age;

  public Client(String userName, String age) {
    // constructor to initlise fields
    this.userName = userName;
    this.age = age;
  }

  public void printDetails() {
    System.out.println(userName + ", " + age);
  }
}
