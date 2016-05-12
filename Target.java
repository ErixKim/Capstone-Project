import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.lang.Math;
import java.awt.geom.Rectangle2D;
/**
 * The Target class is a subclass of the Sprite class and it creates a new rectangle based off of the given
 * x and y coordinates and length and widths. It does this by calling its superclass' constructor. 
 * 
 * @author Eric Kim
 * @version 5/11/2016
 */
public class Target extends Sprite
{
    //Private instance variable to create a new rectangle object
    private Rectangle square = new Rectangle(0,0,0,0);
    public Target(int x, int y, int length, int width)
    {
        //Call the super class' constructor in order to initialize the x, y, length, width variables
        super(x,y,length,width);
        //Creates a new rectangle by using the superclass' methods in order to get the x, y, length, and width
        square = new Rectangle(getX(), getY(), getLength(), getWidth());
    }

    /**
     * draw method allows the Character to be drawn onto the frame
     * @param Graphics2D g2    g2 allows the objects to be drawn
     */
    public void draw(Graphics2D g2)
    {
        g2.setColor(Color.RED);
        g2.fill(square);
        g2.draw(square);
    }

    /**
     * movement method moves the target right constantly and when its out of the screen on the right side
     * it goes back to the left
     */
    public void movement()
    {
        int x = getX();
        if (getX() > 570)
        {
            for (int i = getX(); i > 0; i -= 2)
            {
                //Sets the x instance variable of this object to the current x amount - 2
                setX(getX() - 2);
                square = new Rectangle(getX(), getY(), getLength(), getWidth());
            }
        }
        else
        {
            //Sets the x instance variable of this object to the current x amount + 2
            setX(getX() + 2);
            square = new Rectangle(getX(), getY(), getLength(), getWidth());
        }
    }
}
