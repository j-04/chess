package com.app.chess.Figures.BlackPieces;

import com.app.chess.Figures.AbstractPieces.King;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BlackKing extends King {
    public BlackKing(int x, int y, Color color) {
        super(x, y, color);
        JLabel label = new JLabel();

        try {
            label.setIcon(new ImageIcon(ImageIO.read(new File("src/main/resources/Chess pieces/Chess_kdt60.png"))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        add(label);
        predictSteps();
    }

    @Override
    public void predictSteps() {

    }
}
