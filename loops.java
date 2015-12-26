public class loops {
  public static void main(String[] args){
    int[] arr = {1,9,95};
    for (int i = 0; i < arr.length; i++){
      int el = arr[i];
      System.out.println(el);
    }
    //or this shorter way below. But if you want to get the index, you need to use the above longer way.

    int[] arr1 = {1,9,98};
    for (int el : arr) {
      System.out.println(el);
    }

    // this below is a regular for loop
    for (int i = 0; i< 3; i++) {

    }

    //using break and continue
    // break causes the loop to stop and go onto the next statement after the loop
    // this following code should print "Yuhu" twice and then 2.

    int j;
    for (j = 0; j < 5; j++) {
      if (j>=2) {
        break;
      }
      System.out.println("Yuhu");
    }
    System.out.println(j);

    //continue will stop the current iteration and will move to the next one. Notice that inside the loop
    // it will still run the third iteration.

    int i;
    for (i = 0; i < 5; i++) {
      if (i >= 3) {
        break;
      }
      System.out.println("Yuhu");
      if (i>=1) {
        continue;
      }
      System.out.println("Tata");
    }
    System.out.println(i);
  }
}
