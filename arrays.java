public class arrays {
  public static void main(String[] args) {
    int[] arr;
    arr = new int[10];

    System.out.println(arr.length);

    arr[0] = 4;
    arr[1] = arr[0] + 5;

    System.out.println(arr[1]);

    int[] arr1 = new int[5];
    arr1[4] = 4;

    System.out.println(arr1[4]);

    int[] arr2 = {1,2,3,4,5};

    System.out.println(arr2[0]);

    // this line outputs something funny... pointer in memory perhaps?
    System.out.println(arr2);
  }
}
