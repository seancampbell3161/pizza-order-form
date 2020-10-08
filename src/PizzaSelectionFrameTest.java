
import java.awt.Color;
import javax.swing.JFrame;

//start class
public class PizzaSelectionFrameTest {
    
    public static void main(String[] args) {
        
        //create the frame and set size, color, visibility, and exit
        PizzaSelectionFrame myframe = new PizzaSelectionFrame();
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myframe.setSize(325, 300);
        myframe.setBackground(Color.LIGHT_GRAY);
        myframe.setVisible(true);
    }
}
