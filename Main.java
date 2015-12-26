/*
the first line defines a class called Main

public means every other class can access it.

static means you can run this method without creating an instance of Main.

void means that this method doesn't return any value.

main (lowercase) is the name of the method. The main method is special in Java,
because it is the method the Java runtime will attempt to call when you tell it to execute your program.
Think of main as the starting point for my program.

System is a predefined class that Java provides us and it holds some useful methods and variables

out is a static variable within System that represents the output  of your program (stdout)

println is a method of out that can be used to print a line.

To compile this file into java byte code, run javac Main.java in terminal.
Then, run java Main in terminal to execute the bytecode file java.class

*/

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello, World!");
  }
}
