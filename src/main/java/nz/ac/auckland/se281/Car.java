package nz.ac.auckland.se281;

public class Car extends Policy {

  private String makeAndModel;
  private boolean coverForMechanicalBreakdown;
  private int age;

  public Car(
      int sumToBeInsured, String makeAndModel, boolean coverForMechanicalBreakdown, int age) {
    super(sumToBeInsured);
    this.makeAndModel = makeAndModel;
    this.coverForMechanicalBreakdown = coverForMechanicalBreakdown;
    this.age = age;
  }

  @Override
  public int getBasePremium() {
    int basePremium;
    // change the percentage based on the age of the client
    if (this.age < 25) {
      basePremium = (int) (sumToBeInsured * 0.15);
    } else {
      basePremium = (int) (sumToBeInsured * 0.1);
    }

    // increase the base premium if client wants extra breakdown coverage
    if (this.coverForMechanicalBreakdown) {
      basePremium = basePremium + 80;
    }

    return basePremium;
  }

  public String getBasePremiumString() {
    return String.valueOf(getBasePremium());
  }

  public String getMakeAndModel() {
    return this.makeAndModel;
  }
}
