package com.app.chess.Figures.AbstractPieces;

import com.app.chess.Figures.Figure;

import java.awt.*;

public abstract class Rook extends Figure {

    public Rook(int x, int y, Color color){
        moveTo(x, y);
        setBackground(color);
        setColor(color);
        setBounds(getPositionOnBoardX(),getPositionOnBoardY(), getWidth(), getHeight());
    }
}
