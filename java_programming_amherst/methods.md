### Java Methods


The Java API (Application Programming Interface) is a set of classes that are available to all Java programmers.

In order to run Java programs, your system must have both the Java virtual machine and the entire API. The Java API is essentially a vast library of prewritten code that simplifies programming and helps programmers avoid reimplementation of common code.

This chapter will begin by discussing two classes in the API, Math and String. Let's check them out.

In Chapter 3, one of the programs used a method called Math.sqrt to compute the square root of a number. The documentation for the class Math describes the method sqrt in the following way:

```java
  public static double sqrt (double a);
```

Here are some other methods in the Math class:
```java
public static int max (int a, int b);
public static double max (double a, double b);
public static double random();
public static double cos(double a);
```

Okay so big thing in Java.**Apparently even methods have types.**
When you call a method, you give it arguments, values that it will use in its
computation. When the method has done its work, it will return a result that can be used in some other expression. The type of a method is simply the type of the result it returns.


Let’s look at the header line for the method sqrt.
```java
  public static double sqrt (double a);
```

The word public at the beginning means that the method can be accessed in other classes and packages. The word static means that this is a class method. (We’ll talk about the alternative in a bit.) The word double before the name sqrt means that the method will return a double result. The material within the parentheses is the parameter list, which specifies a name and type for each argument that is passed to the method.


Now look at the example method calls below:
```
double d = 3 * Math.sqrt(7.0);
d = 4 + Math.sqrt(5);
System.out.println (Math.cos(d));
int randomDie = (int)(6.0*Math.random()) + 1;
int i = Math.max (3*j, 17);
```

In each case the method name has the prefix Math. This indicates that we are using a static method in class Math. In the first line, the method sqrt is given a double, which is the specified parameter type. In the next line here:
```
d = 4 + Math.sqrt(5);
```

it’s given an int. This works because an int argument will be automatically cast to a double if needed.

Here are two more hypothetical possibilities for methods:
```java
public static void someMethod (int i);
public static boolean anotherMethod (int i, double d);
```

Suppose these methods are declared in class A. Here are examples showing how they might be used:
```java
A.someMethod(3);
if (A.anotherMethod(2,3.0)) ...
```

The type of someMethod is void, meaning that it returns no value at all. Methods of type void are sometimes used to print something to the screen, and we’ll see many other uses later.


A method that is void can only be invoked as a free-standing statement, never as part of an expression. For example, the line:
```java
int i = A.someMethod(3);           // bad example
```

is meaningless and illegal.

Because methods return values that can be used in larger expressions, it is possible to use a method call within an argument to some other method:

```java
int max = Math.max(Math.max(a,b),c);
```
#### Instance Methods

As mentioned in Chapter 2, String is the name of a class. Individual strings are objects. In some ways, String objects are similar to ordinary values of type int, double, or boolean. For example, a variable of type String can be used as an argument to a method, can be printed, and can be copied. On the other hand, there are also striking di↵erences between objects and ordinary values. Objects can have methods called on them.


The class String defines many methods, including the following:
```java
public int length();
public boolean startsWith(String prefix);
public String toLowerCase();
public boolean equals(String s);
```

Notice that none of these header lines uses the word static. That’s because these are instance methods that need to be applied to particular String objects. These methods are di↵erent than the class methods in class Math, which were not associ- ated with any Math object.


Some examples:
```java
String s = "hello";
String t = "bye now!";
int i = s.length();
boolean b = t.startsWith("he");
t = s.toLowerCase();
if (s.equals(t)) ...
```

The method toLowerCase creates a copy of the given string with all letters converted to lower case.

The equals method permits two String objects to be compared.1 For technical reasons, to be described later, it’s generally a mistake to use the == operator to compare two String objects.


It is possible to apply several methods in sequence. For example, we can write:
```java
if (s.toLowerCase().equals(t)) ...
```


#### Formatted output
This is a less interesting section and I probably alwyas have to come back to it when formatting strings... but let's look at some code I guess?

So this code would be problematic:

```java
public static void main (String[] args) {
  for (double x=0; x<= 1.5; x+=0.1)
    System.out.println (x + " " + Math.cos(x) + " " + Math.sin(x));
}
```
Running this method above produces this output:

```
0.0 1.0 0.0
0.1 0.9950041652780258 0.09983341664682815
0.2 0.9800665778412416 0.19866933079506122
0.30000000000000004 0.955336489125606 0.2955202066613396
0.4 0.9210609940028851 0.3894183423086505
0.5 0.8775825618903728 0.479425538604203
0.6 0.8253356149096783 0.5646424733950354
0.7 0.7648421872844885 0.644217687237691
0.7999999999999999 0.69670...
```

It's ugly output.

So let's replace the System.out.println with this:
```java
System.out.printf ("%3.1f  %5.3f  %8.3f\n", x, Math.cos(x), Math.sin(x));
```

So the first argument of printf is a string that formats the output. The code %3.1f means that a floating point number should be printed in field of width 3, with one digit right of the decimal point.

The three numbers that are printed in the printf are obtained by using the three arguments that follow the formatting string.


Here are some more examples:
```java
System.out.printf ("The answer is %d.\n", answer);
System.out.printf ("%d plus %d is %d.\n", 2, 2, 4);
System.out.printf ("Here’s a number: %6.3f, ", Math.PI);
System.out.printf ("and here it is in scientific notation: %7e\n", Math.PI);
```

Here is the output:
```
The answer is 3.
2 plus 2 is 4.
Here’s a number:  3.142, and here it is in scientific notation: 3.141593e+00
```

we use the code %d to indi- cate that an int should be printed as an ordinary decimal number


So let's fix our earlier code to format it the right way:
```java
public static void main (String[] args) {
  for (int i=1; i<=10; ++i) {
    for (int j=i; j<=10, ++j)
      System.out.printf("%5d ", i*j);
    System.out.println();
  }
}
```

This code will clean up the columns pretty well.
