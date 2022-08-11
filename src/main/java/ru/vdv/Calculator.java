package ru.vdv;

import java.util.Scanner;

public class Calculator {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("--------------------------");
    while (true) {
      System.out.println("Select at item");
      System.out.println("1 Additional");
      System.out.println("2 Subtraction");
      System.out.println("3 Multiplication");
      System.out.println("4 Division");
      System.out.println("5 Exit");
      int person = scanner.nextInt();
      int result;
      if (person == 5) {
        break;
      } else if (person == 1) {
        System.out.println("Enter first number");
        int a = scanner.nextInt();
        System.out.println("Enter second number");
        int b = scanner.nextInt();
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        result = a + b;
        System.out.println("Answer : " + result);

      } else if (person == 2) {
        System.out.println("Enter first number");
        int a = scanner.nextInt();
        System.out.println("Enter second number");
        int b = scanner.nextInt();
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        result = a - b;
        System.out.println("Answer : " + result);

      } else if (person == 3) {
        System.out.println("Enter first number");
        int a = scanner.nextInt();
        System.out.println("Enter second number");
        int b = scanner.nextInt();
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        result = a * b;
        System.out.println("Answer : " + result);

      } else if (person == 4) {
        System.out.println("Enter first number");
        int a = scanner.nextInt();
        System.out.println("Enter second number");
        int b = scanner.nextInt();
        if (b == 0) {
          System.out.println("This is ArithmeticException");
        }
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        result = a / b;
        System.out.println("Answer : " + result);

      } else {
        System.out.println("Error");
      }
    }
    System.out.println("The program is finished");
  }
}
