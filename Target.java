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
        int randNum = (int) Math.random() * 1;
        if (randNum == 1)
        {
            setX(x+15);
            square = new Rectangle(getX(), getY(), getLength(), getWidth());
        }
        else
        {
            setX(x-15);
            square = new Rectangle(getX(), getY(), getLength(), getWidth());
        }
    }
}
