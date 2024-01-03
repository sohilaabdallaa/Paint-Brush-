package paint;

import javax.swing.JFrame;


public class Paint {

    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
        frame.setTitle("Paint Brush");
        // automatically resize the frame to fit the preferred size of its components.
        frame.pack();      
    }
    
}
