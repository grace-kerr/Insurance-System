package nz.ac.auckland.se281;

public class Car extends Policy {

  private String makeAndModel;
  private String licensePlate;
  private boolean hadMechanicalBreakdown;

  public Car(
      int sumToBeInsured,
      String makeAndModel,
      String licensePlate,
      boolean hadMechanicalBreakdown) {
    super(sumToBeInsured);
    this.makeAndModel = makeAndModel;
    this.licensePlate = licensePlate;
    this.hadMechanicalBreakdown = hadMechanicalBreakdown;
  }
}
