package com.chess.сore.figures.white;

import com.chess.сore.figures.abstrac.Knight;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class WhiteKnight extends Knight {
    public WhiteKnight() {
    }

    @Override
    public void predictSteps() {
        clearPredictions();
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
