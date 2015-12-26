/* so foo is a method that we define in class functions. Notice a few things about foo:
- static means that the method belongs to the class functions and not to a specific instance of class functions. From a
different class you can call it via functions.foo
- void means that the method doesn't return anything. methods can return a single value in java.
- the method doesn't take any arguments.
*/

// public class functions {
//
//
//     public static void foo() {
//       System.out.println("inside functions class inside method foo");
//     }
//
//     /* arguments to java methods are passed by value, although some may disagree with that wording.
//     "by value" means that the arguments are copied when the method runs. Let's see:
//     */
//     public void bar (int num1, int num2) {
//
//     }
//
//     /* if later on the code this code is run: */
//
//     int a = 1;
//     int b = 2;
//     bar(a,b);
// }
//     /* So this is almost like at the beginning of the function bar, the following two lines are written:
//     int num1 = a;
//     int num2 = b;
//
//     Only then is the rest of the method run.
//     This means that the "value" of a gets copied to num1 and the b value gets copied to num2. Changing the values of
//     num1 and num2 won't affect a and b.
//
//
//     The rules if the arguments were objects are similar. Imagine if this were our function:
//     public void bar2(Student s1, Student s2) {
//
//     }
//
//     Here's how we'd use the code:
//     Student joe = new Student("joe");
//     Student jack = new Student("jack");
//     bar2(joe, jack);
//
//     Again we can picture the same two lines in the beginning of bar2
//     Student s1 = joe;
//     Student s2 = jack;
//
//     But assigning objects, it's different than when we assign primitives. s1 and joe here are two different
//     references to the same object. s1 == joe is true here. Running methods on s1 will change joe. But if we'll change the
//     value of s1 as a reference, it will not affect the reference joe.
//
//     s1.setName("Chuck") //joe will also be named Chuck
//     s1 = new Student("Norris") // s1 is a new student, different than joe with the name of Norris
//     s1 == joe is not true anymore
//
//     */
//
//     /* Non-static methods are used more than static methods in java. These methods can only be run on objects and not
//     on the whole class.
//
//     Non-static methods can alter the field on the object.
//     */
//
//     public class Student {
//       private String name;
//       public String getName() {
//         return name;
//       }
//       public void setName(String name) {
//         this.name = name;
//       }
//     }
//
//     // calling these methods will require an object of type Student
//     Student s = new Student();
//     s.setName("Danielle");
//     String name = s.getName();
//     System.out.println(name);
// }

class Student {
    private String firstName;
    private String lastName;
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public void printFullName() {
      System.out.println(this.firstName + " " + this.lastName);
    }
}

public class functions {
    public static void main(String[] args) {
        Student[] students = new Student[] {
            new Student("Morgan", "Freeman"),
            new Student("Brad", "Pitt"),
            new Student("Kevin", "Spacey"),
        };
        for (Student s : students) {
            s.printFullName();
        }
    }
}
