## Declarations and scope

Let's take a look at some variable declarations

Based on the material you’ve seen so far, there are five possibilities:

1. Declaring local variables with or without initialization:
```
int i = 10000;
int j, k;
int m = 2, n = 3;
```

2. Declaring a parameter:
```
private static void f (int n) {
```
3. Declaring the return type of a method:
```
private static int getNumber() {
```
4. Declaring a variable in the initialization part of a for statement:
```
for (int i=0; i<limit; ++i)
```
5. Casting a value of another type:
```
int i = (int)(d + 3.0);
```

It’s important to make a declaration only when you want to create a new vari- able. It’s tempting to write
```
int i = 3;  // this declaration is fine...
int i = i+1; // int should be omitted here
or
if (int i ==3) // another bad example
```

Be careful to avoid making a declaration when you simply mean to use a variable.

#### Scopes

The scope of a variable declaration is the section of the program in which the variable can be used.

The scope of a local variable declaration begins at the next statement and con- tinues to the end of the block of statements containing the declaration. For example, consider the following if statement:

```java
if (3<4) {
  int j = 3;
  int i = j;
  ...
  i = f(3);    // a method call of a method named f
  int k = 2;
  System.out.println (i*j*k)
}
```

Variables k, j and i can each be used after their respective declarations, but they can’t be used outside the then-block. It’s important to remember that none of these variables can be accessed in method f.

Java uses static scoping, meaning that the scope of a declaration can be determined by its location in the program, not by the order of method calls.


The scopes of other kinds of variable declarations are just what you’d expect: the scope of a parameter declaration extends through the entire method containing the parameter, while the scope of a declaration in the initialization of a for loop is the entire loop.

Method declarations have scopes too. A method can be used anywhere in the class in which its declared, even in methods that precede it. Methods can be used in other classes, depending on the privacy level (such as public or private) that is assigned to the method.


#### Conflict Declarations of local variables

You are not permitted to declare two local variables with the same name and over- lapping scopes. The compiler will generate an error for this code:
```java
int i=3;
  while (...) {
    int i=1;
... }
```

The first declaration of i is still in e↵ect within the while loop, yielding overlapping scopes.


The following code is fine:
```java
if (...) {
  int i=2;
... }
else {
  int i=3;
... }
```

In this case the scope of the first declaration ends before the scope of the second one begins.

Parameters are treated the same way. If you have a parameter with a particular name, that method can’t have a local variable (or another parameter) with the same name.

#### Initialization

You should initialize a variable at the time it’s declared if there is some reasonable value to assign to it. For example, in a program adding up a sequence of numbers, it’s appropriate to write:
```java
int sum = 0;
```

Zero is the natural starting value for this variable. On the other hand, it’s best to avoid initialization if there is no good starting value. Consider the following code:

```java
int i;
if (...)
    i = f(); // // calling method f
else
  i = g(); // calling method g
println (i);
```

The value you want to assign to i depends on the result of the if, and there is no sensible initialization.
