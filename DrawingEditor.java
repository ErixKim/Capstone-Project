import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Timer;
import javax.swing.*;
import java.util.ArrayList;
/**
 * DrawingEditor class is a subclass of JFrame and creates the frame which is where the characters
 * are going to be drawn. It adds the canvas instance variable to the frame which will add the characters.
 * It also utilizes the Clock classes and calls methods from the bullet and target class.  
 * 
 * @author Eric Kim
 * @version 3/4/2016
 */
public class DrawingEditor extends JFrame
{
    //Creates an instance variable canvas that is declared type DrawingPanel
    private DrawingPanel canvas;
    //Creates a target and bullets instance variable to pass into the DrawingPanel constructor
    private Target target;
    private ArrayList<Bullet> bullets;
    /**
     * Constructor for objects of class DrawingEditor
     */
    public DrawingEditor()
    {
        //Creates a new target and arraylist<Bullet> 
        target = new Target(0, 50, 30, 30);
        bullets = new ArrayList<Bullet>();
        //Creates a new drawingpanel with target and bullets as the parameters
        this.canvas = new DrawingPanel(target, bullets);
        Timer timer = new Timer();
        //Creates a Clock object with bullets passed in 
        Clock clock1 = new Clock(bullets);
        //Creates a clock2 object with target passed in
        Clock2 clock2 = new Clock2(target);
        //Uses the method scheduleAtFixedRate in order to run the run method in the clock class at given intervals
        timer.scheduleAtFixedRate(clock1,10,10);
        timer.scheduleAtFixedRate(clock2,20,20);
        //adds the canvas to the frame
        this.add(canvas);
        //Sets the title of the window to "Hit the Target" and the size of the frame to 600x600
        this.setTitle("Hit the Target");
        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Sets the DrawingEditor object visibility to true
        this.setVisible(true);
    }

    /**
     * Main Method creates a new DrawingEditor object called scene
     */
    public static void main(String[] args)
    {
        //Creates a new DrawingEditor object named scene
        DrawingEditor scene = new DrawingEditor();
    }
}
