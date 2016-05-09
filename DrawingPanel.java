import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import javax.swing.JColorChooser;
import java.awt.geom.Point2D;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
/**
 * 
 * @author Eric Kim
 * @version 
 */
public class DrawingPanel extends JPanel
{
    private Character box;
    private Target target;
    private Bullet bullet;
    /**
     * Constructor for objects of class DrawingPanel
     */
    public DrawingPanel()
    {
        box = new Character(280, 520, 20, 30); 
        target = new Target(300,50, 30, 30);
        bullet = new Bullet(280, 500, 10,10);
        this.setFocusable(true);
        this.addKeyListener(new KeyStrokeListener());
    }

    /**
     * paintComponent is where all the drawing of the shapes in shapeList occurs
     * 
     * @param  Graphics g
     */
    public void paintComponent(Graphics g)
    {
        //Casts the Graphics object passed in as a parameter to a Graphics g2 object
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        box.draw(g2);
        target.draw(g2);
        bullet.draw(g2);
        repaint();
    }

    public Target getTarget()
    {
        return target;
    }

    public void moveCharacterBy(int dx, int dy)
    {
        box.translateCharacter(dx, dy);
        repaint();      
    }

    public void shootBullets()
    {

    }

    class KeyStrokeListener implements KeyListener
    {
        public void keyPressed(KeyEvent event) 
        {
            String key = KeyStroke.getKeyStrokeForEvent(event).toString().replace("pressed ", ""); 

            if (key.equals("LEFT"))
            {
                moveCharacterBy(-5, 0);            
            }
            else if (key.equals("RIGHT"))
            {
                moveCharacterBy(5, 0);            
            }
            else if (key.equals("SPACE"))
            {

            }
        }

        public void keyTyped(KeyEvent event) {}

        public void keyReleased(KeyEvent event) {}
    }
}

