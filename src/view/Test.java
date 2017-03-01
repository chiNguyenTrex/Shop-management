/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.border.Border;

/**
 *
 * @author Chi Nguyen T-rex
 */
public class Test {

    private static final Color LINK_COLOR = Color.blue;
    private static final Border LINK_BORDER = BorderFactory.createEmptyBorder(0, 0, 1, 0);
    private static final Border HOVER_BORDER = BorderFactory.createMatteBorder(0, 0, 1, 0, LINK_COLOR);

    private static class LinkMouseListener extends MouseAdapter {

        @Override
        public void mouseEntered(MouseEvent e) {
            ((JComponent) e.getComponent()).setBorder(HOVER_BORDER);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            ((JComponent) e.getComponent()).setBorder(LINK_BORDER);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            ((JComponent) e.getComponent()).setBorder(LINK_BORDER);
        }
    };

    public static JButton makeLink(JButton button) {
        button.setBorder(LINK_BORDER);
        button.setForeground(LINK_COLOR);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setFocusPainted(false);
        button.setRequestFocusEnabled(false);
        button.setContentAreaFilled(false);
        button.addMouseListener(new LinkMouseListener());
        return button;
    }
    
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(new Dimension(800, 600));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        JButton button = new JButton("Forget your password?");
        f.add(makeLink(button));
        f.setVisible(true);
    }
}
