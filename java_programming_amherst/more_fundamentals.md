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

The method charAt is declared in class String as

```java
public char charAt(int pos);
```

It returns the character in the designated position of the given string. Note that the purpose of the for loop is to go through the characters of the string. If the string has length l, the first character is said to be in position 0 and the last is said to be in position l-1. You will cause an exception if you ask for the character in a position that is negative or greater than l-1.


Switch statements can be used with chars.

```java
public static int countVowels (String s) {
  int count=0;
  for (int i=0; i<s.length(); ++i) {
    char c = s.charAt(i);
    c = Character.toLowerCase(c);
    switch (c) {
    case ’a’:
    case ’e’:
    case ’i’:
    case ’o’:
    case ’u’:
      count++; }
  }
  return count;
}
```

#### How characters are represented
All characters are represented by integers between 0 and 65535. Here are some examples of characters and their Unicode representations:

```
’’ 32 ’!’ 33 ’"’ 34
’0’ 48
’1’ 49
’2’ 50
.. .. ..
’9’ 57
’A’ 65
’B’ 66
’C’ 67
```

You can write:
```java
  if (c >= ’a’ && c <= ’z’)
```

This essentially asks “Does c contain a lower-case letter?” and it works by comparing the character code in c to the character codes for 'a' and 'z'.

Another way to ask the same question is
```java
if (Character.isLowerCase(c))
```

You can convert an upper-case character to a lower-case one with
```java
c = (char)(c - ’A’ + ’a’);
```

When arithmetic is done on a char, it is first converted to the int that represents it in the Unicode system. Subtracting ’A’ from a variable c essentially asks “How far into the upper-case letters is the character in c?” Adding ’a’ then yields the int that is the same distance into the sequence of lower-case alphabetic character code. The cast to char is needed because char is a special kind of int with a more limited range of values. By using the cast, the programmer acknowledges that he or she understands the special nature of the assignment and expects the value to be in the correct range, 0 through 66535.


#### Special characters

Certain “special characters” have been assigned codes in the Unicode character set. Here are some examples:
```
’\n’ the newline character ’\t’ the tab character
’\0’ the zero character
’\’’ the single-quote character
’\"’ the double-quote character
’\\’ the backslash character
```



#### Assignments as Expressions:

Each of these operators
```
= += -= *= /= %=
```

does an assignment that can be part of a larger expression. Here’s an example:

```
if ((i = keyboard.nextInt()) > 0) ...
```

In this case, an assignment is made into variable i, and then that value is compared to 0. The rule is: whatever value is assigned in an assignment is also available for use in a larger expression.

Here’s another example:

```
i = j = k;
```

A sequence of assignments is done, from right to left. The value of k is assigned to j, and then that same value is assigned to i.

The precedence of assignment operators is lower than all of the operators shown on page 42 and than the ?: operator introduced above. The assignment operators could be given a line of their own at the very bottom of the precedence chart.
**The precedence rules imply that it is usually necessary to surround an assignment with parentheses when it is part of a larger expression, for example in the if statement above.**



The fact that an assignment is an expression creates the possibility of an inter-
esting logical error. If a and b are boolean variables,
```java
if (a == b) ...
```

and

```java
if (a=b) ...
```

are legal statements that do very different things.... but you already knew that from Ruby!
