package nz.ac.auckland.se281;

public abstract class Policy extends Object {

  protected int sumToBeInsured;
  protected int basePremium;

  public enum PolicyType {
    HOME,
    CAR,
    LIFE
  }

  public Policy(int sumToBeInsured) {
    this.sumToBeInsured = sumToBeInsured;
  }

  public int getSumToBeInsured() {
    return this.sumToBeInsured;
  }

  public String getSumToBeInsuredString() {
    return String.valueOf(this.sumToBeInsured);
  }

  public abstract int getBasePremium();
}
