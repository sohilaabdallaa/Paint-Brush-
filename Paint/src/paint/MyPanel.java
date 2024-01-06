package paint;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import java.util.Stack;

public class MyPanel extends JPanel implements MouseListener, MouseMotionListener {

    // drawing tools
    private final int PENCIL_TOOL = 0;
    private final int ERASER_TOOL = 4;
    private final int LINE_TOOL = 1;
    private final int RECTANGLE_TOOL = 2;
    private final int CIRCLE_TOOL = 3;

    // shapes
    private final int LINE = 1;
    private final int RECTANGLE = 2;
    private final int OVAL = 3;

    // active tool
    int active_tool = 0;
    private int grouped;

    Stack<Shape> shapes;
    Stack<Shape> removed;
    Stack<Shape> preview;

    BasicStroke stroke = new BasicStroke((float) 4);

    int x1, y1, x2, y2;

    Color currentColor = Color.black;
    Color eraserColor = Color.white;

    private boolean dragged = false;
    private boolean filledShapes = false;

    private MyFrame frame;

    MyPanel() {
        setBackground(Color.WHITE);
        shapes = new Stack<>();
    }

    MyPanel(MyFrame frame) {
        this.frame = frame;

        grouped = 1;

        shapes = new Stack<>();
        removed = new Stack<>();
        preview = new Stack<>();

        setLayout(null);
        setBackground(Color.WHITE);

        addMouseListener(this);
        addMouseMotionListener(this);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        for (Shape s : shapes) {
            g2d.setColor(s.getColor());
            g2d.setStroke(s.getStroke());

            if (s.getShape() == LINE || s.getShape() == ERASER_TOOL) {
                drawLine(g2d, s);
            } else {
                if (!s.getFilled()) {
                    drawUnfilledShape(g2d, s);
                } else {
                    drawFilledShape(g2d, s);
                }
            }
        }

        if (!preview.isEmpty()) {
            Shape s = preview.pop();
            g2d.setColor(s.getColor());
            g2d.setStroke(s.getStroke());

            if (s.getShape() == LINE || s.getShape() == ERASER_TOOL) {
                drawLine(g2d, s);
            } else {
                if (!s.getFilled()) {
                    drawUnfilledShape(g2d, s);
                } else {
                    drawFilledShape(g2d, s);
                }
            }
        }
    }

    // mouse listener
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        grouped++;
        if (active_tool == RECTANGLE_TOOL && dragged) {
            if (x1 < x2 && y1 < y2) {
                shapes.push(new Shape(x1, y1, x2 - x1, y2 - y1, currentColor, stroke, 2, filledShapes));
            } else if (x2 < x1 && y1 < y2) {
                shapes.push(new Shape(x2, y1, x1 - x2, y2 - y1, currentColor, stroke, 2, filledShapes));
            } else if (x1 < x2 && y2 < y1) {
                shapes.push(new Shape(x1, y2, x2 - x1, y1 - y2, currentColor, stroke, 2, filledShapes));
            } else if (x2 < x1 && y2 < y1) {
                shapes.push(new Shape(x2, y2, x1 - x2, y1 - y2, currentColor, stroke, 2, filledShapes));
            }
            //repaint();
        } else if (active_tool == CIRCLE_TOOL && dragged) {
            if (x1 < x2 && y1 < y2) {
                shapes.push(new Shape(x1, y1, x2 - x1, y2 - y1, currentColor, stroke, 3, filledShapes));
            } else if (x2 < x1 && y1 < y2) {
                shapes.push(new Shape(x2, y1, x1 - x2, y2 - y1, currentColor, stroke, 3, filledShapes));
            } else if (x1 < x2 && y2 < y1) {
                shapes.push(new Shape(x1, y2, x2 - x1, y1 - y2, currentColor, stroke, 3, filledShapes));
            } else if (x2 < x1 && y2 < y1) {
                shapes.push(new Shape(x2, y2, x1 - x2, y1 - y2, currentColor, stroke, 3, filledShapes));
            }
            //repaint();
        } else if (active_tool == LINE_TOOL && dragged) {
            shapes.push(new Shape(x1, y1, x2, y2, currentColor, stroke, 1));
        }
        repaint();
        dragged = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        dragged = true;
        x2 = e.getX();
        y2 = e.getY();
        if (active_tool == PENCIL_TOOL) {
            shapes.push(new Shape(x1, y1, x2, y2, currentColor, stroke, 1, grouped));
            repaint();
            x1 = x2;
            y1 = y2;
        } else if (active_tool == RECTANGLE_TOOL) {
            if (x1 < x2 && y1 < y2) {
                preview.push(new Shape(x1, y1, x2 - x1, y2 - y1, currentColor, stroke, 2));
            } else if (x2 < x1 && y1 < y2) {
                preview.push(new Shape(x2, y1, x1 - x2, y2 - y1, currentColor, stroke, 2));
            } else if (x1 < x2 && y2 < y1) {
                preview.push(new Shape(x1, y2, x2 - x1, y1 - y2, currentColor, stroke, 2));
            } else if (x2 < x1 && y2 < y1) {
                preview.push(new Shape(x2, y2, x1 - x2, y1 - y2, currentColor, stroke, 2));
            }
            repaint();
        } else if (active_tool == CIRCLE_TOOL) {
            if (x1 < x2 && y1 < y2) {
                preview.push(new Shape(x1, y1, x2 - x1, y2 - y1, currentColor, stroke, 3));
            } else if (x2 < x1 && y1 < y2) {
                preview.push(new Shape(x2, y1, x1 - x2, y2 - y1, currentColor, stroke, 3));
            } else if (x1 < x2 && y2 < y1) {
                preview.push(new Shape(x1, y2, x2 - x1, y1 - y2, currentColor, stroke, 3));
            } else if (x2 < x1 && y2 < y1) {
                preview.push(new Shape(x2, y2, x1 - x2, y1 - y2, currentColor, stroke, 3));
            }
            repaint();
        } else if (active_tool == LINE_TOOL) {
            preview.push(new Shape(x1, y1, x2, y2, currentColor, stroke, 1));
            repaint();
        } else if (active_tool == ERASER_TOOL) {
            shapes.push(new Shape(x1, y1, x2, y2, eraserColor, stroke, 4, grouped));
            repaint();
            x1 = x2;
            y1 = y2;
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
/*not*/
    // undoing the last drawing action
    public void undo() {
        if (shapes.size() > 0 && shapes.peek().getGroup() == 0) {
            removed.push(shapes.pop());
            repaint();
        } else if (shapes.size() > 0 && shapes.peek().getGroup() != 0) {
            // Undo a group of shapes
            Shape lastRemoved = shapes.pop();
            removed.push(lastRemoved);

            // Keep undoing until a shape with a different group is encountered
            while (!shapes.isEmpty() && shapes.peek().getGroup() == lastRemoved.getGroup()) {
                removed.push(shapes.pop());
                repaint();
            }
        }
    }

    public void redo() {
        if (removed.size() > 0 && removed.peek().getGroup() == 0) {
            shapes.push(removed.pop());
            repaint();
        } else if (removed.size() > 0 && removed.peek().getGroup() != 0) {
            Shape lastRemoved = removed.pop();
            shapes.push(lastRemoved);
            while (!removed.isEmpty() && removed.peek().getGroup() == lastRemoved.getGroup()) {
                shapes.push(removed.pop());
                repaint();
            }
        }
    }

    public void clear() {

        frame.getPaintPanel().shapes.removeAllElements();
        frame.getPaintPanel().removed.removeAllElements();
        frame.getPaintPanel().preview.removeAllElements();

        frame.getPaintPanel().repaint();
    }
/*nott*/
    public void setFilledShapes(boolean filled) {
        this.filledShapes = filled;
    }

    private void drawLine(Graphics2D g2d, Shape s) {
        g2d.drawLine(s.getx1(), s.gety1(), s.getx2(), s.gety2());
    }

    private void drawUnfilledShape(Graphics2D g2d, Shape s) {
        if (s.getShape() == RECTANGLE) {
            g2d.drawRect(s.getx1(), s.gety1(), s.getx2(), s.gety2());
        } else if (s.getShape() == OVAL) {
            g2d.drawOval(s.getx1(), s.gety1(), s.getx2(), s.gety2());
        }
    }

    private void drawFilledShape(Graphics2D g2d, Shape s) {
        if (s.getShape() == RECTANGLE) {
            g2d.fillRect(s.getx1(), s.gety1(), s.getx2(), s.gety2());
        } else if (s.getShape() == OVAL) {
            g2d.fillOval(s.getx1(), s.gety1(), s.getx2(), s.gety2());
        }
    }
}
