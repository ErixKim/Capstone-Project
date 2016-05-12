import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics;
import java.util.Random;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.Timer;

/**
 * The DrawingPanel class is a subclass of JPanel and it draws most of the objects within the game by
 * calling on an objects draw method. This class contains the keylistener for the movement of a character
 * with arrow keys and it also checks for collisions so it can determine when one object collides with
 * another object.
 * 
 * @author Eric Kim
 * @version 5/11/2016
 */
public class DrawingPanel extends JPanel
{
    //Creates private instance variables declared as their respective classes in order to access them throughout the class
    private Character box;
    private Target target;
    private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    //Private instance variable to count how many times the user pressed r. This will be the reload rate
    private int bulletReloadCount = 10;
    //Private instance variable to count how many bullets the user shot
    private int bulletCount = 0;
    /**
     * Constructor for objects of class DrawingPanel
     */
    public DrawingPanel(Target target, ArrayList<Bullet> bullets)
    {
        //Creates a new Character object with 280,520,20,30 parameters
        box = new Character(280, 520, 20, 30); 
        //Sets the private instance variables to the proper parameter variables
        this.target = target;
        this.bullets = bullets;
        this.setFocusable(true);
        //Adds the key listener to the drawingpanel in order for it to function
        this.addKeyListener(new KeyStrokeListener());
    }

    /**
     * paintComponent is where all the drawing of the characters occurs
     * 
     * @param  Graphics g 
     */
    public void paintComponent(Graphics g)
    {
        //Casts the Graphics object passed in as a parameter to a Graphics g2 object
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        box.draw(g2);
        //if the target's visible variable returns true then it will be drawn. Else it would return false and not be drawn
        if (target.isVisible() == true)
        {
            target.draw(g2);
        }
        else
        {
            target = new Target(0,0,0,0);
        }
        // Iterates through the bullets list
        for (int i = 0; i < bullets.size(); i++)
        {
            //If the bullets visible variable returns true it will be drawn. Else it will return false and not be drawn
            if (bullets.get(i).isVisible() == true)
            {
                bullets.get(i).draw(g2);
            }
            else
            {
                bullets.remove(i);
                if (i != 0)
                {
                    i--;
                }
            }
        }
        //Calls the checkCollisions method to see if any collisions between the objects occurred
        checkCollisions();
        repaint();
    }

    /**
     * moveCharacter method calls the translateCharacter method of the Character class
     * @param dx dy  dx and dy are the numbers passed in from the key listener
     */
    public void moveCharacterBy(int dx, int dy)
    {
        box.translateCharacter(dx, dy);
        repaint();
    }

    /**
     * Shoot Adds the new bullets to the bullets list
     */
    public void Shoot() 
    {
        bullets.add(new Bullet(box.getX() + box.getWidth()/2, box.getY() - box.getLength(), 10, 10));
        repaint();
    }

    /**
     * checkCollisions determines if any of the objects on the frame has collided with each other and changes their visibility to false if they have
     */
    public void checkCollisions()
    {
        //Gets the bounds of the target object by calling the getBounds method on it
        Rectangle target1 = target.getBounds();
        //Iterates through the bullets list
        for (int i = 0; i < bullets.size(); i++)
        {
            //Gets the bounds of the bullet.get(i) object by calling the getBounds method on it
            Rectangle bullet1 = bullets.get(i).getBounds();
            //Checks if the bullet and the target intersect each other
            if (target1.intersects(bullet1))
            {
                //Sets the target and bullet's visibility to false
                target.setVisible(false);
                bullets.get(i).setVisible(false);
                System.out.println("You win!");
                repaint();
            }
        }
    }

    /**
     * The KeyStrokeListener class implements the KeyListener class and it allows the user to use the keyboard
     * and the keystrokelistener class can keep track of what keys are pressed
     * 
     * @author Eric Kim
     * @version 5/11/2016
     */
    class KeyStrokeListener implements KeyListener
    {
        /**
         * keyPressed method determines which keys are pressed and calls certain methods based on which key
         * @param KeyEvent event is how the keylistener is able to detet when a key is pressed
         */
        public void keyPressed(KeyEvent event)
        {
            String key = KeyStroke.getKeyStrokeForEvent(event).toString().replace("pressed ", ""); 
            
            if (key.equals("LEFT"))
            {
                //Calls the moveCharacter method with -5 as dx
                moveCharacterBy(-5, 0);            
            }
            else if (key.equals("RIGHT"))
            {
                //Calls the moveCharacter method with 5 as dx
                moveCharacterBy(5, 0);            
            }
            else if ( key.equals("R"))
            {
                //Adds 1 to the bulletReloadCount variable each time R is pressed
                bulletReloadCount++;
            }
            else if (key.equals("SPACE"))
            {
                if (bulletReloadCount >= 10)
                {
                    //Shoots a bullet if bulletReloadCount is greater than 10
                    bulletReloadCount = 0;
                    bulletCount++;
                    //Calls the shoot method
                    Shoot();
                }
                if (bulletCount >= 5 && target.isVisible() == true)
                {
                    System.out.println("Game Over! You couldn't hit the target within 5 bullets!");
                }
            }

        }

        public void keyTyped(KeyEvent event) {}

        public void keyReleased(KeyEvent event) {}
    }
}
