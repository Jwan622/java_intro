## Enumerated Types

An enumerated type is a way to define a new type that can represent one of a finite set of alternatives. We’ll use an enumerated type to represent a suit.
Suppose a file Suit.java contains the following:

```java
public enum Suit {Spades, Hearts, Diamonds, Clubs};
```

This code says that a variable of type Suit can take on one of four values. We could then write the following code in another class.

```
  Suit s = Suit.Spades;
  Suit t = Suit.Hearts;
```

This code says that a variable of type Suit can take on one of four values. We could then write the following code in another class.

```
  Suit s = Suit.Spades;
  Suit t = Suit.Hearts;
  System.out.println ("The suits are " + s + " and " + t);
  if (s.equals(t))
      System.out.println ("The suits match.");
```

The output would be
```
  The suits are Spades and Hearts
```

In doing the assignment into variables s and t, we had to say Suit.Spades and Suit.Hearts because Spades and Hearts were symbols defined only within the enumerated type Suit.

The code for creating a deck of cards could then become the following:
```java
    Suit[] suits = new Suit[52];
    int[] values = new int[52];
    int k=0;
    for (Suit s : Suit.values()) {
        for (int v=2; v<=14; ++v) {
            suits[k] = s;
            values[k++] = v;
        }
}
```

#### For each loops in Java


The outer for loop in the code above is a for-each loop. It's this line:
```java
for (Suit s : Suit.values())
```

The loop will run four times, with variable s taking on each of the different values in the enumerated type.
For-each loops can be used with arrays, too. Here’s an example:

```java
String[] a = ...;
for (String t : a)
  ...
```

The body of the loop will run once for each element of a, starting in position 0, with t taking on the value of each element. Neat!

For-each loops are slightly more succinct way to iterate across the elements of an array and are appropriate when 1) you want to iterate across the whole arrays, and 2) you don’t need access to the index of the current element.

#### Enumerated types with switch statements
Switch statements can be used with enumerated types. Here’s an example:
```java
Suit s = ...;
  switch (s) {
  case Spades:
  case Clubs:
      System.out.println ("It’s a black card.");
      break;
  case Diamonds:
      System.out.println ("It’s a diamond.");
      break;
  default:
      System.out.println ("It’s something else, I’m guessing hearts");
  }
```
