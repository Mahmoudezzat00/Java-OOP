Programming Languages (BSc, 18) Java, 3rd lab:

Task 1:
-------
Reorganize the code of class Point and the corresponding main program as produced in the previous lab. In the reorganized code, those classes should go to the point2d package. Ensure that the Point class is not visible from outside of its package. The Point class and the main program should be written as two compilation units.

Task 2:
-------
Change the code produced in Task 1 in a way that the main program goes into different package, pointm.

Task 3:
---------
a
Create a Circle class to represent a circle. A circle has a center (x, y are double, initialise to 0), and a radius (also double, initialise to 1). Write a getArea() method returing the area of the circle. Create an instance of the Circle class, write its area to the screen, set the center to (5, 2), radius to 10, then write again its area to the screen.

b
Modify the code for task a in such a way that the data fields are only accessible via a getter/setter. Throw IllegalArgumentException if the radius is 0 or negative.

c
Modify the code for task b in such a way that the data fields are initialised by a constructor.

Task 4:
-------
a
Create a package circle and its sub-package utils. Class Point should now be put into this circle.utils package. Create the circle.Circle class, which stores the radius of the circle (double) and the center of the circle (x, y fields).

Write a getCenter() method for circle.Circle returning the center as circle.utils.Point. Create a main program as class circle.Main.

b
Modify the code for task a in such a way that circle.utils.Point use setters methods to modify its fields instead of constructor.

Task 5:
------
Create a class stringutils.IterLetter. Its constructor expects a String reference. (Make sure that your code handles the case when this reference is null.) Create a method printNext() in this class, which prints the next unprinted letter of the initialising string in a new line on the standard output. (The first call of the method prints the first letter, the second call prints the second letter, and so on).

After all the letters of the string have been printed, the printNext() method should not print anything anymore.

The class should have a restart() method, which can be used to re-initiate the printing functionality. After restart(), the stringutils.IterLetter object should print the first letter of the initialising string for the following printNext() method.

Finally, add a hasNext() method, which returns true if (and only if) there are letters to be printed in the string.

Create a main program in Main in the anonymous package. The main program should instantiate class stringutils.IterLetter, and illustrates its use.

Exercise 1:
------------
Create a class Kangaroo representing kangaroos. This class should have two fields: one represents the name (String) and the other the age (int) of the animal.

The constructor of the class takes two parameters, corresponding to the two fields. The class should contain a method display(String), which takes the name of a country as parameter, and does the following: it prints the name of the kangaroo, as well as the name of the country; then it increases the age of the kangaroo by one, and prints the new age.

Exercise 2:
-----------
Add a stringutils.IterWord class to the stringutils package. The constructor in this class takes a string as parameter. The printNext() method prints the next word of this string to the standard output (in a new line). The class whould have a restart() and a hasNext() method as well. Create a main program to illustrate the use of the class!

Exercise 3
Create a class Book representing a book in a library. A book has a title (String), an author (String), a field to store the year when it was published (int), a field for the number of pages (int), and a logical value describing whether the book can be borrowed.

Create a constructor which requires all the above attributes of a book. Create another constructor which takes a Book reference as parameter. (Do not forget about the case when the parameter is null.)

Create a method toString() to convert the book data into a String. Create a sameAs(Book) method which returns true if the parameter book has the same title, author, year and pages as the current book. (Whether the books can be borrowed does not matter when comparing them.)

Create a main program to illustrtate the use of the class. Put all classes into the package library.

Exercise 4
Create the class game.utils.Vehicle, which represents a vehicle in a multi-player game. Such a vehicle has a model id (int), a registration number (String) and two colors: color1 and color2 of type int. Create getter and setter for the registration number.

Create a class game.Player representing a player in a multi-player game. A player has a name (String), an IP-address (String), an integer value describing their health, and their vehicle (of type game.utils.Vehicle). If the player has no vehicle, a null reference should be stored.

Create the toString() method in the game.Player class to convert player data to string, including the name, the IP-address, health status, and -- if they have a vehicle -- the registration number of the vehicle.

Create the main program in the class game.Main, which instantiates three vehicles and two players. One of the players should own a vehicle. The program should print the players' data on the screen.

Exercise 5
Create a Segment class to represent a segment. A segment contains the double x and y coordinates of the two endpoint of a segment: x1, y1, x2 and y2. We want to work with real segments, so (x1,y1) and (x2,y2) shouldn't be the same points.

Use data hiding in you solution, and write proper constructor and setter methods. Create a midpoint() method to the Segment class returning the midpoint for a segment as Point.