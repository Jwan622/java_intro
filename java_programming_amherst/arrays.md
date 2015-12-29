## Arrays in Java

An array is a set of variables that is created at one time and that can be referenced using a common name. Here’s an example:

```java
int[] a = new int[100];
```

This declares a variable called a. Its type, int[], means “array of ints”.
**The expression new int[100] allocates enough memory to hold 100 ints.**
**If variable a is declared and initialized in this way, we say that “a refers to an array of 100 ints.”**

The above is new and a departure from Ruby.


It is possible to “index into an array” to access individual elements. Here are some examples:
```
int j = a[50];
int k = 3;
j = a[k];
int m = a[3*a[2]];
a[k] = a[k-1];
```

a[50] refers to the 50th integer in the array. a[k] uses use whatever value is in variable k as the index into array a. In this case k is 3, so a[k] refers to the third integer in the array. Any integer expression can serve as the index. For example, in the third line the value in a[2] is multiplied by three, and that value is used to pick an element out of the array.

If an array has n elements, the indices of the element will be from 0 to n   1. The first element of the array always has index 0. An attempt to use a nega- tive index or an index greater than or equal to the array length will cause an ArrayIndexOutOfBoundsException.

#### Examples of Arrays

Here’s a code fragment that generates the first 100 Fibonacci numbers and stores them in an array

```java
int[] fib = new int[100];
fib[0] = 1;
fib[1] = 1;
for (int i=2; i<100; ++i)
  fib[i] = fib[i-1] + fib[i-2];
```


This code will find the largest value in an array of ints:

```java
int[] a = new int[...];     // some length is used
// Values are then somehow assigned to elements of the array so the array is filled with ints
...
// Now, we look for the maximum value in the array
int big = a[0];  // big will rep the largest value in the array
for (int i=1; i<a.length; ++i)
  if (a[i] > big)
    big = a[i];
```

Here’s an example of an array with strings:
```
String s = "hello";
char[] a = s.toCharArray();
printBackward(a);
```

The method toCharArray in class String takes the given String and returns an array of chars containing all of its characters.

Some methods that deal with arrays:

```java
public static void printBackward(char[] a) {
  for (int i=a.length-1; i>=0; --i)
     System.out.print (a[i]);
  System.out.println();
}
```

Notice the backwards iteration through the array in this method.


Here's another method that deals with arrays:

```java
public static char[] reverseArray (char[] a) {
  char[] b = new char[a.length];
  for (int i=0; i<a.length; ++i)
    b[i] = a[a.length-1-i];
  return b; }
```

Method reverseArray takes an array of characters and returns a new array that contains the original sequence of characters reversed. Notice how it starts by initializing a new array called b then iterates through the parameter array from the back. It starts from the back of the parameter array and takes each element and puts it into the newly initialized array.


#### Palindrome method using arrays

```java
public static boolean paltest(String s) {
  //Returns true if s is a palindrome.
  //Ignores non-letters and is case-insensitive

  char[] c = s.toLowerCase().toCharArray();
  int i = 0;
  int j = c.length-1;

  while (i < j) {
    if (!Character.isLetter(c[i])) {
      i++
    }
    else if (!Character.isLetter(c[j])) {
      j--;
    }
    else if (c[i] != c[j])
      return false;
    else {
      i++;
      j++;
    }
  }
  return true;
}
```

The method disregards nonalphabetic characters, and it makes no distinction between upper- and lower-case letters.
This example uses its loop in an interesting way. Variables i and j keep track of current positions at the low and high ends of the array. If the character in position i is not a letter, i is increased and the loop test is applied again. So a word like +loool would be a palindrome. If there are letters that do match, i and j both move towards each other. The loop continues until the two index variables meet. If they do meet, the string must be a palindrome, and the method returns true.


#### Matrices

A matrix is an array with two or more dimensions.
The following contains code that 1) creates a two-dimensional matrix to hold a multiplication table, and 2) prints the table.

```java
public static void main (String[] args) {
  int[][] b = makeTable(10);
  printTable(b)
}

static int[][] makeTable(int size) {
  int[][] a = new int[size][size];
  for (int i=0; i<size; ++i)
    for (int j=0; j<size; ++j)
      a[i][j] = i*j;
  return a
}

static void printTable(int[][] a) {
  for (int i=0; i<a.length; ++i) {
    for (int j=0; j<a[i].length; ++j)
      System.out.printf("%4d ", a[i][j]);
    System.out.println();
  }
}
```

The line under main shows the declaration and initialization of a two-dimensional array. The makeTable method illustrates how a new array is created, and the i*j line shows the assignment of a value into the array. The first dimension of a two-dimensional array is often referred to as the row and the second as the column, so variable i is the row and j is the column.

These two uses of the keyword length offer a hint about the true nature of a two-dimensional matrix, which is that it is simply an array of arrays. Each row is an array, and the overall matrix is an array of rows. We’ll discuss this idea more fully in Chapter 13.


#### Array initialization

When an array is created, all of the elements are given initial values, depending on the basetype, the declared type of the element.
```
In an array of...     The initial value is...
    int                        0
    double                     0.0
    boolean                    false
    char                       '\0'   //the zero character
    objects                    null
    arrays                     null

```

null is a constant that represents a missing object or a missing array. Suppose you wrote

```java
String[] a = new String[10];
```

Variable a[3] is initially null, meaning that it contains no string at all.
It's possible to test this null value initialization by writing:
```java
if (a[3] == null)
```


Here's an example of a method that uses null:

```java
static boolean findString(String[] a, String s) {
  for (int i=0; i < a.length; ++i) {
    if (a[i] != null) {
      if (a[i].equals(s)) return true;
    }
  }
  return false;
}
```

The goal of this method is to search for a string s in array a and to return true if it is found. The code takes note of the possibility that some elements of the array might be missing, perhaps because only part of the array was filled in during a previous step, or perhaps because one or more elements were set to null. This method checks whether each string a[i] is null and compares it to s only if the string really exists. **This is a critical check, because a[i].equals(s) will cause an exception if a[i] is null.**


It is possible to initialize an array as part of its declaration. Here are some examples:
```java
  int[] a = {4, 5, 6};
  String[] b = {"This", "is", "fun", "isn’t", "it?"};
  int[][] m = {{1, 2, 3}, {4, 5, 6}};
```

The third example is a little trickier. Matrix m is e↵ectively a two-dimensional array with two rows and three columns. Another way to declare m would be to write
```java
  int[] m = {{1, 2, 3}, a};
```

Array a would become, in every sense, the second row of m. This would mean, for example, that any change to a[0] would change m[1][0].
