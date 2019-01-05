package com.app.chess.Figures.BlackPieces;

import com.app.chess.Core.ChessBoard.ChessBoardLogic;
import com.app.chess.Figures.AbstractPieces.Rook;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BlackRook extends Rook {

    public BlackRook(int x, int y, Color color) {
        super(x, y, color);

        JLabel label = new JLabel();

        try {
            label.setIcon(new ImageIcon(ImageIO.read(new File("src//main//resources//Chess pieces//Chess_rdt60.png"))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        add(label);
    }

    @Override
    public void predictSteps() {
        int x = this.getPositionInArrayX();
        int y = this.getPositionInArrayY();
        boolean metAnFigure = false;

        //Очистка массива с предиктами ходов
        for (int i = 0; i < steps.length; i++) {
            for (int k = 0; k < steps.length; k++) {
                steps[i][k] = false;
            }
        }

        System.out.println(x);
        System.out.println(y);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!metAnFigure) {
                    metAnFigure = checkForOtherFigure(i, j);
                }
                if (i == y && metAnFigure) {
                    steps[i][j] = true;
                }
                if (j == x && metAnFigure) {
                    steps[i][j] = true;
                }
                System.out.print(steps[i][j]);
            }
            System.out.println();
        }
    }

    private boolean checkForOtherFigure(int x, int y) {
        return ChessBoardLogic.figuresArray[y][x] != null && ChessBoardLogic.figuresArray[y][x] != this;
    }
}
