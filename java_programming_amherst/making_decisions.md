## Making decisions

Computer programs can be designed so that di↵erent inputs cause di↵erent actions to occur.

```java
public static void main (String[] args) {
  System.out.print ("Enter an integer: "); int a = keyboard.nextInt();

  if(a>0)
    System.out.println ("Your value is positive.");
  else {
      System.out.println ("Your value is not positive.");
      System.out.println ("Too bad!");
  }
  System.out.println("Goodbye!");
}
```

Notice the use of the reserved word if on line 7. This is the beginning of an if-then-else statement. When the program runs, the test condition a > 0 on line 7 is executed. If variable a is positive, the then-clause is executed
In this case the then-clause is the single statement after the test condition a>0, and the else-clause is the block of statements beginning after the else

It is also possible to have an if statement without an else-clause. This is called an if-then statement. Here’s an example:

```java
if (a > 0)
  System.out.println ("a is positive");
if (b < a)
  System.out.println ("b is less than a");
System.out.println ("Now we’re done.");
```

If a is positive, the first println state- ment is executed. Then, whether or not a was positive, the second test is applied. Depending on the outcome of the second test, the second println might be used. Finally, the third println is executed.


In general, the form of an if-then-else statement is:
```
if ( expression )
  statement
else
  statement
```

The form of an if-then statement is:
```
if ( expression )
  statement
```


Often the test expression is a simple comparison of numeric values. There are six operators for comparing numbers:
```
== equals
!= not equals
> greater-than
< less-than
>= greater-than-or-equals <= less-than-or-equals
```

In either kind of if statement, the test expression must be enclosed in parentheses.

The then-clause is a single statement that follows the test expression. It might be a println statement, an assignment statement, or even another if statement.
The then-clause can also be a block of statements surrounded by braces, { and }. Here’s another example:

```
if (a != 3*b)
  i = 1;
else
  i = 2;
```

In this case a is compared to 3*b. If they are unequal, the then-clause is executed; otherwise the else-clause is executed. In this case each clause contains a single assignment statement. It’s fine to add braces to make a clause a block:

```
if (a != 3*b)
  i = 1;
else {
  i = 2;
}
```

Here’s an incorrect if-then-else:

```
if (a != 3*b)
    i = 1;
    j = 4;
else {
  i = 2;
  j = 3;
}
```

The problem here is that there are no braces around the intended then-clause. The compiler interprets the assignment i = 1; as the entire then-clause. It then expects to see either the keyword else or some other statement. When it sees the assignment to j it decides that an if-then statement has ended. When it later sees the keyword else it issues a error message saying that there is an else-clause without a corresponding if statement.

It’s important to use spacing and indentation well to indicate your intentions to human readers of your programs. As we discussed earlier, the compiler doesn’t care about spacing or indentation at all, but the layout of your program can either hinder or help others who read your programs.

```java
if (a != 3*b)              // a confusing program
  i = 1;
j = 4;
k = 3;
```

It’s hard to tell what’s going on in this example. Does the programmer intend to have the assignment to j be part of the then-clause? If so, braces need to be placed around the then-clause. On the other hand, if the assignment to j is supposed to follow the if-then statement, it should be lined up underneath the keyword if.


### Some example pieces of code

A quadratic equation has the form
```
ax^2+bx+c = 0,
```

**This code solves quadratic equations**
```java
import java.util.Scanner;

public class Quadratic {
// This program solves quadratic equations
// L. McGeoch, 9/2004

  public static Scanner keyboard = new Scanner(System.in);

  public static void main (String[] args) {
    System.out.println ("This program solves quadratic equations of the");
    System.out.println ("form a*(x^2) + b*x + c = 0.");
    System.out.println ();
    System.out.print ("Enter integers for a, b, and c: ");

    int a = keyboard.nextInt();
    int b = keyboard.nextInt();
    int c = keyboard.nextInt();

    int discriminant = b*b - 4*a*c;
    double r = -b / (2.0 * a);

    if (discriminant == 0) {
      System.out.println ("There is one root: " + r);
    }
    else if (discriminant > 0) {
      double d = Math.sqrt (discriminant) / (2.0 * a);
      System.out.println (" There are two real roots: "
        + (r+d) + " and " + (r-d));
    }
    else {
      System.out.println ("The roots are complex numbers.");
  }
  }
}
```

Notice the Math.sqrt method. It is one of a set of mathematical methods that can used in any Java program.



**This program finds the Median**
```java
import java.util.Scanner;

public class Median {
  // This program finds the median of 3 integers

  public static Scanner keyboard = new Scanner(System.in);

  public static void main (String[] args) {
    System.out.print ("Enter three integers: ");

    int a = keyboard.nextInt();
    int b = keyboard.nextInt();
    int c = keyboard.nextInt();
    int median;

    if (a < b) {
      if (b < c) {
        median = b;
      }
      else { // b is the biggest
        if (a > c)
          median = a;
        else
          median = c;
      }
    }
    else { // a >= b
      if (c >= a) {
        median = a;
      }
      else { // a is the biggest
        if (b > c)
          median = b;
        else
          median = c;
      }
    }
    System.out.println("The median value is  " + median);
  }
}
```

In this program there are three levels of if statements which seems necessary.

**Interesting point with median program:**
ou should usually try to initialize each variable to an appropriate value when it is declared. The median-finding program shows a case in which no initialization is appropriate. There is no reasonable starting value for variable median. We simply declare it without initialization and then assign values in the right places.


Let's rewrite the Median program using Booleans.

Quick explanation of Booleans:

We can construct more complex boolean expressions, for example:

```
(a < b) && (c > d)
(i >= 0) || !(c > e)
```

These expressions illustrate the use of three new operators: && ||, and !. The operator && means "and". It yields the value true if the values on its left and right are both true. The first boolean expression here is true if both a < b and c > d are true.

The precedence of the operator && is higher than ||. So in the expression
```
a<b || c<d && e<f
```

the results of the second and third comparisons are “anded” before the “or” operation.


```java
import java.util.Scanner;

public class Median2 {
   // This program finds the median of three integers
  public static Scanner keyboard = new Scanner(System.in);
  public static void main (String[] args) {
    System.out.print ("Enter three integers: ");

    int a = keyboard.nextInt();
    int b = keyboard.nextInt();
    int c = keyboard.nextInt();

    int median;

    if((a<=b&&b<=c) || (c<=b&&b<=a))
      median = b;
    else if ((b<=a&&a<=c) || (c<=a&&a<=b))
      median = a;
    else
      median = c;

    System.out.println ("The median value is " + median);
  }
}
```


#### Dangling if problem:

Consider the following code:
```java
if ( a < b )
  if ( c < d )
    i = 0;
else
  j = 1;
```

This code could be interpreted two ways. There could be an if-then statement in the then-clause of an if-then-else. That is, it could be equivalent to this code:

```java
if ( a < b ) {
  if ( c < d )
    i = 0;
}
else
  j = 1;
```

Alternatively there could be an if-then-else statement in the then-clause of an
if-then. That is, the original code could be equivalent to the following:

```java
if ( a < b ) {
  if ( c < d )
    i = 0;
  else
    j = 1;
}
```

The existence of two interpretations of the original code fragment is called the dangling else problem. The indentation suggests that the programmer intended the first interpretation, but the compiler will use the second. The compiler’s rule is: an else-clause is part of the closest if to which it can be attached. Beware, and be sure to use braces to disambiguate the meaning of your programs.
