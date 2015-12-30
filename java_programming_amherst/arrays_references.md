In this chapter we consider precisely how arrays are handled in Java. Suppose you declare
```
int[] a = new int[100];
```

This statement does several things:
1. It creates a variable of type int[], which means “array of int”. **The variable won’t contain the actual array, but rather it will contain a reference (also called a pointer) to the array itself.** Think of a reference as a numeric address telling where the array is located in the computer’s memory.
2. It allocates space to hold 100 integers.
3. It sets the variable so that it refers to the allocated memory.
Now suppose you execute a statement such as
a[3] = 27;
The computer will check variable a to obtain the address of the array. It will then go to the array itself, find position 3, and store the value 27 in that position.


Now suppose you use the following statements:
```
  int[] b;
  b = a;
  System.out.println(b[3]);
```

These statements cause the number 27 to be printed! This happens because the address found in variable a is copied to variable b. That causes a and b to point to the very same array. Printing b[3] therefore prints the value that we just stored in a[3].

The statement
```
if (a == b)
```
compares the values in variables a and b. Because these variables contain references, the e↵ect is simply to ask “Do a and b refer to the same array?” Notice that this is di↵erent than asking if a and b refer to arrays containing the same set of values.


#### Passing Array References as Paramters

Recall that when you call a method, the parameter variables are initialized with copies of the value given when the method is called. This “call-by-value” system means that changes made within the method to parameter variables don’t affect the variables of the calling method.


Here an example of a method that doesn’t work the way you might suppose:
```java
private static void swap (int i, int j) {
    int t = i;
i = j;
j = t; }
// a useless method
```
This method swaps the contents of variables i and j, but unfortunately it’s useless. Suppose you write:

```
swap (m, n);
```

The swap method runs with variable m copied into i and variable n copied into j. Because i and j are copies, m and n are una↵ected when they are swapped.

But this actually does some swapping:
```
public static void swapElements (int[] a, int i, int j) {
  int t = a[i];
  a[i] = a[j];
  a[j] = t;
}
```

If you call

```
  swapElements(myArray, x, y);
```
I think the reason why this actually swaps is that the "value" of the array variable is a reference, and that reference does affect the actual array.

the elements in positions x and y of myArray will be swapped. Let’s see what happens. Parameter a receives a copy of the variable myArray. Variable myArray is a reference to an array, so a ends up referring to the same array. (Recall that this means that a gets the address of the array itself.) By swapping elements in the array referenced by a, the method effectively swaps elements in the array referenced by myArray.

Lets use that swapElements code here:

The following method reverses the contents of an array:
```java
    private static void reverse (int[] a) {
        // This methods reverses the elements of array a,
        // so the first element becomes the last, and so forth.
        int i=0;
        int j=a.length - 1;
        while (i < j) {
            swapElements (a, i, j);
            i++;
            j--;
  }
}
```
If you call reverse(b), the elements of b will be reversed.

This method returns a new array that is a copy of the original one.
```java
  private static char[] copy (char[] a) {
    // This method creates a copy of array a
    char[] b = new char[a.length];
    for (int i=0; i<a.length; ++i)
      b[i] = a[i];
  return b;
}
```

You can write

```
char[] c = copy(a);
```

assuming that a is an existing array of characters.

This method sums the values in an array:
```java
  private static double addPos (double[] d) {
    // This method adds up the values in an array.
    double sum = 0.0;
    for (int i=0; i<d.length; ++i)
      sum += d[i];
  return sum;
}
```

This method looks through an array, examining values in positions lo through length-1, and returns the position of the smallest element:
```java
private static int findMinPos (int[] a, int lo) {
  // This method looks in the elements of a in positions
  // greater than or equal to "lo" and returns the index
  // of some element of minimum value.
  int pos = lo;
    for (int i=lo+1; i<a.length; ++i)
      if (a[i] < a[pos]) pos = i;
  return pos;
}
```

The above method returns the array index of the lowest value in the range of lo to the end of the array.
