package com.chess.сore.figures.white;

import com.chess.сore.figures.abstrac.King;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class WhiteKing extends King {
    public WhiteKing() {

    }

    @Override
    public void predictSteps() {
        clearPredictions();
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
