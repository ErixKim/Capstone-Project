import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
/**
 * The control panel class is a subclass of JPanel and creates the buttons and panels.
 * 
 * @author Eric Kim
 * @version 3/4/2016
 */
public class ControlPanel extends JPanel
{
    //Creates a canvas instance variable
    private DrawingPanel canvas;
    private JPanel panel;
    /**
     * Constructor for objects of class ControlPanel
     */
    public ControlPanel(DrawingPanel canvas)
    {
        //Sets the instance variable canvas to the parameter variable canvas
        this.canvas = canvas;
    }
}

