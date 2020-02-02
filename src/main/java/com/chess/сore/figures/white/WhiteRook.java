package com.chess.сore.figures.white;

import com.chess.сore.сhessboard.ChessBoardLogic;
import com.chess.сore.figures.abstrac.Rook;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class WhiteRook extends Rook {

    public WhiteRook(int x, int y, Color color) {
        super(x, y, color);

        JLabel label = new JLabel();

        try {
            label.setIcon(new ImageIcon(ImageIO.read(new File("src//main//resources//Chess pieces//Chess_rlt60.png"))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        add(label);
    }

    @Override
    public void predictSteps() {
        int x = this.getPositionInArrayX();
        int y = this.getPositionInArrayY();
        boolean metAnAllyFigure = false;
        boolean metAnEnemyFigure = false;

        //Очистка массива с предиктами ходов
        for (int i = 0; i < steps.length; i++) {
            for (int k = 0; k < steps.length; k++) {
                steps[i][k] = false;
            }
        }

        //Предикт ходов по вертикали вверх от позиции фигуры
        for (int i = y; i >= 0; i--) {
            if (!metAnAllyFigure) {
                metAnAllyFigure = checkForAllyFigure(x, i);
            }

            if (!metAnAllyFigure && !metAnEnemyFigure) {
                if (i != y)
                    this.steps[i][x] = true;
            } else
                continue;

            metAnEnemyFigure = checkForEnemyFigure(x, i);
            if (metAnEnemyFigure) {
                this.steps[i][x] = true;
            }
        }

        metAnAllyFigure = false;
        metAnEnemyFigure = false;
        //Предикт ходов по вертикали вниз от позиции фигуры
        for (int i = y; i < 8; i++) {
            if (!metAnAllyFigure) {
                metAnAllyFigure = checkForAllyFigure(x, i);
            }

            if (!metAnAllyFigure && !metAnEnemyFigure) {
                if (i != y)
                    this.steps[i][x] = true;
            } else
                continue;

            metAnEnemyFigure = checkForEnemyFigure(x, i);
            if (metAnEnemyFigure) {
                this.steps[i][x] = true;
            }
        }

        metAnAllyFigure = false;
        metAnEnemyFigure = false;
        //Предикт ходов по горизонтали влево от позиции фигуры
        for (int i = x; i >= 0; i--) {
            if (!metAnAllyFigure) {
                metAnAllyFigure = checkForAllyFigure(i, y);
            }

            if (!metAnAllyFigure && !metAnEnemyFigure) {
                if (i != x)
                    this.steps[y][i] = true;
            } else
                continue;

            metAnEnemyFigure = checkForEnemyFigure(i, y);
            if (metAnEnemyFigure) {
                this.steps[y][i] = true;
            }
        }

        metAnAllyFigure = false;
        metAnEnemyFigure = false;
        //Предикт ходов по горизонтали вправо от позиции фигуры
        for (int i = x; i < 8; i++) {
            if (!metAnAllyFigure) {
                metAnAllyFigure = checkForAllyFigure(i, y);
            }

            if (!metAnAllyFigure && !metAnEnemyFigure) {
                if (i != x)
                    this.steps[y][i] = true;
            } else
                continue;

            metAnEnemyFigure = checkForEnemyFigure(i, y);
            if (metAnEnemyFigure) {
                this.steps[y][i] = true;
            }
        }
    }

    private boolean checkForAllyFigure(int x, int y) {
        return ChessBoardLogic.figuresArray[y][x] != null && ChessBoardLogic.figuresArray[y][x].getColor().equals(this.getColor()) && ChessBoardLogic.figuresArray[y][x] != this;
    }

    private boolean checkForEnemyFigure(int x, int y) {
        return ChessBoardLogic.figuresArray[y][x] != null && !ChessBoardLogic.figuresArray[y][x].getColor().equals(this.getColor());
    }
}
