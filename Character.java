import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.Rectangle2D;
public class Character extends Sprite
{
    private Rectangle rect = new Rectangle(0,0,0,0);
    public Character(int x, int y, int length, int width)
    {
        super(x,y,length,width);
        rect = new Rectangle(getX(), getY(), getLength(), getWidth());
    }

    public void draw(Graphics2D g2)
    {
        g2.setColor(Color.GREEN);
        g2.fill(rect);
        g2.draw(rect);
    }

    public void translateCharacter(int dx, int dy)
    {
        int x = getX();
        if (getX() > 0 && getX() < 560)
        {
            setX(x+dx);        
            rect = new Rectangle(getX(), getY(), getLength(), getWidth());
        }
        else
        {
            setX(280);
            rect = new Rectangle(getX(), getY(), getLength(), getWidth());
        }
    }
}
