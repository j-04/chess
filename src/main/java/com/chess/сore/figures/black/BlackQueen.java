package com.chess.сore.figures.black;

import com.chess.сore.figures.abstrac.Queen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BlackQueen extends Queen {
    public BlackQueen() {
    }

    @Override
    public void predictSteps() {
        clearPredictions();
        int figureX = this.getPositionInArrayX();
        int figureY = this.getPositionInArrayY();
        boolean metAnAllyFigure = false;
        boolean metAnEnemyFigure = false;
        //Предикт ходов по вертикали вверх от позиции фигуры
        for (int i = figureY; i >= 0; i--) {
            if (!metAnAllyFigure) {
                metAnAllyFigure = checkForAllyFigure(figureX, i);
            }
            if (!metAnAllyFigure && !metAnEnemyFigure) {
                if (i != figureY)
                    this.steps[i][figureX] = true;
            } else
                continue;
            metAnEnemyFigure = checkForEnemyFigure(figureX, i);
            if (metAnEnemyFigure) {
                this.steps[i][figureX] = true;
            }
        }
        metAnAllyFigure = false;
        metAnEnemyFigure = false;
        //Предикт ходов по вертикали вниз от позиции фигуры
        for (int i = figureY; i < 8; i++) {
            if (!metAnAllyFigure) {
                metAnAllyFigure = checkForAllyFigure(figureX, i);
            }
            if (!metAnAllyFigure && !metAnEnemyFigure) {
                if (i != figureY)
                    this.steps[i][figureX] = true;
            } else
                continue;
            metAnEnemyFigure = checkForEnemyFigure(figureX, i);
            if (metAnEnemyFigure) {
                this.steps[i][figureX] = true;
            }
        }
        metAnAllyFigure = false;
        metAnEnemyFigure = false;
        //Предикт ходов по горизонтали влево от позиции фигуры
        for (int i = figureX; i >= 0; i--) {
            if (!metAnAllyFigure) {
                metAnAllyFigure = checkForAllyFigure(i, figureY);
            }
            if (!metAnAllyFigure && !metAnEnemyFigure) {
                if (i != figureX)
                    this.steps[figureY][i] = true;
            } else
                continue;
            metAnEnemyFigure = checkForEnemyFigure(i, figureY);
            if (metAnEnemyFigure) {
                this.steps[figureY][i] = true;
            }
        }
        metAnAllyFigure = false;
        metAnEnemyFigure = false;
        //Предикт ходов по горизонтали вправо от позиции фигуры
        for (int i = figureX; i < 8; i++) {
            if (!metAnAllyFigure) {
                metAnAllyFigure = checkForAllyFigure(i, figureY);
            }
            if (!metAnAllyFigure && !metAnEnemyFigure) {
                if (i != figureX)
                    this.steps[figureY][i] = true;
            } else
                continue;
            metAnEnemyFigure = checkForEnemyFigure(i, figureY);
            if (metAnEnemyFigure) {
                this.steps[figureY][i] = true;
            }
        }

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
