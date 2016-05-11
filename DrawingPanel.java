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
                repaint();
            }
        }
    }

    class KeyStrokeListener implements KeyListener
    {
        public void keyPressed(KeyEvent event)
        {
            //             String key = KeyStroke.getKeyStrokeForEvent(event).toString().replace("pressed ", ""); 
            // 
            //             if (key.equals("LEFT"))
            //             {
            //                 moveCharacterBy(-5, 0);            
            //             }
            //             else if (key.equals("RIGHT"))
            //             {
            //                 moveCharacterBy(5, 0);            
            //             }
            //             else if (key.equals("SPACE"))
            //             {
            //                 Shoot();
            //             }
            int key = event.getKeyCode();

            if (key == KeyEvent.VK_SPACE) {
                Shoot();
            }

            if (key == KeyEvent.VK_LEFT) {
                moveCharacterBy(-5, 0);  
            }

            if (key == KeyEvent.VK_RIGHT) {
                moveCharacterBy(5, 0);   
            }
        }

        public void keyTyped(KeyEvent event) {}

        public void keyReleased(KeyEvent event) {}
    }
}
