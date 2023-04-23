package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Client {
  // instance fields
  private String userName;
  private String age;
  private ArrayList<Policy> policies = new ArrayList<>();

  public Client(String userName, String age) {
    // constructor to initlise fields
    this.userName = userName;
    this.age = age;
  }

  public void printDetails() {
    System.out.println(userName + ", " + age);
  }

  public String getUserName() {
    return this.userName;
  }

  public String getAge() {
    return this.age;
  }

  public void addPolicy(Policy newPolicy) {
    this.policies.add(newPolicy);
  }

  public String getNumberOfPolicies() {
    return String.valueOf(policies.size());
  }
}
