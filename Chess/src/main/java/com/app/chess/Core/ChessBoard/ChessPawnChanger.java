package com.app.chess.Core.ChessBoard;

import com.app.chess.Core.Handlers.Mouse;
import com.app.chess.Figures.AbstractPieces.Pawn;
import com.app.chess.Figures.Figure;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ChessPawnChanger extends JDialog {

    public ChessPawnChanger(JFrame root) {
        super(root, "Pawn changer", true);
        frameInitialization();
    }

    private void frameInitialization() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        short frameWidth = 100;
        short frameHeight = 490;
        setSize(frameWidth, frameHeight);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocation((screenWidth- frameWidth)/2, (screenHeight- frameHeight)/2);
        setResizable(false);

        setLayout(null);

    }

    public Figure chooseWhiteFigure(Pawn figureToChange) {
        if (figureToChange != null) {
            JPanel panelRook = new JPanel();
            panelRook.setSize(100, 100);
            panelRook.setLocation(0, 0);
            panelRook.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            panelRook.addMouseListener(new Mouse(this, panelRook, figureToChange));
            panelRook.setName("WhiteRook");
            try {
                JLabel label = new JLabel();
                label.setIcon(new ImageIcon(ImageIO.read(new File("src/main/resources/Chess pieces/Chess_rlt60.png"))));
                panelRook.add(label);
            } catch (IOException e) {
                e.printStackTrace();
            }

            JPanel panelKnight = new JPanel();
            panelKnight.setSize(100, 100);
            panelKnight.setLocation(0, 120);
            panelKnight.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            panelKnight.addMouseListener(new Mouse(this, panelKnight, figureToChange));
            panelKnight.setName("WhiteKnight");
            try {
                JLabel label = new JLabel();
                label.setIcon(new ImageIcon(ImageIO.read(new File("src/main/resources/Chess pieces/Chess_klt60.png"))));
                panelKnight.add(label);
            } catch (IOException e) {
                e.printStackTrace();
            }

            JPanel panelBishop = new JPanel();
            panelBishop.setSize(100, 100);
            panelBishop.setLocation(0, 240);
            panelBishop.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            panelBishop.addMouseListener(new Mouse(this, panelBishop, figureToChange));
            panelBishop.setName("WhiteBishop");
            try {
                JLabel label = new JLabel();
                label.setIcon(new ImageIcon(ImageIO.read(new File("src/main/resources/Chess pieces/Chess_blt60.png"))));
                panelBishop.add(label);
            } catch (IOException e) {
                e.printStackTrace();
            }

            JPanel panelQueen = new JPanel();
            panelQueen.setSize(100, 100);
            panelQueen.setLocation(0, 360);
            panelQueen.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            panelQueen.addMouseListener(new Mouse(this, panelQueen, figureToChange));
            panelQueen.setName("WhiteQueen");
            try {
                JLabel label = new JLabel();
                label.setIcon(new ImageIcon(ImageIO.read(new File("src/main/resources/Chess pieces/Chess_qlt60.png"))));
                panelQueen.add(label);
            } catch (IOException e) {
                e.printStackTrace();
            }

            add(panelRook);
            add(panelKnight);
            add(panelBishop);
            add(panelQueen);

            setVisible(true);
        }
        return null;
    }

    public Figure chooseBlackFigure(Pawn figureToChange) {
        if (figureToChange != null) {
            JPanel panelRook = new JPanel();
            panelRook.setSize(100, 100);
            panelRook.setLocation(0, 0);
            panelRook.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            panelRook.addMouseListener(new Mouse(this, panelRook, figureToChange));
            panelRook.setName("BlackRook");
            try {
                JLabel label = new JLabel();
                label.setIcon(new ImageIcon(ImageIO.read(new File("src/main/resources/Chess pieces/Chess_rdt60.png"))));
                panelRook.add(label);
            } catch (IOException e) {
                e.printStackTrace();
            }

            JPanel panelKnight = new JPanel();
            panelKnight.setSize(100, 100);
            panelKnight.setLocation(0, 120);
            panelKnight.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            panelKnight.addMouseListener(new Mouse(this, panelKnight, figureToChange));
            panelKnight.setName("BlackKnight");
            try {
                JLabel label = new JLabel();
                label.setIcon(new ImageIcon(ImageIO.read(new File("src/main/resources/Chess pieces/Chess_kdt60.png"))));
                panelKnight.add(label);
            } catch (IOException e) {
                e.printStackTrace();
            }

            JPanel panelBishop = new JPanel();
            panelBishop.setSize(100, 100);
            panelBishop.setLocation(0, 240);
            panelBishop.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            panelBishop.addMouseListener(new Mouse(this, panelBishop, figureToChange));
            panelBishop.setName("BlackBishop");
            try {
                JLabel label = new JLabel();
                label.setIcon(new ImageIcon(ImageIO.read(new File("src/main/resources/Chess pieces/Chess_bdt60.png"))));
                panelBishop.add(label);
            } catch (IOException e) {
                e.printStackTrace();
            }

            JPanel panelQueen = new JPanel();
            panelQueen.setSize(100, 100);
            panelQueen.setLocation(0, 360);
            panelQueen.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            panelQueen.addMouseListener(new Mouse(this, panelQueen, figureToChange));
            panelQueen.setName("BlackQueen");
            try {
                JLabel label = new JLabel();
                label.setIcon(new ImageIcon(ImageIO.read(new File("src/main/resources/Chess pieces/Chess_qdt60.png"))));
                panelQueen.add(label);
            } catch (IOException e) {
                e.printStackTrace();
            }

            add(panelRook);
            add(panelKnight);
            add(panelBishop);
            add(panelQueen);

            setVisible(true);
        }
        return null;
    }
}