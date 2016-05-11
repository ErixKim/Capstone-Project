import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.lang.Math;
import java.awt.geom.Rectangle2D;
public class Target extends Sprite
{
    private Rectangle square = new Rectangle(0,0,0,0);
    public Target(int x, int y, int length, int width)
    {
        super(x,y,length,width);
        square = new Rectangle(getX(), getY(), getLength(), getWidth());
    }

    public void draw(Graphics2D g2)
    {
        g2.setColor(Color.RED);
        g2.fill(square);
        g2.draw(square);
    }

    public void randomMovement()
    {
        int x = getX();

        if (getX() < 100)
        {
            for (int i = getX(); i < 500; i += 20)
            {
                setX(x+20);
                square = new Rectangle(getX(), getY(), getLength(), getWidth());
            }
        }
        else if (getX() > 500)
        {
            for (int i = getX(); i > 100; i -= 20)
            {
                setX(x-20);
                square = new Rectangle(getX(), getY(), getLength(), getWidth());
            }
        }
        else
        {
            setX(x+20);
            square = new Rectangle(getX(), getY(), getLength(), getWidth());
        }
    }
}
