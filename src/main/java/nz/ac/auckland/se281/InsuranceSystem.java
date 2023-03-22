package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

  private ArrayList<Client> clientList = new ArrayList<>();

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
  }

  public void printDatabase() {
    if (clientList.isEmpty()) {
      System.out.println("Database has 0 profiles.");
      return;
    } else if (clientList.size() == 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1", "", ":");
    } else {
      String sizeOfClientListAsAString = Integer.toString(clientList.size());
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(sizeOfClientListAsAString, "s", ":");
    }

    for (int i = 0; i < clientList.size(); i++) {
      Client someClientInstance = clientList.get(i);
      System.out.print(" " + (i + 1) + ": ");
      someClientInstance.printDetails();
    }
  }

  public void createNewProfile(String userName, String age) {
    // make sure username is 3 letters or more
    if (userName.length() < 3) {
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(userName);
      return;
    }

    // ensure that name is in title case
    String firstLetter = userName.substring(0, 1).toUpperCase();
    String allLettersButFirst = userName.substring(1).toLowerCase();
    userName = firstLetter + allLettersButFirst;
    // System.out.println(userName);

    // ensure that the inputted username is not a duplicate
    // if (userName)

    // age string to int
    int ageOfClient = Integer.parseInt(age);
    // System.out.println(ageOfClient);
    if (ageOfClient < 0) {
      MessageCli.INVALID_AGE.printMessage(age, userName);
      return;
    }

    // if (userList.contains(userName)) {}

    // add new instance of client, to the arrayList called clientList
    Client newClient = new Client(userName, age);
    // newClient.printDetails();
    clientList.add(newClient);
    // for (Client client : clientList) {
    //   System.out.println(client);
    //   System.out.println("print done");
    // }

    MessageCli.PROFILE_CREATED.printMessage(userName, age);
  }

  public void loadProfile(String userName) {
    // TODO: Complete this method.
  }

  public void unloadProfile() {
    // TODO: Complete this method.
  }

  public void deleteProfile(String userName) {
    // TODO: Complete this method.
  }

  public void createPolicy(PolicyType type, String[] options) {
    // TODO: Complete this method.
  }
}
