package nz.ac.auckland.se281;

public class Home extends Policy {

  private String address;
  private boolean isHomeRental;

  public Home(int sumToBeInsured, String address, boolean isHomeRental) {
    super(sumToBeInsured);
    this.address = address;
    this.isHomeRental = isHomeRental;
  }
}
