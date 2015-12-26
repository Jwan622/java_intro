public class Conditionals {
  public static void main(String[] args) {
    int a = 4;
    boolean b = a ==4;

    if (b) {
      System.out.println("It's true!");
    }

    // or just write this instead. you need to use a different variable in java if you resassign a value.
    int c = 5;
    if (c == 5) {
      System.out.println("Ohhh So a is 4!");
    }

    if (c ==6) {
      System.out.println("a is equal to 6");
    } else {
      System.out.println("a is not equal to 6");
    }

    // java has ternaries
    int d = 4;
    int result = d == 4 ? 1 : 8;
    System.out.println(d);
    // result should be 1

    /* The ternary is equiv to
    if (d == 4) {
      result = 1;
    } else {
      result = 8;
    }
    */

  }
}
