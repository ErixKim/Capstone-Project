import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.Rectangle2D;
public class Character
{
    int x = 0;
    int y = 0;
    int length = 0;
    int width = 0;
    public Character(int x, int y, int length, int width)
    {
        this.x = x;
        this.y = y;
        this.length = length;
        this.width = width;
        Rectangle2D.Double rect = new Rectangle2D.Double(this.x, this.y, this.length, this.width);
    }
    public void draw(Graphics2D g2)
    {
        Rectangle2D.Double rect = new Rectangle2D.Double(x,y,length,width);
        g2.draw(rect);
    }
}
