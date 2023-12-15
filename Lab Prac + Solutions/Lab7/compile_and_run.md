Task 1:
--------
Using SingleLineFileStructureTest, create text.to.numbers.SingleLineFile.addNumbers() that takes a file name and returns the sum of the numbers on the first line.

If the file doesn’t exist, let the IOException propagate outside the method.
If the file is empty, throw an IllegalArgumentException with the message Empty file.
For each word on the first line that does not represent an int, print it on System.err. This is usable in the same way as System.out.
Make sure that you properly close the input using try-with-resources once you’re done.

Create a tester with the following test cases.

Test the two cases where exceptions are thrown.
In the tester method, simply catch the exception.
If no exception is caught, use fail(). You may give it a message, too.
Use e.getMessage() to get the error message in the second case.
Note: there is also an assertThrows() method in JUnit which is even better, but it is more advanced.
Also use a valid file with 1 2 not text 3 -123 on its first line.
We don’t test printouts to the standard output/error stream using JUnit, but the printouts should be there.
Note: these are not proper unit tests, because they use the file system.


Compile & run:
--------------
javac -cp .;junit5all.jar;checkthat.jar text\to\numbers\SingleLineFileTest.java

java -jar junit5all.jar --disable-banner --disable-ansi-colors -cp . -cp checkthat.jar -c text.to.numbers.SingleLineFileTest


