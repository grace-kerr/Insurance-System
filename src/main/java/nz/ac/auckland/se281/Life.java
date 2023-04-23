package nz.ac.auckland.se281;

public class Life extends Policy {

  public Life(int sumToBeInsured) {
    super(sumToBeInsured);
  }

  public int getBasePremium(int age) {
    double percentage = ((1 + (double) age / 100) / 100);
    return (int) (percentage * sumToBeInsured);
  }

  public String getBasePremiumString(int age) {
    return String.valueOf(getBasePremium(age));
  }
}
