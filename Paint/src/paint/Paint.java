package paint;

import java.awt.Frame;
import javax.swing.JFrame;


public class Paint {

    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
        frame.setTitle("Paint Brush");
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setVisible(true); 
    }
    
}
