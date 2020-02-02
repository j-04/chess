package com.chess.сore.figures.white;

import com.chess.сore.сhessboard.ChessBoardLogic;
import com.chess.сore.figures.abstrac.Knight;
import com.chess.сore.figures.abstrac.Figure;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class WhiteKnight extends Knight {
    public WhiteKnight(int x, int y, Color color) {
        super(x, y, color);

        JLabel label = new JLabel();

        try {
            label.setIcon(new ImageIcon(ImageIO.read(new File("src/main/resources/Chess pieces/Chess_nlt60.png"))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        add(label);
    }

    @Override
    public void predictSteps() {
        //Очистка массива с предиктами ходов
        for (int i = 0; i < steps.length; i++) {
            for (int k = 0; k < steps.length; k++) {
                steps[i][k] = false;
            }
        }

        //1
        int predictX = this.getPositionInArrayX() - 1;
        int predictY = this.getPositionInArrayY() - 2;
        if (!(predictX < 0) && !(predictY < 0) && !checkForAllyFigure(predictX, predictY)) {

            this.steps[predictY][predictX] = true;
        }

        //2
        predictX = this.getPositionInArrayX() + 1;
        predictY = this.getPositionInArrayY() - 2;
        if (!(predictX > 7) && !(predictY < 0) && !checkForAllyFigure(predictX, predictY)) {
            this.steps[predictY][predictX] = true;
        }

        //3
        predictX = this.getPositionInArrayX() + 2;
        predictY = this.getPositionInArrayY() - 1;
        if (!(predictX > 7) && !(predictY < 0) && !checkForAllyFigure(predictX, predictY)) {
            this.steps[predictY][predictX] = true;
        }

        //4
        predictX = this.getPositionInArrayX() + 2;
        predictY = this.getPositionInArrayY() + 1;
        if (!(predictX > 7) && !(predictY > 7) && !checkForAllyFigure(predictX, predictY)) {
            this.steps[predictY][predictX] = true;
        }

        //5
        predictX = this.getPositionInArrayX() + 1;
        predictY = this.getPositionInArrayY() + 2;
        if (!(predictX > 7) && !(predictY > 7) && !checkForAllyFigure(predictX, predictY)) {
            this.steps[predictY][predictX] = true;
        }

        //6
        predictX = this.getPositionInArrayX() - 1;
        predictY = this.getPositionInArrayY() + 2;
        if (!(predictX < 0) && !(predictY > 7) && !checkForAllyFigure(predictX, predictY)) {
            this.steps[predictY][predictX] = true;
        }

        //7
        predictX = this.getPositionInArrayX() - 2;
        predictY = this.getPositionInArrayY() + 1;
        if (!(predictX < 0) && !(predictY > 7) && !checkForAllyFigure(predictX, predictY)) {
            this.steps[predictY][predictX] = true;
        }

        //8
        predictX = this.getPositionInArrayX() - 2;
        predictY = this.getPositionInArrayY() - 1;
        if (!(predictX < 0) && !(predictY < 0) && !checkForAllyFigure(predictX, predictY)) {
            this.steps[predictY][predictX] = true;
        }

    }

    public boolean checkForAllyFigure(int x, int y) {
        Figure figure = ChessBoardLogic.figuresArray[y][x];
        return figure != null && figure.getColor().equals(this.getColor());
    }
}
