package nz.ac.auckland.se281;

public class Life extends Policy {

  public Life(int sumToBeInsured) {
    super(sumToBeInsured);
  }

  public int getBasePremium(int age) {
    return ((1 + age / 100) * sumToBeInsured);
  }
}
