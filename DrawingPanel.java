import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics;
import java.util.Random;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.Timer;

/**
 * 
 * @author Eric Kim
 * @version 
 */
public class DrawingPanel extends JPanel
{
    private Character box;
    private Target target;
    private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    private int bulletReloadCount = 10;
    private int bulletCount = 0;
    /**
     * Constructor for objects of class DrawingPanel
     */
    public DrawingPanel(Target target, ArrayList<Bullet> bullets)
    {
        box = new Character(280, 520, 20, 30); 
        this.target = target;
        this.bullets = bullets;
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
        if (target.isVisible() == true)
        {
            target.draw(g2);
        }
        else
        {
            target = new Target(0,0,0,0);
        }
        for (int i = 0; i < bullets.size(); i++)
        {
            if (bullets.get(i).isVisible() == true)
            {
                bullets.get(i).draw(g2);
            }
            else
            {
                bullets.remove(i);
                if (i != 0)
                {
                    i--;
                }
            }
        }
        checkCollisions();
        repaint();
    }

    public void moveCharacterBy(int dx, int dy)
    {
        box.translateCharacter(dx, dy);
        repaint();
    }

    public void Shoot() 
    {
        bullets.add(new Bullet(box.getX() + box.getWidth()/2, box.getY() - box.getLength(), 10, 10));
        repaint();
    }

    public void checkCollisions()
    {
        Rectangle target1 = target.getBounds();
        for (int i = 0; i < bullets.size(); i++)
        {
            Rectangle bullet1 = bullets.get(i).getBounds();
            if (target1.intersects(bullet1))
            {
                target.setVisible(false);
                bullets.get(i).setVisible(false);
                System.out.println("You win!");
                repaint();
            }
        }
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
            else if ( key.equals("R"))
            {
                bulletReloadCount++;
            }
            else if (key.equals("SPACE"))
            {
                if (bulletReloadCount >= 10)
                {
                    bulletReloadCount = 0;
                    bulletCount++;
                    Shoot();
                }
                if (bulletCount >= 5 && target.isVisible() == true)
                {
                    System.out.println("Game Over! You couldn't hit the target within 5 bullets!");
                }
            }

        }

        public void keyTyped(KeyEvent event) {}

        public void keyReleased(KeyEvent event) {}
    }
}
