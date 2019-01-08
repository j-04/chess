package com.app.chess.Figures.AbstractPieces;

import com.app.chess.Figures.Figure;

import java.awt.*;

public abstract class Bishop extends Figure {
    public Bishop(int x, int y, Color color){
        moveTo(x, y);
        setOpaque(false);
        setColor(color);
        setBounds(getPositionOnBoardX(),getPositionOnBoardY(), getWidth(), getHeight());
    }
}
