package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

  private ArrayList<Client> clientList = new ArrayList<>();

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
  }

  public void printDatabase() {
    // print out number of clients in database and return to the main menu if the database is empty
    if (clientList.isEmpty()) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");
      return;
    } else if (clientList.size() == 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1", "", ":");
    } else {
      String sizeOfClientListAsAString = Integer.toString(clientList.size());
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(sizeOfClientListAsAString, "s", ":");
    }

    // print out the details of each client
    for (int i = 0; i < clientList.size(); i++) {
      Client someClientInstance = clientList.get(i);
      // System.out.print(" " + (i + 1) + ": ");
      // someClientInstance.printDetails();
      String position = Integer.toString(i + 1);
      MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(
          position, someClientInstance.getUserName(), someClientInstance.getAge());
    }
  }

  public void createNewProfile(String userName, String age) {
    // ensure that name inputted is in title case
    String firstLetter = userName.substring(0, 1).toUpperCase();
    String allLettersButFirst = userName.substring(1).toLowerCase();
    userName = firstLetter + allLettersButFirst;

    // make sure username is 3 letters or more
    if (userName.length() < 3) {
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(userName);
      return;
    }

    // ensure that the inputted username is not a duplicate
    for (int i = 0; i < clientList.size(); i++) {
      Client tempClient = clientList.get(i);
      String tempClientName = tempClient.getUserName();
      if (tempClientName.contentEquals(userName)) {
        MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(userName);
        return;
      }
    }

    // check the age inputted is an integer
    try {
      int ageTest = Integer.parseInt(age);
    } catch (Exception e) {
      MessageCli.INVALID_AGE.printMessage(age, userName);
      return;
    }

    // check that the age inputted is positive
    int ageAsInteger = Integer.parseInt(age);
    if (ageAsInteger < 0) {
      MessageCli.INVALID_AGE.printMessage(age, userName);
      return;
    }

    // add new instance of client, to the arrayList called clientList
    Client newClient = new Client(userName, age);
    clientList.add(newClient);

    // give confirmation message to interface user
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
