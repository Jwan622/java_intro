```java
public class HelloAgain {
  public static void main(String[] args) {
    int i = 3;
    i = i * 2;

    System.out.println("Hello Again")
    System.out.println("There times two is...");
  }
}
```

Every program has a method named main. When you run a program, execution begins with the main method.
The first line of the main method, its method header, should always be:

```java
public static void main(String[] args) {

}
```

A variable is a piece of computer memory capable of holding some kind of information.
Example:  
```java
int i = 3;
```

In this case, i is declared to be an int, meaning that it can hold any integer (at least up to a very large limit that we’ll discuss later). Variable i initially contains the integer 3.

Next we have this line:  
```java
i = i * 2;
```
It computes a value, i * 2, and puts the result into variable i.

Let's look at the first line:

```java
public class
```

Every method in Java is part of a class. Classes are a powerful mechanism for organizing programs, but for now you’ll simply use them as containers for methods. The first line gives the name, HelloAgain, of the class. The actual class consists of everything between the left brace, {, at the end of the first line and the right brace, }.


#### Comments in java

Whenever you use a pair of consecutive slashes, //, the rest of the line is treated as a comment. Blank lines and spacing, except within quotation marks, don’t a↵ect the computer’s handling of a program.


#### Editing, Compiling, and running a program

The program we discussed above was based on a class called HelloAgain. Before you can use this program, it must be typed into a file called “HelloAgain.java”. In general, the file must have precisely the same name as the class, with .java added as a suffix. Java usually distinguishes between upper and lower case, so a class Fun must be in Fun.java, not fun.java or FUN.java.



To compile your program, turning it into virtual machine code, you use the command

```java
javac HelloAgain.java
```

If the compilation is successful, you’ll get a file called “HelloAgain.class”. If there’s an error in your program, you’ll get an error message, with a brief description of the problem.


You should never edit the .class file, because it contains material that looks like gibberish in an editor. This gibberish is simply the computer’s version of your program.


Once you have successfully compiled your program, you can run it on the Java Virtual Machine. On a Unix system you use the command:

```java
java HelloAgain
```

Once you run your program, you may decide that it doesn’t work correctly. You can then go change the program, and then compile and run again. You never need to recompile unless you’ve changed your program.


#### Identifiers

- Class names and variable names are identifiers, names chosen by the programmer.
- An identifier can contain any sequence of letters or digits, beginning with a letter. The dollar sign, $, and the underscore, , are considered letters. Upper-case letters and lower-case letters are distinct, so a variable hi is different from a variable Hi.

Here are some examples of legal identifiers:
```
hiThere r2d2 mytemp Thisis $$3
```

Here are some examples that are not legal:
```
2bOrNot2b b+c
```

It is good style to choose class names that are meaningful and begin with an upper- case letter. Good examples are:
```
ChessMeister TempCalc Lab3 GameEditor
```

Variable names should be meaningful and should start with a lower-case letter. The upper-case versus lower-case rule helps readers distinguish di↵erent kinds of identifiers at a glance. Examples of good variable names are:
```
temp3 total herAge studentCount prevMonth
```

Any word that is a reserved word can not be used as an identifier. (Most of these are keywords; others are names of types.) The Java reserved words are:
```
  abstract
case
continue
enum
float
import
native
protected
strictfp
throw
void
assert
catch
default
extends
for
instanceof
new
public
super
throws
volatile
boolean break byte
char class const
do double else false final finally goto if implements int interface long
null package private return short static switch synchronized this transient true try while
```


Java has a large set of associated classes, known as the Java API. You can cause conflicts and create strange errors if you happen to give your class the same name as one of these special classes. Here are some of the names you should try to avoid:
```
String System Scanner Object Class
```


#### Variables
- A program uses variables to store information that is used in a computation. Every variable has an identifier (its name), a type (the kind of information it can hold), and a value.

For example, in the program in Figure 2.1, we used the statement

```java
int i = 3;
```

This is a declaration that says that a variable i of type int should be created. Such a variable can hold any integer that is, ignoring sign, less than 231, about two billion. In this example, the declaration of i is combined with an initialization that gives the variable an initial value.


It’s useful to think of a variable as a box, such as in Figure 2.2. The top part of the box gives its name, and the bottom part its value. In reality the box corresponds to a small piece of computer memory, which holds information that is stored and may be needed later. Here are several more examples:
```java
int maxStudents = 100;  // initialization
int studentCount;  // no initialization
int myAge, hisAge, herAge;   // multiple variables
```

If no initial value is given for a variable, it is uninitialized.


Another basic type is double. A double variable can contain a floating-point number, that is, a number that is not necessarily an integer. For example, you can make the following declarations:

```java
double pi = 3.14159;
double gpa;                  // grade point average
double bankBalance = 0;
```

A double can be initialized to an integer value.

Technically, a variable of type double holds a double-precision floating point number. There’s another type called float that is used for a single-precision floating point number. Variables of type float use less computer memory than doubles and can sometimes be manipulated faster. Unfortunately floats are less precise and are subject to more rounding errors. For this reason it’s usually better to use doubles. We’ll talk more about precision later.

#### Assignments and Expressions

- In general, the form of an assignment statement is:
-
```
variable = expression ;
```

The type of the expression must be compatible with the variable, in a way that we’ll discuss shortly.

An expression is a value or a computation that yields a value. Here are some simple expressions:
```
i
3.4
i + (j*k)
(2+j) - (c/6)
```

Every expression has a type, for example int or double. Every variable can be used,
by itself, as an expression. So you can write:
```
i = j;
```
as long as i and j are both declared and have appropriate types. This copies the value in j into i.


If you do arithmetic on two ints, the result is an int. If you do arithmetic on two doubles, the result is a double. If you do arithmetic on an int and a double, the int is converted to a double, the operation is performed, and the result is a double.

For example, you can write:
```
i = j + k;
b = 3 * 4.1;
a = i - (2.0 * j);
c = j / 3;
```

These rules lead to some interesting consequences for the division operator, /. The expression 3 / 4.0 means that the integer 3 is converted to a double and then divided by 4.0, yielding the quotient 0.75. The expression 11 / 6 means that the integer 11 is divided by 6, yielding an integer. That integer is 1, the result of “whole number” division of 11 by 6, with rounding towards zero.


Suppose you have the following declarations:
```
int i, j, k;
double a, b, c;
```

The following sequence of statements is correct:
```
i = 3;   
a = i + 5;    // a gets the value 8.0
b = 12 / a;   // b gets the value 1.5
c = i + b;    // c gets the value 4.5
c = c - b;    // c now gets the value 3.0
j = 12 / 3;   // j gets the value 4;
a = 12 / 3;   // a gets the value 4.0
b = 13 / 3;   // b gets the value 4.0! that's interesting.

// The following statements are not legal:
i = 4.3;       // not legal
j = 4.0;       // not legal
k = a + 1.7;   // not legal
```



#### Order of operations

In the absence of parentheses, operations happen in the following order:
1. Negation: Unary minus signs are used to negate values.
2. * / and % these are performed from left to right.
3. +, -: These are performed from left to right.


Now consider this statement:
```
a = b * c+d * e;
```
The rules remain the same. Despite the misleading spacing, multiplication take precedence over addition, so it is equivalent to:

```
a = (b*c) + (d*e);
```


#### casting

If you have a double and you want to turn it into an int value, you can do a cast. You do this by writing (int) before the expression to be converted. The fractional part of the double is e↵ectively discarded. For example, you can write:
```
i = (int) 3.4;                 // expression equals 3
j = (int) (a / .61);
k = (int) -9.1;                // expression equals -9
```

Casting has precedence equal to that of the unary minus sign, so you need to use parentheses if you want to convert an expression involving operators such as addition and multiplication.


#### problems with arithmetic

If you have a numerical expression whose value is too large, overflow can result. For example, if you have:
```
int billion = 1000000000;
int value = billion * billion;
```

You’ll actually end up with value equalling  1486618624. This happens because no int can hold a number larger than about 2 billion. In e↵ect, the internal repre- sentation of a large number ends up being confused with that of some other number. The same thing can happen in the negative direction: numbers smaller than about  2 billion cannot be represented.
Floating-point values have di↵erent limitations. Overflow can occur, though at a much higher cuto↵. The more significant problem is precision. If a person is asked to divide one by three, he or she can’t write the answer down as a decimal number without losing part of the answer. The answer is close to 0.33333333, but that value is only approximate. Values of type double have about 15 decimal digits of precision. Interestingly, because computers are based on binary (base 2) arithmetic, numbers such as 1/5.0, which can be represented precisely in decimal, cannot be represented precisely in a computer. Because of imprecision, the value of a / b * b might not equal the value of a.


### Another java program

```java
import java.util.Scanner;
public class TempCalc {

  // This program does temperature conversion.
  // L. McGeoch, 9/2004

  public static Scanner keyboard = new Scanner(System.in); 9
  public static void main (String[] args) {
    double fahrenheit; // These variables contain
    double celsius; // temps in three different
    double kelvin; // systems.

    System.out.print ("Enter a temperature in Fahrenheit degrees: ");
    fahrenheit = keyboard.nextDouble(); // reads from the keyboard

    celsius = (fahrenheit-32) * (5.0/9.0);
    kelvin = celsius + 273.15;

    System.out.println ("That’s " + celsius + " degrees Celsius,");
    System.out.println ("or " + kelvin + " degrees Kelvin.");
  }
}
```

In this program, we declare 3 double variables without initializing them.
The program asks for information, it reads the information, it computes something, and it writes the answer.

Two special statements must appear in any program that requires keyboard input. The statement:

```
import java.util.Scanner;
```

must be at the very top of the program, even before the line giving the name of your class. The statement:

```
public static Scanner keyboard = new Scanner(System.in);
```

must appear within your class but outside your main method.
Those two statements ensure that the program can read from the keyboard.


If a program has established access to the keyboard, it can read numbers with the method call

```
keyboard.nextDouble().
```
