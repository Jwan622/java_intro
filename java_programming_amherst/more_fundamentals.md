## More fundamentals of java

#### The switch statement

A switch statement permits a value to be used to select the code that should be executed. Here's an example:

```java
public static void main (String[] args) {
  System.out.print ("Enter an integer");
  int i = keyboard.nextInt();

  switch (i) {
  case 2:
    System.out.println("You entered a two");
    break;
  case 1:
    System.out.println("You entered a one");
  case 3:
  case 4:
    System.out.println("You entered a one, three, or four");
    break;

  default:
    System.out.println("I don't recognize that number");
  }
  System.out.println("Goodbye");
}
```

In this case the parentheses surround an expression of type int. Depending on the value of the expression, control jumps to one of the cases. Some number of cases can be explicitly listed, along with a default. If there is a default, the default is used for any value not covered by one of the cases.

The break statement causes execution to jump out of the switch. In other words, it causes control to jump to whatever statement follows the entire switch. In the absence of a break, control simply falls through from one case to the next. That’s why cases 3 and 4 lead to the same code in the example above.

If there is no default, and if the expression value doesn’t correspond to one of the case values, control simply jumps to whatever statement follows the switch. Consider the following:

```java
int i = 4;

switch (i) {
case 1:
  System.out.println ("Hi");
  break;
case 2:
  System.out.println ("Bye");
  break;
case 3:
  System.out.println ("Goodnight");
}
System.out.println ("Here we are after the switch");
```

With i equaling 4, no case is used and control jumps to the final println. If i equals 1, 2, or 3, one of the other messages is also printed.


Beware of problems with uncovered cases in a switch. Consider the following:
```java
private String monthName (int month) { // bad example since this method needs to return a String
  switch (month) {
  case 1:
      return "January";
  case 2:
      return "February";
  case 12:
      return "December";
  }
}
```
The compiler will reject this code because it is possible to reach the end of this monthName method without returning a value. You could replace case 12 with default to get a working method.


#### Break and Continue statements in loops

A **break** statement can also be used in a loop:
```java
private static int getANumber() {
  int sum = 0;

  while (true) {
    System.out.println ("Enter an integer: ");
    int n = keyboard.nextInt();
    if (n < 0) break;
    sum += n;
  }

  System.out.println ("The sum is " + sum);
  return sum;
}
```

If variable n is negative, execution will break out of the loop and will continue at the statement immediately following the loop. A break statement always causes execution to jump out of the closest containing switch or loop.

A **continue** statement is similar. Here’s an example:
```java
for (int n=2; n<1000; ++n) {
  if (isPrime(n)) continue;
  .  // some complex computation occurs here
  .
  .
}
```

For a given value of n, the isPrime test occurs first. If the value is prime, execution jumps up to the top of the loop and continues with the next value of n. So the “complex computation” occurs only for numbers that are __not__ prime.


#### Characters and the char type

Java uses the type char to represent single characters. The following are legal assignments:
```java
char c = ’a’;
char d = c;
d = ’ ’;
c = ’3’;
```

The first of these examples declares a char variable called c that contains the letter a. The second copies variable c into d, so d also contains the letter a. The third fills d with a blank, while the fourth puts the digit 3 into c. Note that char constants use single-quote marks, not the double-quote marks used in strings.
