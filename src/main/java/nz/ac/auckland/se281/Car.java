package nz.ac.auckland.se281;

public class Car extends Policy {

  private String makeAndModel;
  private String licensePlate;
  private boolean coverForMechanicalBreakdown;

  public Car(
      int sumToBeInsured,
      String makeAndModel,
      String licensePlate,
      boolean coverForMechanicalBreakdown) {
    super(sumToBeInsured);
    this.makeAndModel = makeAndModel;
    this.licensePlate = licensePlate;
    this.coverForMechanicalBreakdown = coverForMechanicalBreakdown;
  }

  public int getBasePremium(int age) {
    int basePremium;
    if (age < 25) {
      basePremium = (int) (sumToBeInsured * 0.15);
    } else {
      basePremium = (int) (sumToBeInsured * 0.1);
    }

    if (this.coverForMechanicalBreakdown) {
      basePremium = basePremium + 80;
    }

    return basePremium;
  }

  public String getBasePremiumString(int age) {
    return String.valueOf(getBasePremium(age));
  }

  public String getMakeAndModel() {
    return this.makeAndModel;
  }

  // public String getLicensePlate() {
  //   return this.licensePlate;
  // }

}
