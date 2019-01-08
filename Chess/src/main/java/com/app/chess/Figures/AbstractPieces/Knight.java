package com.app.chess.Figures.AbstractPieces;

import com.app.chess.Figures.Figure;

import java.awt.*;

public abstract class Knight extends Figure {
    public Knight(int x, int y, Color color){
        moveTo(x, y);
        setOpaque(false);
        setColor(color);
        setBounds(getPositionOnBoardX(),getPositionOnBoardY(), getWidth(), getHeight());
    }
}