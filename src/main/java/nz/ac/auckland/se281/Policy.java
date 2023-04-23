package nz.ac.auckland.se281;

public abstract class Policy extends Object {

  protected int sumToBeInsured;
  private int basePremium;

  public enum PolicyType {
    HOME,
    CAR,
    LIFE
  }

  // protected PolicyType policyType;

  public Policy(int sumToBeInsured) {
    this.sumToBeInsured = sumToBeInsured;
    //this.policyType = PolicyType;
  }

  public int getSumToBeInsured() {
    return this.sumToBeInsured;
  }

  public String getSumToBeInsuredString() {
    return String.valueOf(this.sumToBeInsured);
  }

  // public Policy.PolicyType getType() {
  //   return this.policyType;
  // }
}
