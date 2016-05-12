------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: Hit the Target Capstone Project
PURPOSE OF PROJECT: Hit the target with the bullets shot by the moving character
VERSION or DATE: 5/11/2016
HOW TO START THIS PROJECT: Run the main method of the drawing editor class
AUTHORS: Eric Kim
USER INSTRUCTIONS:
- Run the main method of the Drawing Editor class in order to get the frame and characters drawn
- Use the arrow keys on the keyboard in order to move the character on the bottom of the screen
- Press space bar in order to shoot (need to reload first)
- Press r 10 times in order to reload and be able to shoot again with spacebar
- Try and hit the target within 5 bullets because then a message saying "Game Over!" will show up in a different window
- Good Luck!


Overview of Capstone:
- This capstone is a game in which a rectangle character shoots and attempts to hit a moving rectangle target with a 
constant pattern on the opposite side of the frame. The rectangle character has to hit the target within 5 bullets or else
he loses, but if he hits the target, then he wins. 

Explanation of Capstone Synthesization: 
This capstone incorporates subclasses and super classes that are abstract because their was a lot of inheritance and the Sprite class is an abstract/super class
with three subclasses extending to it. The subclasses uses the super method in order to call the super class' constructor and
they also use the super class' methods in order to access the private instance variables. I also used the paint component method
which takes in a parameter of g2 and draws the objects onto a canvas instance variable which is added onto the frame. 
In order to maintain multiple bullets present in the frame, I needed to create an arrayList<Bullet> and add each bullet shot
into that list. Also, I had to know how to iterate through the lists with for loops and then get each element of the list
and modify it. Some other concepts we've learned in class that I used for this capstone is the JFrame and JPanel classes and
creating a new frame to add all the drawings and objects into. Many of our projects in this semester used the rectangle class and its methods
which I used for the majority of my sprite objects. Also, some of the concepts I had to look up for in order to 
do was in the DrawingPanel class, I had to create a key listener which uses events in order to detect when a certain key 
is pressed by the user. As a class we've done other listeners, but never a key listener which was different. Another concept
I had to look up was a clock class because we have never done that in class either. The clock class is a subclass of the 
TimerTask class and it is able to call another class' methods repeatedly in set intervals of time and speed. This clock 
class is the reason why all of my animations for the target and bullets work. Also, I needed to look up how to create a
collision detector in order to determine when the bullet hits the target.

Resources to help me in this process:
http://zetcode.com/tutorials/javagamestutorial/collision/ - Used this to help structure certain methods such as the collisionChecker method
