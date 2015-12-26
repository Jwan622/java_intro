/* Java is a strong typed language, which means variables need to be defined before we use them.

*/

int myNumber;
myNumber = 5;

int myNumber = 5;


/* let's define a floating point number */

double d = 4.5;
d = 3.0;

float f = (float) 4.5;
/* or */
float f = 4.5f

char c = 'g';

// String is not a primitive but it is a real type.
String s1 = new String("Who let the dogs out?");
// Just using "" also craetes a string
String s2 = "Hi there";
// Java also has + as a string concatenator
String s3 = s1 + s2;


// There is no operator overloading in Java! The operator + is only defined for strings, you will neer
// see it with other objects, only primitives.

int num = 5;
String s = "I have " + num + " cookies";

boolean b = false;
b = true;

boolean toBe = false;
b = toBe || !toBe;
if (b) {
  System.out.println(toBe);
}

/*
int children = 0;
b = children; //will not work
if (children) { // Will not work

}
*/
