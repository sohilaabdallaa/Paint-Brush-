package paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JToolBar;


public class PaintControl extends JToolBar{
    private final MyFrame frame;

    PaintControl(MyFrame frame) {
        this.frame = frame;

        // create a color chooser
        MyColors colorChooser = new MyColors(frame);
        DrawingTools drawingTools = new DrawingTools(frame);
        DrawingShapes drawingShapes = new DrawingShapes(frame);
        FillBox fillBox = new FillBox();
        DotBox dottedBox = new DotBox();
        UndoRedo undoRedo = new UndoRedo(frame);

        add(undoRedo);
        add(drawingTools);
        //add(new ManageStroke());

        add(drawingShapes);
        add(colorChooser);

        add(fillBox);
        add(dottedBox);

        setBackground(new Color(145, 179, 203));
        setLayout(new GridLayout(1, 2));
        setFloatable(false);
    }
    
    
        public class FillBox extends JPanel {

        FillBox() {
            JPanel panel = new JPanel();

            JCheckBox filledCheckBox = new JCheckBox("Fill");

            Font checkBoxFont = filledCheckBox.getFont();
            filledCheckBox.setFont(new Font(checkBoxFont.getName(), checkBoxFont.getStyle(), 20));

            filledCheckBox.addActionListener(e -> {
                // Handle the checkbox state change
                boolean filled = filledCheckBox.isSelected();
                frame.getPaintPanel().setFilledShapes(filled);
            }
            );
            panel.add(filledCheckBox);

            add(panel);
        }
    }
    
        class DotBox extends JPanel {

        DotBox() {
            JPanel panel = new JPanel();

            JCheckBox dottedBox = new JCheckBox("Dotted");
            Font checkBoxFont = dottedBox.getFont();

            dottedBox.setFont(new Font(checkBoxFont.getName(), checkBoxFont.getStyle(), 20)); // Adjust the size as needed
            dottedBox.addActionListener(e -> {
                float[] dash = {10, 10};
                // Handle the checkbox state change
                boolean dotted = dottedBox.isSelected();
                if (dotted) {
                    frame.getPaintPanel().stroke = new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0, dash, 0);
                } else {
                    frame.getPaintPanel().stroke = new BasicStroke((float) 4);
                }
            });
            panel.add(dottedBox);
            add(panel);
        }
    }
}
