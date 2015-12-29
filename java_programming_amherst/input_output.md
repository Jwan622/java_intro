## Input and Output in Java

In this chapter we explore more ideas about the ways in which programs can do input and output.

#### Let's look at the Scanner Class

Java’s Scanner class—its full name is java.util.Scanner—o↵ers a convenient way to read values from a keyboard, file, or other input source. Recall that by including the line
```java
  public static Scanner keyboard = new Scanner(System.in);
```
in the file for our main class, we are able to enable reading from the keyboard. Here is a little more detail about what happens.

The Scanner class usually works by breaking input into tokens that are separated by white space.

Consider the following line:
```
  3 56 a+b   "hi there" -3.2 67a
```

There are seven tokens in this line: three that look like numbers (3, 56, and -3.2), one that looks like an expression (a+b), one that looks like the beginning of a string ("hi), one that looks like the end of a string (there"), and one containing digits and letters (67a).

Here are some methods:

**keyboard.nextInt():** This method calls keyboard.next() to obtain a token, and then it tries to convert the token to an int. The conversion will succeed if the token contains only digits (and perhaps a leading minus sign) and if the value is in the range  -2^31 to 2^31 -1

**keyboard.nextDouble()** This method works in a similar way and returns a double. It will throw an exception if the next token in the input isn’t an int or double.

**keyboard.nextLine():** This method reads characters, up to the next newline character, and returns them as a string. The newline character itself is not placed in the string. This method might have been called nextString().

#### Reading from Files

You can use Scanner objects to read from files. Here’s an example:
```java
Scanner infile = new Scanner(new java.io.FileReader("myfile"));
  int i=infile.nextInt();
  int j=infile.nextInt();
  System.out.println ("Values " + i + " and " + j + " were read.");
```



### Output to files

You can use the print(), println(), and printf() methods to write to a file by using a PrintWriter object. Here’s an example:

```java
import java.io.*;
import java.util.Scanner;
  public class Copy {
    public static void main (String[] args) throws FileNotFoundException {
      Scanner infile = new Scanner(new FileReader("studentlist"));

      PrintWriter outfile = new PrintWriter("myoutfile");
      while (infile.hasNextLine()) {
        String s = infile.nextLine();
        outfile.println(s);
      }
      infile.close();
      outfile.close();
  }
}
```

It is vital to do close() on the PrintWriter when you are done. Failure to do this might mean that the file won’t contain everything that it was supposed to include.


#### Setting the delimiter in file reading

A Scanner usually uses white space (one or more spaces, tabs, and newline char- acters) as the delimiter that is used to separate tokens. Sometimes it is useful to specify a di↵erent choice of delimiter. For example, suppose you are trying to extract words out of a document. You might know that these items should be included as part of the delimiter:

1. Any white space character.
2. These punctuation characters: . , ; :
3. The pattern ---
You can specify the delimiter by writing:
```java
  Scanner infile = new Scanner(new FileReader("myfile"));
  infile.useDelimiter("(\\s|[.,;:]|---)+");
```
After the delimiter pattern is set, calls to infile.next() will yield the desired sequence of words.
