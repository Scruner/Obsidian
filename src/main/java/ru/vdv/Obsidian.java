package ru.vdv;

public class Obsidian {

  public Object obj;

  public static void main(String[] args)
      throws ClassNotFoundException, NoSuchFieldException {

    // returns the Class object for this class
    Class myClass = Class.forName("Obsidian");

    System.out.println("Class represented by myClass: "
                           + myClass.toString());

    String fieldName = "obj";

    // Get the field of myClass
    // using getField() method
    System.out.println(
        fieldName + " Field of myClass: "
            + myClass.getField(fieldName));
  }
}

//Output:
//Element by thread main is added
//Element by thread main is added
//Element by thread main is added
//Elements by thread main is printed
//Printing the last element : Hello
