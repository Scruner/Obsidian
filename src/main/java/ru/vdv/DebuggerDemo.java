package ru.vdv;

import java.util.Scanner;

public class DebuggerDemo {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    while (true) {
      Integer multiplication = multiply();
      if (multiplication >= 100) {
        System.out.println("Multiplication >= 100");
      } else {
        System.out.println("Multiplication less than 100");
      }
    }
  }

  private static Integer multiply() {
    System.out.println("Enter first number: ");
    var firstNumber = scanner.nextInt();
    System.out.println("Enter second number: ");
    var secondNumber = scanner.nextInt();
    return firstNumber * secondNumber;
  }
}
