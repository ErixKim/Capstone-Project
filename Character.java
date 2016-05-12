import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.Rectangle2D;
/**
 * The Character class is a subclass of the Sprite class because it utilizes certain methods
 * from the Sprite class. This class creates a rectangle based off of the given x and y coordinates
 * and length and widths by calling its super class' constructor.
 * 
 * @author Eric Kim
 * @version 5/11/2016
 */
public class Character extends Sprite
{
    //Private instance variable in order to create a new rectangle
    private Rectangle rect = new Rectangle(0,0,0,0);
    public Character(int x, int y, int length, int width)
    {
        //Calls the super class' constructor with the x y length and width parameter variables
        super(x,y,length,width);
        //Creates a new rectangle with the new coordinates and sizes
        rect = new Rectangle(getX(), getY(), getLength(), getWidth());
    }

    /**
     * draw method allows the Character to be drawn onto the frame
     * @param Graphics2D g2    g2 allows the objects to be drawn
     */
    public void draw(Graphics2D g2)
    {
        g2.setColor(Color.GREEN);
        g2.fill(rect);
        g2.draw(rect);
    }

    /**
     * translateCharacter method oves the character
     * @param dx and dy     dx and dy are the amount the character moved based on the key listener
     */
    public void translateCharacter(int dx, int dy)
    {
        int x = getX();
        if (getX() > 0 && getX() < 560)
        {
            //Setting the x instance variable of this object to x + the number dx is
            setX(x+dx);        
            rect = new Rectangle(getX(), getY(), getLength(), getWidth());
        }
        else
        {
            //Sets the x instance variable of this object to 280
            setX(280);
            rect = new Rectangle(getX(), getY(), getLength(), getWidth());
        }
    }
}
