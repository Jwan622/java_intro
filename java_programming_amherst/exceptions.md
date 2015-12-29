## Exceptions in Java

We’ve encountered several di↵erent kinds of exceptions so far, including:
- ArithmeticException: this occurs if you do integer division by zero
- ArrayIndexOutOfBoundsException: this occurs if you index beyond the bounds of an array
- java.util.InputMismatchException: this occurs if you do a keyboard.nextInt() and the user types something other than an int.


These are all variants of a **RuntimeException**, which is itself a variant of an Exception.


#### Catching an Exception

Here’s an example of how you could “take control” of an exception:

```java
int i;
  try {
      i = keyboard.nextInt();
      System.out.println ("The nextInt() was successful");
  }
  catch (java.util.InputMismatchException e) {
      System.out.println ("It’s an exception!");
  }
```

This illustrates a try-catch statement in which a try block is associated with one or more catch blocks. We’ll talk about how multiple catch blocks work in a bit. In the simple situation given here, we try to do the code in the try block. If an **InputMismatchException** ever occurs, control immediately jumps to the catch block, i.e. it won’t reach the “successful” message. The variable e refers to an object that has further information about the exception; we won’t worry about it here.

Check this out. Here's a better example of exception handling:

```java
public static int getMonth() {
  while (true) {
    try {
      System.out.print ("Enter a month [1-12]: ");
      int m = keyboard.nextInt();
      if (m >= 1 && m <= 12)
        return m;
      System.out.println("Bad Answer try again.")
    }
    catch (java.util.InputMismatchException e) {
      System.out.println("Bad Answer... try again.");
      keyboard.nextLine();   // to clear the rest of the line
    }
  }
}
```
This code will gracefully handle any non-numeric inputs from the user. Note that the “true” condition on the while loop means that the loop will continue forever, or at least until the return is made within the try block.



A try block can have multiple catches. Consider this example:
```java
try { . . .
    }
    catch (java.util.InputMismatchException e) {
. . .
    }
    catch (ArithmeticException e) {
. . .
    }
    catch (RuntimeException e) {
. . .
}
```

If an exception occurs within the try, the first applicable catch is used. Suppose it’s
an InputMismatchException. Recall that a InputMismatchException is a variant
of a RuntimeException. Either catch could be used; the InputMismatchException one is first so it is used. If the three catches were reordered so that the RuntimeException case was listed first, **neither of the other two would ever be run**.

#### Bubbling up of exceptions
If an exception occurs and there is no corresponding catch block, the method terminates and the exception is passed up to whatever method called it. If the second method has a catch for that kind of exception, it is used, and otherwise the exception is passed further up the calling sequence. If unrolling the sequence of calls doesn’t lead to a method with a catch, the program halts. If a program halts because of an exception, you should check to see if the message tells you where the exception occurred. A mention of something like Lab5.java:43 probably means that the exception occurred on line 43 of Lab5.java.


#### Using Exceptions to create more robust code:

Remember the examples in Chapter 8 in which we were trying to convert a month number into a month name? One approach returned appropriate names when the number was 1 through 11 and returned “December” in the default case. That’s actually not a very robust approach. Here’s a better way:
```java
private String monthName (int month) {
  switch (month) {
  case 1:
    return "January";
  case 2:
    return "February";
    .
    .
    .
  case 12:
    return "December";
  default:
    throw new RuntimeException ("Bad month number");
  }
}
```

Suppose the programmer somehow fails to ensure that this method is called only with a valid month number. It would be unfortunate if this method simply returned “December” without catching the error. The new default case uses a throw statement to generate a new exception.

**This will cause the program to crash (unless you’re catching the exception), which is probably better than returning a bad result.**

#### Checked Exceptions

A **checked exception** is a kind of exception a programmer is required to deal with, or to at least notice.

If a checked exception is thrown in a method f, that method must either:
1. catch the exception, or
2. have a label that declares that that kind of exception might be thrown.

Let's see this example:
Let’s suppose that MyCheckedException is a checked exception.

The header for f would appear as follows, assuming that f itself didn’t use a try-catch to catch that kind of exception:
```java
static int f (int whatever) throws MyCheckedException
```

The keyword throws here is a bit of a misnomer. **It should really be interpreted as “might throw”.**

**Now suppose that method g calls f (the method above), a method labelled with throws MyCheckedException. Method g must either catch the exception, or must itself be labelled with throws MyCheckedException. This makes sense now.**
