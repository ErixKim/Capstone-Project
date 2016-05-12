import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Timer;
import javax.swing.*;
import java.util.ArrayList;
/**
 * DrawingEditor class is a subclass of JFrame and creates the frame which contains the buttons and
 * where the shapes are going to be drawn.
 * 
 * @author Eric Kim
 * @version 3/4/2016
 */
public class DrawingEditor extends JFrame
{
    //Creates an instance variable canvas that is declared type DrawingPanel
    private DrawingPanel canvas;
    private Target target;
    private ArrayList<Bullet> bullets;
    /**
     * Constructor for objects of class DrawingEditor
     */
    public DrawingEditor()
    {
        //Puts a new DrawingPanel object into the canvas instance variable
        target = new Target(0, 50, 30, 30);
        bullets = new ArrayList<Bullet>();
        this.canvas = new DrawingPanel(target, bullets);
        Timer timer = new Timer();
        //Have an i instance variable that acts as a counter and if the counter % 2 == 0, the target moves left, else right.
        Clock clock1 = new Clock(bullets);
        Clock2 clock2 = new Clock2(target);
        timer.scheduleAtFixedRate(clock1,10,10);
        timer.scheduleAtFixedRate(clock2,20,20);
        //Puts a new ControlPanel object into the controls instance variable
        this.add(canvas);
        //Sets the title of the window to "Drawing Editor" and the size of the frame to 600x600
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
