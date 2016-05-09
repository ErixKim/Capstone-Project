import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.lang.Math;
import java.awt.geom.Rectangle2D;
public class Bullet
{
    private int x;
    private int y;
    private int length;
    private int width;
    private Rectangle bullet = new Rectangle(0,0,0,0);
    
    public Bullet(int x, int y, int length, int width)
    {
        this.x = x;
        this.y = y;
        this.length = length;
        this.width = width;
        bullet = new Rectangle(this.x,this.y,this.length,this.width);
    }
    public void draw(Graphics2D g2)
    {
        g2.setColor(Color.BLACK);
        g2.fill(bullet);
        g2.draw(bullet);
    }
}
