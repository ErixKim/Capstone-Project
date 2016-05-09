import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.Rectangle2D;
public class Character
{
    private int x = 0;
    private int y = 0;
    private int length = 0;
    private int width = 0;
    private Rectangle rect = new Rectangle(0,0,0,0);
    public Character(int x, int y, int length, int width)
    {
        this.x = x;
        this.y = y;
        this.length = length;
        this.width = width;
        rect = new Rectangle(this.x, this.y, this.length, this.width);
    }
    public void draw(Graphics2D g2)
    {
        g2.setColor(Color.GREEN);
        g2.fill(rect);
        g2.draw(rect);
    }
    public void translateCharacter(int dx, int dy)
    {
        this.x += dx;
        rect = new Rectangle(this.x, this.y, this.length, this.width);
    }
        
}
