package paint;

import javax.swing.*;

public class MyFrame extends JFrame {

    private JPanel contentPanel;
    private MyPanel myPanel;


    public MyFrame() {
        contentPanel = new JPanel();
        myPanel = new MyPanel(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public MyPanel getPaintPanel() {
        return myPanel;
    }
}
