package com.app.chess.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DragExample extends JFrame {

    final private JPanel panel;

    public DragExample() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(500, 500);

        JLayeredPane pane = new JLayeredPane();
        add(pane);

        panel = new JPanel();
        panel.setOpaque(true);
        panel.setBackground(Color.BLUE);

        MoveListener ml = new MoveListener();
        panel.addMouseListener(ml);
        panel.addMouseMotionListener(ml);

        panel.setBounds(100,100,100,100);
        pane.add(panel,1);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new DragExample();
    }

    private class MoveListener extends MouseAdapter {

        private Point old;


        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            old = e.getPoint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            super.mouseDragged(e);
            panel.setLocation(panel.getX() + e.getX() - (int)old.getX(), panel.getY() + e.getY() - (int)old.getY());
            //old = e.getPoint();
        }

        @Override
        public void mouseReleased(MouseEvent e){
            System.out.println(panel.getX() + " " + panel.getY());
        }
    }
}
