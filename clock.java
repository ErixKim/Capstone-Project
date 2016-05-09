import java.util.TimerTask;

public class clock extends TimerTask
{
    private Target main;
    public clock(Target main)
    {
        this.main= main;

    }

    public void run(){
        main.randomMovement();
    }
}