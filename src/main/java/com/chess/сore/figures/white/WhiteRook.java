package com.chess.сore.figures.white;

import com.chess.сore.figures.abstrac.Rook;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class WhiteRook extends Rook {

    public WhiteRook() {
    }

    @Override
    public void predictSteps() {
        int x = this.getPositionInArrayX();
        int y = this.getPositionInArrayY();
        boolean metAnAllyFigure = false;
        boolean metAnEnemyFigure = false;

        clearPredictions();

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
