package com.linkedin.javacodechallenges;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {
  private final ByteArrayOutputStream printOut = new ByteArrayOutputStream(0);

  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(printOut));
  }

  @After
  public void restoreStreams() {
    System.setOut(System.out);
  }

  @Test
  public void getPersonAttributes() {
    Person p = new Person("Cristiano", "Messi", 37);

    assertEquals("Cristiano", p.getFirstName());
    p.setFirstName("Lionel");
    assertEquals("Lionel", p.getFirstName());

    assertEquals("Messi", p.getLastName());
    p.setLastName("Ronaldo");
    assertEquals("Ronaldo", p.getLastName());

    assertEquals(37, p.getAge());
    p.setAge(39);
    assertEquals(39, p.getAge());
  }

  @Test(expected = IllegalArgumentException.class)
  public void setPersonAgeYoungerShouldThrowError() {
    Person p = new Person("Luca", "Benzema", 31);
    p.setAge(30);
  }

  @Test
  public void introduceYourselfTest() {
    Person p = new Person("Donald", "Mouse", 6);
    p.introduceYourself();
    assertEquals("Hello my name is Donald Mouse. I am 6\n", printOut.toString());
  }

}
