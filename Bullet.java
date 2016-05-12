import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.lang.Math;
import java.awt.geom.Rectangle2D;
/**
 * The Bullet class is a subclass of the abstract class Sprite and it constructs a rectangle thats
 * based off of the given x and y coordinates and length and width. It uses methods from the super class
 * Sprite in order to function other methods. The bullet object will move by changing its y axis whenever
 * the move method is called.
 * 
 * @author Eric Kim
 * @version 5/11/2016
 */
public class Bullet extends Sprite
{
    //Private instance variable that is a constant for the bullet speed
    private final int BULLET_SPEED = 2;
    //Private instance variable for the bullet
    private Rectangle bullet = new Rectangle(0,0,0,0);
    public Bullet(int x, int y, int length, int width)
    {
        //Calls the super class' constructor to set x,y,length,width
        super(x,y,length,width);
        //Creates a new rectangle with the new coordinates and sizes
        bullet = new Rectangle(getX(), getY(), getLength(), getWidth());
    }

    /**
     * draw method to draw the objects onto the frame
     * param Graphics2D g2 allows for the drawing to happen
     */
    public void draw(Graphics2D g2)
    {
        g2.setColor(Color.BLACK);
        g2.fill(bullet);
        g2.draw(bullet);
    }

    /**
     * move method allows the bullet to move on the screen
     */
    public void move()
    {
        int y = getY();
        setY(y - BULLET_SPEED);
        bullet = new Rectangle(getX(), getY(), getLength(), getWidth());
        if (bullet.getY() < 0)
        {
            setVisible(false);
        }
    }
}
