package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

/**
 *
 * @author Lap Smart
 */
public class MyPanel extends JPanel implements MouseListener, MouseMotionListener {

    int x1, y1, x2, y2;
    // set defult colors
    Color currentColor = Color.black;
    Color eraserColor = Color.white;

    private MyFrame frame;
    int paintPanelWidth, paintPanelHeight;

    // defult constructor
    MyPanel() {
        setBackground(Color.WHITE);
        this.setSize(paintPanelWidth, paintPanelHeight);
    }

    // overloaded constructor
    MyPanel(MyFrame frame) {
        this.frame = frame;
        this.paintPanelWidth = paintPanelWidth;
        this.paintPanelHeight = paintPanelHeight;
        setLayout(null);
        setBackground(Color.WHITE);

        addMouseListener(this);
        addMouseMotionListener(this);

        this.paintPanelWidth = paintPanelWidth;
        this.paintPanelHeight = paintPanelHeight;

        
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        System.out.println(" ");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("");
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        // Update the starting point for the next draw
        x2 = e.getX();
        y2 = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("");
    }

    public void clear() {
        frame.getPaintPanel().repaint();
    }
     @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(currentColor);
        g.drawLine(x1, y1, x2, y2);
    }
    
}
