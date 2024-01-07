package paint;

import javax.swing.*;
import java.awt.*;


public class MyFrame extends JFrame {

    private JToolBar paintControl;
    private MyPanel paintPanel;


    public MyFrame() {
        // create a panel for painting
        paintPanel = new MyPanel(this);

        paintControl = new PaintControl(this);
        
        add(paintPanel, BorderLayout.CENTER);

        add(paintControl, BorderLayout.NORTH);

        //set a default closer of window
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

     public JToolBar getPaintControl() {
        return this.paintControl;
    }

    public MyPanel getPaintPanel() {
        return paintPanel;
    }

}
