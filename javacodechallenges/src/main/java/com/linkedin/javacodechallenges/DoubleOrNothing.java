package com.linkedin.javacodechallenges;

import java.util.Random;
import java.util.Scanner;

public class DoubleOrNothing {
  private int startPoint = 10;
  private Scanner in = new Scanner(System.in);
  private Random dice = new Random();
  private int current = startPoint;
  private boolean isStillPlaying = true;

  public void playGame() {
    printWelcome();
    askUserToContinue();

    while (this.isStillPlaying) {
      printTryToDouble();

      if (isGettingDouble()) {
        doublePoint();
        congrats();
        askUserToContinue();
      } else {
        printLost();
        return;
      }
    }

    printGoodbye();

  }

  private void printLost() {
    System.out.println("Oh no. You've lost. No points for you!");
  }

  private void congrats() {
    System.out.println("Congrats now you have " + this.current + " points.");
  }

  private void printTryToDouble() {
    System.out.println("Let's try to double it!");
  }

  protected void askUserToContinue() {
    System.out.println("Would you like to continue with your luck? [Y/N] ");
    this.isStillPlaying = this.in.nextLine().toUpperCase().equals("Y");
  }

  private void doublePoint() {
    this.current = this.current * 2;
  }

  private boolean isGettingDouble() {
    return this.dice.nextInt(2) == 0;
  }

  private void printWelcome() {
    System.out.println("Let's play Double or Nothing. Your starting point: " + this.startPoint);
  }

  private void printGoodbye() {
    System.out.println("Congrats you finish with " + this.startPoint + " points");
  }

  public boolean getIsPlaying() {
    return isStillPlaying;
  }

}