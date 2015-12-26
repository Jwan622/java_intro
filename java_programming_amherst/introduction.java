/* This language was developed in the early 1990s by Sun Microsystems, and it has received
much attention because it facilitates development of graphical, interactive web pages in a
way that is largely independent of particular hardware.

Programming is essentially the task of problem solving.

Programming is also a good way to begin learning about the field of computer science, which examines the ways data
can be organized and manipulated. Com- puter scientists study questions such as:
What problems have efficient solutions? What problems will never be solved by computers?
How can hardware and software work together in a multiprocessor system?
Can we write programs that are provably correct?
What computer language features will allow programmers to think in useful new ways?
How can we quickly search vast sets of possibilities (such as in chess) without making too many mistakes?
How can we write programs that essentially allow machines to learn on their own?


There are two kinds of Java programs, applets and applications.

** Applets **
-Applets are graphical programs that interact with users via menus, buttons, scrollbars, text fields, and similar features.
-Sometimes applets use animation.
-applets are very similar to the kind of program that runs on a computer with one big difference: applets can be
incoroporated into a web page. When a user visits a web page with an applet, the applet is loaded onto the user's machine and runs.

** applications **
-programs designed to run locally on the computer without the use of a browser.
-Some applications use graphics while others use a simpler approach in which the user and computer interact by typing
in a window or a CLI.
-Until about 1980, almost all programs used a command line interface.
-Once you have a working application, you can add graphics or even turn your program into an applet.


** computer **
There are 3 essential elements to a computer.
1. the memory
2. devices
3. processor

1. Memory
- Computers depend on their ability to manipulate large amounts of information.
When you run a program, part of the computer’s memory is used to hold
data,the information being manipulated,
and part of the memory is used to hold instructions, which is how the data should be used.
- For example, if you are using a word processor,
the computer’s memory probably holds both your document and the word processing program itself.

2. Devices:
- Devices allow the computer to interact with the outside world.
Typical devices include the keyboard, mouse, and screen. Without such devices, the computer would be useless.
- Hard disks and removable disks are also devices.
Disks are usually much larger and slower than the ordinary memory and are used for longer-term storage of information.

3. Processor:
- The processor is the heart of the computer.
- It is a unit that can loads instructions and data from memory and that can execute the instructions.
- There are many kinds of instructions; among the most important are ones that specify that an operation such as addition should be performed, ones that tell how information should be moved to or from memory, and ones that make decisions about what the processor should do next.
- Together, these instructions allow the computer to do long calculations without human intervention.

- Writing programs in machine code, the real language used by computers, is painful.
- Consider the example in Figure 1.2, which is shown in assembly language, a human-readable form of machine code.
- In the early days of computers, all pro- grams were written using this kind of language, easily understood by computers but di cult for people. Eventually high-level languages were developed to permit people to express their ideas more easily.
- Fortran, COBOL, Pascal, Ada, C, C++, Lisp, and Java are all examples of high-level languages.
- Special programs called compilers are used to convert programs in high-level languages to the low-level machine code required by computers.



** Creating a java program **
Java is much simpler to read than the one in assembly language.
There are 3 main steps in creating a java program: editing, compiling, and running.
- Begin by using an editor to enter the program and save it to a file on your computer's disk.
- The .java suffix indicates that the file contains a Java program.
- After you've saved your program, you compile it to produce a .class file. The .class file contains Java virtual machine code, a form of machine code
- Once you’ve created the .class file, your program is ready to run. You run your program by using the Java virtual machine. The virtual machine, which is itself a program, carries out the instructions in your program.
- there is also debugging. If there are errors in your program, you will need to go back and fix the .java file, and then recompile and rerun.
- Other students use an IDE, an integrated development environment, such as Eclipse.


** Algorithms **
- Programs are based on algorithms, methodical strategies for solving problems.
Algorithms need not be expressed in a particular computer language, but they must be clear and unambiguous.

- Suppose someone tells you that they’ve chosen a number between 1 and 100 and asks you to guess it.
When you make a guess, they’ll tell you if you’ve found the number, if you’re high, or if you’re low.
