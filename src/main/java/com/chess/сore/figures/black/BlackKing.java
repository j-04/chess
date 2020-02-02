package com.chess.сore.figures.black;

import com.chess.сore.сhessboard.ChessBoardLogic;
import com.chess.сore.figures.abstrac.King;
import com.chess.сore.figures.abstrac.Figure;

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
        //Очистка массива с предиктами ходов
        for (int i = 0; i < steps.length; i++) {
            for (int k = 0; k < steps.length; k++) {
                steps[i][k] = false;
            }
        }

        // 1
        int x = this.getPositionInArrayX() - 1;
        int y = this.getPositionInArrayY() - 1;

        if (x > -1 && y > -1 && !checkForAllyFigure(x, y)) {
            this.steps[y][x] = true;
        }

        // 2
        x = this.getPositionInArrayX();
        y = this.getPositionInArrayY() - 1;
        if (y > -1 && !checkForAllyFigure(x, y)) {
            this.steps[y][x] = true;
        }

        // 3
        x = this.getPositionInArrayX() + 1;
        y = this.getPositionInArrayY() - 1;
        if (x < 8 && y > -1 && !checkForAllyFigure(x, y)) {
            this.steps[y][x] = true;
        }

        // 4
        x = this.getPositionInArrayX() + 1;
        y = this.getPositionInArrayY();
        if (x < 8 && !checkForAllyFigure(x, y)) {
            this.steps[y][x] = true;
        }

        // 5
        x = this.getPositionInArrayX() + 1;
        y = this.getPositionInArrayY() + 1;
        if (x < 8 && y < 8 && !checkForAllyFigure(x, y)) {
            this.steps[y][x] = true;
        }

        // 6
        x = this.getPositionInArrayX();
        y = this.getPositionInArrayY() + 1;
        if (y < 8 && !checkForAllyFigure(x, y)) {
            this.steps[y][x] = true;
        }

        // 7
        x = this.getPositionInArrayX() - 1;
        y = this.getPositionInArrayY() + 1;
        if (x > -1 && y < 8 && !checkForAllyFigure(x, y)) {
            this.steps[y][x] = true;
        }

        // 8
        x = this.getPositionInArrayX() - 1;
        y = this.getPositionInArrayY();
        if (x > -1 && !checkForAllyFigure(x, y)) {
            this.steps[y][x] = true;
        }
    }

    public boolean checkForAllyFigure(int x, int y) {
        Figure figure = ChessBoardLogic.figuresArray[y][x];
        return figure != null && figure.getColor().equals(this.getColor());
    }
}
