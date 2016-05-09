import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.Rectangle2D;
public class Target
{
    private int x;
    private int y;
    private int length;
    private int width;
    private Rectangle2D.Double square;
    public Target(int x, int y, int length, int width)
    {
        this.x = x;
        this.y = y;
        this.length = length;
        this.width = width;
        Rectangle2D.Double square = new Rectangle2D.Double(this.x, this.y, this.length, this.width);
    }
    public void draw(Graphics2D g2)
    {
        Rectangle2D.Double square = new Rectangle2D.Double(this.x, this.y, this.length, this.width);
        g2.setColor(Color.RED);
        g2.fill(square);
        g2.draw(square);
    }
}
