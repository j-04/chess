package com.chess.сore.figures.abstrac;

import java.awt.*;

public abstract class Queen extends Figure {
    public Queen(int x, int y, Color color){
        moveTo(x, y);
        setOpaque(false);
        setColor(color);
        setBounds(getPositionOnBoardX(),getPositionOnBoardY(), getWidth(), getHeight());
    }
}
