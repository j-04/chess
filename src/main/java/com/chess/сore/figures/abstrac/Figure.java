package com.chess.сore.figures.abstrac;

import com.chess.сore.figures.other.ChessBoardCell;
import com.chess.сore.сhessboard.ChessBoardLogic;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public abstract class Figure extends JPanel implements IFigure {
    private int positionOnBoardX;
    private int positionOnBoardY;

    private int positionInArrayX;
    private int positionInArrayY;

    protected boolean firstStep = true;

    protected boolean[][] steps = new boolean[8][8];
    private Color color;
    protected String picturePath;

    public Figure() {
    }

    public abstract void setSettings();

    public void setColor(Color color){
        this.color = color;

        if(!color.equals(Color.WHITE))
            setBorder(BorderFactory.createLineBorder(Color.WHITE,4));
        else
            setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
    }

    public boolean[][] getSteps(){
        return steps;
    }

    @Override
    public int getWidth(){
        return 100;
    }

    @Override
    public int getHeight(){
        return 100;
    }

    @Override
    public void move() {
        this.positionOnBoardX = this.positionInArrayX * 100;
        this.positionOnBoardY = this.positionInArrayY * 100;
    }

    public void setBounds() {
        this.setBounds(getPositionOnBoardX(), getPositionOnBoardY(), getWidth(), getHeight());
    }

    public void setOpaque() {
        this.setOpaque(false);
    }

    public void showFigureMoves() {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (steps[y][x]) {
                    ChessBoardCell panel = ChessBoardLogic.panelsArray[y][x];
                    panel.setNewColor(new Color(0, 100, 0));
                    panel.setBorder(BorderFactory.createLineBorder(panel.getNativeColor(), 5));
                }
            }
        }
    }

    public void returnNativeCellColor() {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                ChessBoardCell panel = ChessBoardLogic.panelsArray[y][x];
                panel.setNativeColor();
            }
        }
    }

    protected void clearPredictions() {
        for (int i = 0; i < steps.length; i++) {
            for (int k = 0; k < steps.length; k++) {
                steps[i][k] = false;
            }
        }
    }

    protected boolean checkForAllyFigure(int x, int y) {
        return ChessBoardLogic.figuresArray[y][x] != null && ChessBoardLogic.figuresArray[y][x].getColor().equals(this.getColor()) && ChessBoardLogic.figuresArray[y][x] != this;
    }

    protected boolean checkForEnemyFigure(int x, int y) {
        return ChessBoardLogic.figuresArray[y][x] != null && !ChessBoardLogic.figuresArray[y][x].getColor().equals(this.getColor());
    }
}
