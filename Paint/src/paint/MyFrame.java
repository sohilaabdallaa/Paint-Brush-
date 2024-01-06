package paint;

import java.awt.BorderLayout;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MyFrame extends JFrame {

    private JToolBar paintControl;
    private MyPanel paintPanel;


    public MyFrame() {
        paintPanel = new MyPanel(this);

        paintControl = new PaintControl(this);
        
        add(paintPanel, BorderLayout.CENTER);

        add(paintControl, BorderLayout.NORTH);

        // set a default closer of window
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

     public JToolBar getPaintControl() {
        return this.paintControl;
    }

    public MyPanel getPaintPanel() {
        return paintPanel;
    }

}
