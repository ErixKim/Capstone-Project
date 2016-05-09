import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.lang.Math;
import java.awt.geom.Rectangle2D;
public class Target
{
    private int x;
    private int y;
    private int length;
    private int width;
    private Rectangle square = new Rectangle(0,0,0,0);
    public Target(int x, int y, int length, int width)
    {
        this.x = x;
        this.y = y;
        this.length = length;
        this.width = width;
        square = new Rectangle(this.x, this.y, this.length, this.width);
    }
    public void draw(Graphics2D g2)
    {
        g2.setColor(Color.RED);
        g2.fill(square);
        g2.draw(square);
    }
    public void randomMovement()
    {
        int randNum = (int) Math.random() * 2 + 1;
        if (randNum == 1)
        {
            this.x += 5;
            square = new Rectangle(this.x, this.y, this.length, this.width);
        }
        else
        {
            this.x -= 5;
            square = new Rectangle(this.x, this.y, this.length, this.width);
        }
    }
}
