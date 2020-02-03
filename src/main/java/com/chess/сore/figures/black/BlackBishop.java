package com.chess.сore.figures.black;

import com.chess.сore.figures.abstrac.Bishop;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BlackBishop extends Bishop {
    public BlackBishop() {
    }

    @Override
    public void predictSteps() {
        clearPredictions();
        int figureX = this.getPositionInArrayX();
        int figureY = this.getPositionInArrayY();
        //По диагонали влево вверх от позиции фигуры
        predictUpToLeft(figureX, figureY);
        //По диагонали вправо вверх от позиции фигуры
        predictUpToRight(figureX, figureY);
        //По диагонали влево вниз от позиции фигуры
        predictDownToLeft(figureX, figureY);
        //По диагонали вправо вниз от позиции фигуры
        predictDownToRight(figureX, figureY);
    }

    private void predictUpToLeft(int x, int y) {
        if (x >= 0 && y >= 0) {
            if (this.getPositionInArrayY() != y && this.getPositionInArrayX() != x) {
                boolean metAnAllyFigure = checkForAllyFigure(x, y);
                boolean metAnEnemyFigure = checkForEnemyFigure(x, y);
                if (metAnEnemyFigure) {
                    this.steps[y][x] = true;
                    return;
                }
                if (!metAnAllyFigure)
                    this.steps[y][x] = true;
                else
                    return;
                predictUpToLeft(x - 1, y - 1);
            } else
                predictUpToLeft(x - 1, y - 1);
        }
    }

    private void predictUpToRight(int x, int y) {
        if (x <= 7 && y >= 0) {
            if (this.getPositionInArrayY() != y && this.getPositionInArrayX() != x) {
                boolean metAnAllyFigure = checkForAllyFigure(x, y);
                boolean metAnEnemyFigure = checkForEnemyFigure(x, y);
                if (metAnEnemyFigure) {
                    this.steps[y][x] = true;
                    return;
                }
                if (!metAnAllyFigure)
                    this.steps[y][x] = true;
                else
                    return;
                predictUpToRight(x + 1, y - 1);
            } else
                predictUpToRight(x + 1, y - 1);
        }
    }

    private void predictDownToLeft(int x, int y) {
        if (x >= 0 && y <= 7) {
            if (this.getPositionInArrayY() != y && this.getPositionInArrayX() != x) {
                boolean metAnAllyFigure = checkForAllyFigure(x, y);
                boolean metAnEnemyFigure = checkForEnemyFigure(x, y);
                if (metAnEnemyFigure) {
                    this.steps[y][x] = true;
                    return;
                }
                if (!metAnAllyFigure)
                    this.steps[y][x] = true;
                else
                    return;
                predictDownToLeft(x - 1, y + 1);
            } else
                predictDownToLeft(x - 1, y + 1);
        }
    }

    private void predictDownToRight(int x, int y) {
        if (x <= 7 && y <= 7) {
            if (this.getPositionInArrayY() != y && this.getPositionInArrayX() != x) {
                boolean metAnAllyFigure = checkForAllyFigure(x, y);
                boolean metAnEnemyFigure = checkForEnemyFigure(x, y);
                if (metAnEnemyFigure) {
                    this.steps[y][x] = true;
                    return;
                }
                if (!metAnAllyFigure)
                    this.steps[y][x] = true;
                else
                    return;
                predictDownToRight(x + 1, y + 1);
            } else
                predictDownToRight(x + 1, y + 1);
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
