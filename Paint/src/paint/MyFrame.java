package paint;

import javax.swing.*;

public class MyFrame extends JFrame {

    private JPanel contentPanel;
    private MyPanel myPanel;

    private int paintPanelWidth = 1100;
    private int paintPanelHeight = 800;

    public MyFrame() {
        contentPanel = new JPanel();
        myPanel = new MyPanel(this, paintPanelWidth, paintPanelHeight);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public MyPanel getPaintPanel() {
        return myPanel;
    }
}
