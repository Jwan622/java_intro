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

The names and types of the parameters and the return type of the method are all found in the header line of the method.
Let's look at this header line:

```java
private static boolean primetest (int a)
```

tells us that primetest takes a single int parameter and returns a boolean value. The keyword **private** specifies that this method can only be called by other methods in the same class.

Your main method must always be public; other methods should be private unless there is a reason to make them public.

To return a value, a method must use a return statement. The general form of a return statement is:
```
return expression ;
```

**The type of the expression must match the type of the method. The statement return p; works in method getNumber because an integer return value is expected. The statements return true; and return false; work in primetest because a boolean return value is expected. Unless a method has return type void, it must end with an appropriate return statement.**

It can also have return statements in other places. For example, primetest contains the statement return false; in the middle of the loop. If an early return statement of this kind is reached, the method ends immediately and the appropriate return value is passed back to the calling method.

If a method has type void, it has no return value, and no return statement is needed at the end.

Here’s an example of a void method:
```java
private static void sayHi (boolean dontBother) {
  if (dontBother) return;
    System.out.println ("Hi there!");
}
```

While this example is silly, it illustrates several ideas. First, there is no return at the end. If dontBother is false, the message is printed and execution “falls out the bottom” of the method. The method terminates, and the calling method resumes. On the other hand, if dontBother is true, the return statement, without return value, is executed and the method terminates immediately.


#### Why write methods?

Methods are useful for a number of reasons. One important reason is that you can write a method one time but use it at many places in a program. For example, you might need to test the primality of an integer i at one place in a program and the primality of j somewhere else. If you create method primetest, you can simply call primetest(i) and primetest(j) at the appropriate places.


This is an interesting point about how even one-off methods (only used once) can be useful.

  "Even if you are only going to do some subtask one time, it often makes sense to create a method. The fact that each method has its own set of variables is crucial. In developing method primetest, the programmer doesn’t need to worry about where the method is used or what variables the calling method has. He or she can simply concentrate on the fact that the number to be tested arrives in an int variable called a and that a boolean needs to be returned. New variables can be declared and used without interfering with the rest of the program. This greatly simplifies the task of programming."

-Essentially, with one-offs, you can just focused on what's coming in and what's coming out and new variables can be declared inside the method without it infecting or polluting the parent method or the calling method.


#### Some more parameter passing
Here's a more complex combination of method calls:

```java
public class Fun {
  // this is a class to show how return values and parameters are used

  public static void main (String[] args) {
    int i=5;
    b();
    System.out.println("The answer is " + a(a(i, 3.4), 3.0));
  }

  ///////////////method a//////////////
  private static int a (int i, doublej) {
    System.out.println("First parameter is " +i);
    i++;
    if (c(j)) b();
    return i;
  }

  ////////////////////// method b/////////////////////////
  private static void b() {
    for (int i=0; i<5; ++i)
      System.out.println("Hi " + i);
  }

  ///////////////// method c /////////////////////////////
  private static boolean c (double i) {
    int j = (int) i;
    if (i == j) return true;
    else return false;
  }
}
```

I think the key takeaways here are that the i++ inside method a is not affected by what goes on inside c and b which have their own local variables i.
