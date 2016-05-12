import java.awt.Rectangle;
/**
 * The sprite class is an abstract class that all the visible objects in the game extend to because
 * Sprite is the super class. It has methods that all subclasses and variables declared as those 
 * subclassesare able to use and access.
 * 
 * @author Eric Kim
 * @version 5/11/2016
 */
public abstract class Sprite
{
    //Private instance variables for subclasses of the Sprite class
    private int x;
    private int y;
    private int length;
    private int width;
    //Private instance variable to determine if an object should be visible on the frame
    private boolean isVisible = true;
    
    public Sprite(int x, int y, int length, int width)
    {
        //Sets all the private instance variables to the parameter variables given
        this.x = x;
        this.y = y;
        this.length = length;
        this.width = width;
    }
    
    /**
     * Accessor method to get x
     * @return     x
     */
    public int getX()
    {
        return x;
    }

    /**
     * Accessor method to get y
     * @return     y
     */
    public int getY()
    {
        return y;
    }
    
    /**
     * Accessor method to get length
     * @return     length
     */
    public int getLength()
    {
        return length;
    }

    /**
     * Accessor method to get width
     * @return     width
     */
    public int getWidth()
    {
        return width;
    }
    
    /**
     * Mutator method to change x
     */
    public void setX(int x)
    {
        this.x = x;
    }

    /**
     * Mutator method to change y
     */
    public void setY(int y)
    {
        this.y = y;
    }
    
    public Rectangle getBounds()
    {
        return new Rectangle(x, y, length, width);
    }
    
    public boolean isVisible() {
        return isVisible;
    }

    /**
     * Mutator method to change isVisible
     */
    public void setVisible(Boolean visible) {
        isVisible = visible;
    }
}
