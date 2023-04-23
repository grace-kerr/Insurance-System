package nz.ac.auckland.se281;

public class Home extends Policy {

  private String address;
  private boolean isHomeRental;

  public Home(int sumToBeInsured, String address, boolean isHomeRental) {
    super(sumToBeInsured);
    this.address = address;
    this.isHomeRental = isHomeRental;
  }

  public int getBasePremium() {
    if (isHomeRental) {
      return (int) (sumToBeInsured * 0.02);
    } else {
      return (int) (sumToBeInsured * 0.01);
    }
  }

  public String getBasePremiumString() {
    return String.valueOf(getBasePremium());
  }

  public String getAddress() {
    return address;
  }
}
