```java
public static void main (String[] args) {
  int i = 1;

  while (i <= 10) {
    System.out.println("Hello " + i);
    i = i + 1;
  }
}
```
- We declare i and initializing it to the value 1.
- We then use a while loop to repeatedly print out a message.
- In this, the expression in parenthesis is evaluated 11 times with i = 11 at some point.
- When i is = 11, the expression is false and the body of the while loop is skipped.

The general form of a while statement is:
```
while ( expression )
  statement
```

The expression can be any boolean expression. The body of the while can be any statement at all, including a block of statements enclosed by braces.

When a while statement is reached, the expression is evaluated. If it is false, the body is skipped and execution resumes at the statement following the while statement. Consider the following code:
```
  System.out.println ("Hi");
  while (1 < 0)
      System.out.println ("This is never printed");
  System.out.println ("Bye");
```

This code first prints the word "hi". The test expression is false, so the body of the while is skipped and the word bye is printed.

If the test expression is true, the body of the while is executed and then the test expression is reevaluated. The “loop” of testing the expression and executing the body may be repeated many times until eventually the test expression becomes false.


One common programming error is creating an infinite loop. Consider the following code:
```
int i = 0;
while ( i < 10 )
    println ("Hi");
```

Notice that the variable i is never changed within the loop. The condition i < 10 will always be true and the program will keep running and running and running. Most systems have some way of terminating programs that are stuck in infinite loops. For example, on a Unix system you can usually type CTRL-C to end a program.


### boolean variables
boolean is a full-fledged type in Java, just as int and double are types. There are two boolean constants, true and false. Every boolean expression evaluates to either true or false and every boolean variable contains one of these values. Boolean values can only be stored in boolean variables and they can’t be used in a place where a number is expected. Here are some illegal statements which would cause compiler errors.

```
boolean b = 3;       // some bad examples
  int i = 3<4;
  double d = false;
```
In each case, the value that is being assigned is not compatible with the variable that is the target of the assignment.



### Assignment operators

The following operators permit you to combine arithmetic with assignment:
```
+= -= *= /= %=
```

Java also uses two operators, ++ and --, for increment and decrement operations.

Writing either i++ or ++i is equivalent to i = i+1, and writing either i-- or --i is equivalent to i = i-1. The placement of the operator either before or after the variable is significant only if the increment or decrement is part of a larger expression. For example, consider the statement:
```
j = i++;
```
This would copy the value of i into j and would then add one to i. On the other
hand, the statement
```
j = ++i;
```
would add one to i before copying the value to j. In other words, the placement of the ++ operator before or after the variable indicates whether the increment should take place before or after the variable’s value is used.


### For loops

A for loop is a variant of a while loop. Consider the following code:
```
for (i=0; i<n; i++) {
  System.out.println ("Hello");
  System.out.println ("The number is " + i);
}
```

This code is equivalent to the following while loop:

```
i = 0;
while (i < n) {
    System.out.println ("Hello");
    System.out.println ("The number is " + i);
    i++;
}
```
The general form of a for loop is:

```
for ( initialization ; expression ; increment )
statement
```
It is equivalent to:
```
initialization ;
while ( expression ) {
  statement ;
  increment ;
}
```

Here is a simple prime number checker method using a for loop:

```java
int p = keyboard.nextInt();
boolean prime = true;

for (int i = 2; i<p; i++) {
  if (p%i == 0) prime = false;
}

if (prime)
  System.out.println("The number is prime");
```


#### Do-while loops

Here’s an example of another kind of loop:
```
i = 0;
do {
  System.out.println ("Hello");
  i++;
}
while (i < n);
```

The general form is:
```
do
  statement
while ( expression ) ;
```
The only difference between a do-while statement and a while statement is that the test is at the end. This means that the body of a do-while will always be executed at least once.

Usually it’s appropriate to use a while loop, but we’ll see examples later in which it’s better to use a do-while.


#### Nested loops
Sometimes it's useful to have loops within loops. This is called nesting and we say that one loop is nested within the other.


```java
public static void main (String[] args) {
  for (int i=1; i<=10; ++i) {
    for (int j=1; j<=10; ++j)
      System.out.print(i*j + " ")

    System.out.println(); // this is the carriage return in the multiplication table
  }
}
```

The above code is a multiplication table
