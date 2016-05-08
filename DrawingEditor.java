import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
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
    //Creates an instance variable controls that is declared type ControlPanel
    private ControlPanel controls;
    /**
     * Constructor for objects of class DrawingEditor
     */
    public DrawingEditor()
    {
        //Puts a new DrawingPanel object into the canvas instance variable
        this.canvas = new DrawingPanel();
        //Puts a new ControlPanel object into the controls instance variable
        controls = new ControlPanel(canvas);
        this.add(canvas);
        //Sets the title of the window to "Drawing Editor" and the size of the frame to 600x600
        this.setTitle("Kill the Goomba");
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
