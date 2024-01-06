/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paint;

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
class DrawingTools extends JPanel {

        DrawingTools(MyFrame frame) {

            JButton pencil = new JButton("");
            ImageIcon pencilPic = new ImageIcon(Objects.requireNonNull(getClass().getResource("assets/icons/pencil.png")));
            pencil.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.getPaintPanel().active_tool = 0;
                }
            });
            pencil.setIcon(pencilPic);

            JButton eraser = new JButton("");
            ImageIcon eraserPic = new ImageIcon(Objects.requireNonNull(getClass().getResource("assets/icons/eraser.png")));
            eraser.setIcon(eraserPic);
            eraser.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.getPaintPanel().active_tool = 4;
                }
            });

            add(pencil);
            add(eraser);

            setBorder(new TitledBorder("Tools"));

        }
    }