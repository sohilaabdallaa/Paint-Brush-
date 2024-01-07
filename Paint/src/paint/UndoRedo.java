/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paint;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Objects;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Lap Smart
 */
    class UndoRedo extends JPanel {

        UndoRedo(MyFrame frame) {
            JPanel panel = new JPanel();

            JButton undoBtn = new JButton("Undo", new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/undo.png"))));
            undoBtn.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.getPaintPanel().undo();
                }
            });

            JButton redoBtn = new JButton("Redo", new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/redo.png"))));

            redoBtn.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.getPaintPanel().redo();
                }
            });
            panel.add(undoBtn);
            panel.add(redoBtn);

            JPanel panelClear = new JPanel();
            JButton clear = new JButton("Clear", new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/delete.png"))));
            clear.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.getPaintPanel().clear();
                }
            });
            panelClear.add(clear);

            add(panel);
            add(panelClear);
            // rows , cols
            setLayout(new GridLayout(2, 8));
        }
    }