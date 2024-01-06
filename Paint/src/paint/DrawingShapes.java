/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paint;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.Objects;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Lap Smart
 */
 class DrawingShapes extends JPanel {

        DrawingShapes(MyFrame frame) {
            JButton circleBtn = new JButton("");
            circleBtn.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("assets/icons/circle.png"))));
            circleBtn.setPreferredSize(new Dimension(30, 30));
            circleBtn.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.getPaintPanel().active_tool = 3;
                }
            });
            add(circleBtn);

            JButton rectangleBtn = new JButton("");
            rectangleBtn.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("assets/icons/rectangle.png"))));
            rectangleBtn.setPreferredSize(new Dimension(30, 30));
            rectangleBtn.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.getPaintPanel().active_tool = 2;
                }
            });
            add(rectangleBtn);

            JButton lineBtn = new JButton("");
            lineBtn.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("assets/icons/line.png"))));
            lineBtn.setPreferredSize(new Dimension(30, 30));
            lineBtn.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.getPaintPanel().active_tool = 1;
                }
            });
            add(lineBtn);

            setBorder(new TitledBorder("Shapes"));

        }

    }