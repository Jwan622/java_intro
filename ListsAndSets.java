/* List and Set both are interfaces. They both extends Collection interface.
In this post we are discussing the differences between List and Set interfaces in java.
*/

/* 1. List is an ordered collection it maintains the insertion order, which means
upon displaying the list content it will display the elements in the same order
in which they got inserted into the list. Set is an unordered collection, it
doesn’t maintain any order. There are few implementations of Set which
maintains the order such as LinkedHashSet (It maintains the elements in insertion order).

2) List allows duplicates while Set doesn’t allow duplicate elements. All the
elements of a Set should be unique if you try to insert the duplicate element in
Set it would replace the existing value.

3) List allows any number of null values. Set can have only a single null value at most.



If the requirement is to have only unique values then Set is your best bet as any implementation of Set maintains unique values only.
If there is a need to maintain the insertion order irrespective of the duplicity then List is a best option.
*/


// Here is a List Example
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

public class ListsAndSets {
  public static void main(String[] args) {
    List<String> al = new ArrayList<String>();
    al.add("Chaitanya");
    al.add("Rahul");
    al.add("Ajeet");
    System.out.println("ArrayList Elements: ");
    System.out.print(al);

    List<String> ll = new LinkedList<String>();
    ll.add("Kevin");
    ll.add("Peter");
    ll.add("Kate");
    System.out.print("\nLinkedList Elements: ");
    System.out.println(ll);

    int count[] = {11, 22, 33, 44, 55};
    Set<Integer> hset = new HashSet<Integer>();
    try{
      for(int i = 0; i<4; i++){
        System.out.println(count[i]);
        hset.add(count[i]);
      }
      System.out.println(hset);

      TreeSet<Integer> treeset = new TreeSet<Integer>(hset);
      System.out.println("The sorted list is:");
      System.out.println(treeset);
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
}
