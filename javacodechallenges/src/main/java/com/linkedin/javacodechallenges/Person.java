package com.linkedin.javacodechallenges;

public class Person {
  private String firstName;
  private String lastName;
  private int age;

  public Person(String firstName, String lastName, int age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String name) {
    firstName = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String name) {
    lastName = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    if (age < this.age) {
      throw new IllegalArgumentException(String.format(
          "Can not make it younger. Current age: %d. Provided age: %d ", this.age, age));
    }
    this.age = age;
  }

  public void introduceYourself() {
    System.out.println(
        "Hello my name is " + getFirstName() + " " + getLastName() +
            ". I am " + getAge());
  }

}