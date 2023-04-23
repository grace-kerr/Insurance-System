package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

  private ArrayList<Client> clientList = new ArrayList<>();
  private boolean isProfileLoaded;
  private Client loadedClient;

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
    this.isProfileLoaded = false;
    this.loadedClient = null;
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
      String position = Integer.toString(i + 1);
      // if the client is loaded, indicate that it is loaded
      if (loadedClient == someClientInstance) {
        MessageCli.PRINT_DB_PROFILE_HEADER_SHORT.printMessage(
            "*** ", position, someClientInstance.getUserName(), someClientInstance.getAge());
      } else {
        MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(
            position, someClientInstance.getUserName(), someClientInstance.getAge());
      }
    }
  }

  public void createNewProfile(String userName, String age) {
    // make sure there is no client loaded
    if (isProfileLoaded) {
      MessageCli.CANNOT_CREATE_WHILE_LOADED.printMessage(loadedClient.getUserName());
      return;
    }

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
    String firstLetter = userName.substring(0, 1).toUpperCase();
    String allLettersButFirst = userName.substring(1).toLowerCase();
    userName = firstLetter + allLettersButFirst;

    // if the username is in the database, load the profile
    for (int i = 0; i < clientList.size(); i++) {
      Client tempClient = clientList.get(i);
      String tempClientName = tempClient.getUserName();
      if (tempClientName.contentEquals(userName)) {
        loadedClient = tempClient;
        isProfileLoaded = true;
        MessageCli.PROFILE_LOADED.printMessage(userName);
        return;
      }
    }

    // if the username is not found in the database
    MessageCli.NO_PROFILE_FOUND_TO_LOAD.printMessage(userName);
  }

  public void unloadProfile() {
    // check if a profile is loaded, otherwise return error message
    if (!isProfileLoaded) {
      MessageCli.NO_PROFILE_LOADED.printMessage();
      return;
    }

    // unload the profile
    MessageCli.PROFILE_UNLOADED.printMessage(loadedClient.getUserName());
    isProfileLoaded = false;
    loadedClient = null;
  }

  public void deleteProfile(String userName) {
    String firstLetter = userName.substring(0, 1).toUpperCase();
    String allLettersButFirst = userName.substring(1).toLowerCase();
    userName = firstLetter + allLettersButFirst;

    // itierate through the clientList, and remove the client with the matching username
    for (int i = 0; i < clientList.size(); i++) {
      Client tempClient = clientList.get(i);
      String tempClientName = tempClient.getUserName();
      if (tempClientName.contentEquals(userName)) {
        // check if a profile is loaded, otherwise return error message
        if (isProfileLoaded) {
          if (tempClientName.contentEquals(loadedClient.getUserName())) {
            MessageCli.CANNOT_DELETE_PROFILE_WHILE_LOADED.printMessage(userName);
            return;
          }
        }

        clientList.remove(i);
        MessageCli.PROFILE_DELETED.printMessage(userName);
        return;
      }
    }

    // if the username is not found in the database
    MessageCli.NO_PROFILE_FOUND_TO_DELETE.printMessage(userName);
  }

  public void createPolicy(PolicyType type, String[] options) {
    // if no profile is loaded, return error message
    if (!isProfileLoaded) {
      MessageCli.NO_PROFILE_FOUND_TO_CREATE_POLICY.printMessage();
      return;
    }

    // change the first element of the options into an integer
    int sumToBeInsured = Integer.parseInt(options[0]);

    Policy newPolicy = null;
    switch (type) {
      case HOME:
        // change the string into boolean for the third element of the options
        boolean isHomeRental = false;
        if (options[2].toLowerCase().startsWith("y")) {
          isHomeRental = true;
        } else if (options[2].toLowerCase().startsWith("n")) {
          isHomeRental = false;
        }
        newPolicy = new Home(sumToBeInsured, options[1], isHomeRental);
        break;
      case CAR:
        // change the string into boolean for the third element of the options
        boolean hadMechanicalBreakdown = false;
        if (options[2].toLowerCase().startsWith("y")) {
          hadMechanicalBreakdown = true;
        } else if (options[2].toLowerCase().startsWith("n")) {
          hadMechanicalBreakdown = false;
        }
        newPolicy = new Car(sumToBeInsured, options[1], options[2], hadMechanicalBreakdown);
        break;
      case LIFE:
        newPolicy = new Life(sumToBeInsured);
        break;
    }

    loadedClient.addPolicy(newPolicy);

    MessageCli.NEW_POLICY_CREATED.printMessage(
        type.name().toLowerCase(), loadedClient.getUserName());
  }
}
