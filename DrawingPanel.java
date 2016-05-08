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
 * Drawing Panel class is a subclass of JPanel and its main purpose is to draw the shapes and change the
 * color
 * 
 * @author Eric Kim
 * @version 3/4/2016
 */
public class DrawingPanel extends JPanel
{
    private Rectangle box;
    /**
     * Constructor for objects of class DrawingPanel
     */
    public DrawingPanel()
    {
        box = new Rectangle(280, 520, 20, 30);   
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
        g2.draw(box);
        repaint();
    }
    
    public void moveRectangleBy(int dx, int dy)
    {
        box.translate(dx, dy);
        repaint();      
    }
    
    class KeyStrokeListener implements KeyListener
    {
        public void keyPressed(KeyEvent event) 
        {
            String key = KeyStroke.getKeyStrokeForEvent(event).toString().replace("pressed ", ""); 
            
            if (key.equals("LEFT"))
            {
                moveRectangleBy(-5, 0);            
            }
            else if (key.equals("RIGHT"))
            {
                moveRectangleBy(5, 0);            
            }
        }

        public void keyTyped(KeyEvent event) {}

        public void keyReleased(KeyEvent event) {}
    }
}

