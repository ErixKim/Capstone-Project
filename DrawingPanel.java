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
    private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    /**
     * Constructor for objects of class DrawingPanel
     */
    public DrawingPanel(Target target)
    {
        box = new Character(280, 520, 20, 30); 
        this.target = target;
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
        for (int i = 0; i < bullets.size(); i++)
        {
            if (bullets.get(i).getBounds().getY() != 0)
            {
                System.out.println("X");
                bullets.get(i).draw(g2);
                repaint();
            }
        }
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
        System.out.println(box.getX());
        updateBullets();
    }

    public void updateBullets()
    {
        try{
            for (int i = 0; i < bullets.size(); i++)
            {
                //                 Bullet bullet = bullets.get(i);
                while (bullets.get(i).isVisible() == true)
                {
                    bullets.get(i).move();
                    repaint();
                    Thread.sleep(100);
                    System.out.println(bullets.get(i).getY());
                    if (bullets.get(i).getY() < 0)
                    {
                        bullets.get(i).setVisible(false);
                    }
                }
            }
        }
        catch (Exception e) 
        {
            System.out.println(e);
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
            else if (key.equals("SPACE"))
            {
                Shoot();
            }

        }

        public void keyTyped(KeyEvent event) {}

        public void keyReleased(KeyEvent event) {}
    }
}

