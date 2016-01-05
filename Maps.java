/*
A Map is an object that maps keys to values. A map cannot contain duplicate
keys: Each key can map to at most one value. The Map interface includes methods
for basic operations (such as put, get, remove, containsKey, containsValue,
size, and empty), bulk operations (such as putAll and clear), and collection
views (such as keySet, entrySet, and values).

The Java platform contains three general-purpose Map implementations: HashMap, TreeMap, and LinkedHashMap.
*/
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

public class Maps {
  public static void main(String[] args) {
    Map mapA = new HashMap();
    Map mapB = new TreeMap();

    mapA.put("key1", "element 1");
    mapA.put("key2", "element 2");
    mapA.put("key3", "element 3");

    // The three put() calls maps a string value to a string key. You can then
    // obtain the value using the key. To do that you use the get() method like this:

    String element1 = (String) mapA.get("key1");
    // why do I need the type cast on the right?
    System.out.println(element1);

    // Lets iterate through the keys of this map:

    Iterator iterator = mapA.keySet().iterator();
    System.out.println(iterator);  // How to inspect this? Is it a kind of map?

    Map mapC = new HashMap();
    while(iterator.hasNext()){
      Object key   = iterator.next();
      Object value = mapA.get(key);
      mapC.put(key,value);
    } // Is there a better way to take the contents of the iterator and put them in a new map?
    System.out.println(mapC);
    //create a new hashmap
    HashMap hm = new HashMap();
    // put elements to the map

    hm.put("Zara", new Double(3434.34));
    hm.put("Mahnaz", new Double(123.22));
    hm.put("Ayan", new Double(1378.00));
    hm.put("Daisy", new Double(99.22));
    hm.put("Qadir", new Double(-19.08));

    //get a set of the entries
    // The entrySet( ) method declared by the Map interface returns a Set containing the
    // map entries.

    Set set = hm.entrySet();

    // get an iterator
    Iterator i = set.iterator();

    // Display elements

    while(i.hasNext()) {
      Map.Entry me = (Map.Entry)i.next();
      System.out.println(i.getClass());  // get the class of i
      System.out.println(i instanceof Iterator); // checks to see if i is of class Iterator
      System.out.print(me.getKey() + ": ");
      System.out.println(me.getValue());
    }
    System.out.println();
    // Deposit 1000 into Zara's account
    double balance = ((Double)hm.get("Zara")).doubleValue();
    hm.put("Zara", new Double(balance + 1000));
    System.out.println("Zara's new balance: " +
      hm.get("Zara"));
  }
}
