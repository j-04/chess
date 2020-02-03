package com.chess.сore.figures.black;

import com.chess.сore.figures.abstrac.Figure;
import com.chess.сore.figures.abstrac.Pawn;
import com.chess.сore.сhessboard.ChessBoardLogic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BlackPawn extends Pawn {
    public BlackPawn() {
    }

    @Override
    public void predictSteps() {
        clearPredictions();

        //Первый ход в игре. Можно сделать ход на две клетки вперед
        if (firstStep) {
            steps[this.getPositionInArrayY() + 2][this.getPositionInArrayX()] = true;
        }

        //Ход на одну клетку вперед
        if (this.getPositionInArrayY() != 7 && (ChessBoardLogic.figuresArray[this.getPositionInArrayY() + 1][this.getPositionInArrayX()] == null)) {
            steps[this.getPositionInArrayY() + 1][this.getPositionInArrayX()] = true;
        }

        Figure figure = null;

        //Уничтожение вражеской фигуры слева по диагонали от пешки
        if (this.getPositionInArrayX() != 0 && this.getPositionInArrayY() != 7)
            figure = ChessBoardLogic.figuresArray[this.getPositionInArrayY() + 1][this.getPositionInArrayX() - 1];

        if (figure != null && !figure.getColor().equals(this.getColor()) && this.getPositionInArrayX() != 0 && this.getPositionInArrayY() != 7) {
            steps[this.getPositionInArrayY() + 1][this.getPositionInArrayX() - 1] = true;
        }

        //Уничтожение вражеской фигуры справа по диагонали от пешки
        if (this.getPositionInArrayX() != 7  && this.getPositionInArrayY() != 7)
            figure = ChessBoardLogic.figuresArray[this.getPositionInArrayY() + 1][this.getPositionInArrayX() + 1];

        if (figure != null && !figure.getColor().equals(this.getColor()) && this.getPositionInArrayX() != 7 && this.getPositionInArrayY() != 7) {
            steps[this.getPositionInArrayY() + 1][this.getPositionInArrayX() + 1] = true;
        }
    }

    @Override
    public void setSettings() {
        JLabel label = new JLabel();
        try {
            label.setIcon(new ImageIcon(ImageIO.read(new File(picturePath))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        add(label);
        predictSteps();
    }
}
