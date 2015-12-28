Let's look at how a programmer might write methods to handle subparts of some larger task.

```java
import java.util.Scanner

public class Prime2{
  public static Scanner keyboard = new Scanner(System.in);

  public static void main (String[] args) {

    int p = getNumber();

    boolean isPrime = primetest(p);
    if (isPrime)
      System.out.println("It's prime")
    else
      System.out.println("It's composite");
  } //main

  ////////getNumber/////////////////
  // This method gets a number > 1 from the user
  //////////////////////////////////

  private static int getNumber() {
    System.out.print("Enter an integer greater than one: ")
    int p = keyboard.nextInt();

    while (p<2) {
      System.out.println ("That integer isn't greater than one fool.");
      System.out.print("Try again");
      p = keyboard.nextInt();
    }
    return p;
  } // getNumber method finished

  //////////////prime test/////////////
  // This method tests whether the given integer is false
  // It assumes that the parameter is greater than one
  //////////////////////////////////////

  private static boolean primetest (int a) {
    int limit = (int) Math.sqrt(a);
    // this limit seems smart. The divisor, if there is one, has to be smaller than the sqrt of the number

    for (int i=2; i<limit; ++i) {
      if (a % i == 0) return false;
    } // no factors were found
    return true;
  } //primetest ends
} // class ends

```
The main method of this program is fairly simple. It invokes two new methods, getNumber and primetest. The purpose of getNumber is to read an integer greater than one from the keyboard, and the purpose of primetest is to test the number
for primality.

In this program, code for the two new methods is placed in the same class as
the main method. The new methods are used by the main method, but they are not contained in the main method.
Notice that each of the three methods is indented by the same amount, and the closing brace of each method appears before the header line of the next method.

Here’s what happens when the program runs. Method main begins by calling getNumber. The execution of main is suspended until getNumber completes its work. Method getNumber asks the user to enter an integer and saves the value in a local variable called p. After verifying that the number is greater than one, getNumber returns the value to the calling method. Method main then stores the value in its own variable p.

The main method now invokes method primetest, passing the value in p as an argument. Within primetest, this value is available as a parameter called a. After using a loop to test possible factors of a, primetest returns a boolean value indicating whether a was prime. Method main stores this value in a variable and then uses it to print a message that tells whether the user’s number was prime.

Notice the usage of limit in primetest. You only need to test up to the square root of the number in order to determine if the number is prime or not. I used to think it was half the number, but the square root is actually a smaller (therefore faster) way to test the primeness of a number.


#### Local variables, parameters, and return values

Each method has a set of variables that are completely separate from the variables used in other methods. For example, main has two variables (p and isPrime), getNumber has one variable (also called p), and primetest has three variables (a, limit, and i). The variables of each method are local to that method and cannot be used in the others.

A method receives information from the rest of the program via parameters, and it returns information via a return value. 
