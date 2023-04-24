package nz.ac.auckland.se281;

public class Life extends Policy {

  private int age;

  public Life(int sumToBeInsured, int age) {
    super(sumToBeInsured);
    this.age = age;
  }

  @Override
  public int getBasePremium() {
    double percentage = ((1 + (double) this.age / 100) / 100);
    return (int) (percentage * sumToBeInsured);
  }

  public String getBasePremiumString() {
    return String.valueOf(getBasePremium());
  }
}
