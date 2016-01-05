import java.util.Arrays;
import java.util.List;

public class ArrayDemo1 {
  public static void main (String args[]) {

  // create an array of strings
    String a[] = new String[]{"abc","klm","xyz","pqr"};

    List list1 = Arrays.asList(a);

    // printing the list
    System.out.println("The list is:" + a);

    /* JDK 1.5 introduced a new for loop known as foreach loop or enhanced for loop,
    which enables you to traverse the complete array sequentially without using an index variable.
    */

    double[] myList = {1.9, 2.9, 3.4, 3.5};

    // Print all array elements
    for (double element: myList) {
      System.out.println(element);
    }

    //reversing array and inspecting it using Arrays.toString()

    int[] array1 = new int[] {1,2,3,4};
    int[] reversed_array = ArrayDemo1.reverse(array1);
    for (int i=0; i < reversed_array.length; ++i) {
      System.out.println(reversed_array[i]);
    }
    System.out.println(Arrays.toString(reversed_array));
  }

  public static int[] reverse(int[] list) {
    int[] result = new int[list.length];

    for (int i = 0, j = result.length - 1; i < list.length; i++, j--) {
      result[j] = list[i];
    }
    return result;
  }
}
