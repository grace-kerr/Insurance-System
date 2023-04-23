package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Client {
  // instance fields
  private String userName;
  private String age;
  private ArrayList<Policy> policies = new ArrayList<>();

  public Client(String userName, String age) {
    // constructor to initlise fields
    this.userName = userName;
    this.age = age;
  }

  public void printDetails() {
    System.out.println(userName + ", " + age);
  }

  public String getUserName() {
    return this.userName;
  }

  public String getAge() {
    return this.age;
  }

  public int getAgeInteger() {
    int age = Integer.parseInt(this.age);
    return age;
  }

  public void addPolicy(Policy newPolicy) {
    this.policies.add(newPolicy);
  }

  public String getNumberOfPolicies() {
    return String.valueOf(policies.size());
  }

  public int getNumberOfPoliciesInteger() {
    return policies.size();
  }

  public Policy getPolicy(int index) {
    return policies.get(index);
  }

  public int getPolicyDiscountedPremium(int basePremium) {
    // calculate discountes if client has more than 1 policy
    int policyDiscountedPremium;
    if (getNumberOfPoliciesInteger() == 2) {
      policyDiscountedPremium = (int) (basePremium * 0.9);
    } else if (getNumberOfPoliciesInteger() > 2) {
      policyDiscountedPremium = (int) (basePremium * 0.8);
    } else {
      policyDiscountedPremium = basePremium;
    }
    return policyDiscountedPremium;
  }

  public String getPolicyDiscountedPremiumString(int basePremium) {
    return String.valueOf(getPolicyDiscountedPremium(basePremium));
  }

  // public int getTotalPolicyDiscountedPremium(int bas) {
  //   int totalPolicyDiscountedPremium = 0;
  //   for (int i = 0; i < policies.size(); i++) {
  //     totalPolicyDiscountedPremium += policies.get(i).getDiscountedPremium();
  //   }
  //   return totalPolicyDiscountedPremium;
  // }

}
