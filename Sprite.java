import java.awt.Rectangle;
/**
 * Write a description of class Sprite here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Sprite
{
    private int x;
    private int y;
    private int length;
    private int width;
    private boolean isVisible;
    public Sprite(int x, int y, int length, int width)
    {
        this.x = x;
        this.y = y;
        this.length = length;
        this.width = width;
    }
    
    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }
    
    public int getLength()
    {
        return length;
    }

    public int getWidth()
    {
        return width;
    }
    
    public void setX(int x)
    {
        this.x = x;
    }

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

    public void setVisible(Boolean visible) {
        isVisible = visible;
    }
}
