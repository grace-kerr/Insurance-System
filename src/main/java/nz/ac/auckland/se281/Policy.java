package nz.ac.auckland.se281;

public abstract class Policy extends Object {

  private int sumToBeInsured;

  public enum PolicyType {
    HOME,
    CAR,
    LIFE
  }

  // protected PolicyType policyType;

  public Policy(int sumToBeInsured) {
    this.sumToBeInsured = sumToBeInsured;
    // this.policyType = PolicyType;
  }

  //   public Policy.PolicyType getType() {
  //     return this.policyType;
  //   }
}
