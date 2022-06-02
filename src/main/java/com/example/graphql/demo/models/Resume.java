package com.example.graphql.demo.models;

public class Resume {

  public Resume() {}
  public Resume(Integer id, String lastExperience, String currency, Integer amount) {
    this.id = id;
    this.lastExperience = lastExperience;
    Salary salary = new Salary();
    salary.setCurrency(currency);
    salary.setAmount(amount);
    this.salary = salary;
  }

  private Integer id;
  private String lastExperience;
  private Salary salary;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getLastExperience() {
    return lastExperience;
  }

  public void setLastExperience(String lastExperience) {
    this.lastExperience = lastExperience;
  }

  public Salary getSalary() {
    return salary;
  }

  public void setSalary(Salary salary) {
    this.salary = salary;
  }
}
