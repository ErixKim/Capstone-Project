import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.lang.Math;
import java.awt.geom.Rectangle2D;
public class Bullet extends Sprite
{
    private final int BULLET_SPEED = 10;
    private Rectangle bullet = new Rectangle(0,0,0,0);
    public Bullet(int x, int y, int length, int width)
    {
        super(x,y,length,width);
        bullet = new Rectangle(getX(), getY(), getLength(), getWidth());
    }

    public void draw(Graphics2D g2)
    {
        g2.setColor(Color.BLACK);
        g2.fill(bullet);
        g2.draw(bullet);
    }

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
