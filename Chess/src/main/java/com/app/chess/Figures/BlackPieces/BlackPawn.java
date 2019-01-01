package com.app.chess.Figures.BlackPieces;

import com.app.chess.Core.ChessBoard.ChessBoardLogic;
import com.app.chess.Figures.AbstractPieces.Pawn;
import com.app.chess.Figures.Figure;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BlackPawn extends Pawn {

    public BlackPawn(int x, int y, Color color) {
        super(x, y, color);

        JLabel label = new JLabel();

        try {
            label.setIcon(new ImageIcon(ImageIO.read(new File("src//main//resources//Chess pieces//Chess_pdt60.png"))));
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
}
