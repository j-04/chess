package com.chess.сore.figures.abstrac;

import java.awt.*;

public abstract class King extends Figure {
    public King(int x, int y, Color color){
        moveTo(x, y);
        setOpaque(false);
        setColor(color);
        setBounds(getPositionOnBoardX(),getPositionOnBoardY(), getWidth(), getHeight());
    }
}
