package paint;

import java.awt.Color;
import java.awt.GridLayout;

/**
 *
 * @author Lap Smart
 */
public class PaintControl {
    private final MyFrame frame;

    PaintControl(MyFrame frame) {
        this.frame = frame;

        // create a color chooser
        MyColors colorChooser = new MyColors(frame);
        DrawingTools drawingTools = new DrawingTools(frame);
        DrawingShapes drawingShapes = new DrawingShapes(frame);
        FillBox fillBox = new FillBox();
        DotBox dottedBox = new DotBox();
        UndoRedo undoRedo = new UndoRedo();

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
}
