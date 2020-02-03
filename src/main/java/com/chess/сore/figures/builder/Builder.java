package com.chess.сore.figures.builder;

import com.chess.сore.figures.abstrac.Figure;

import java.awt.*;

public interface Builder {
    Builder setResult(Figure result);
    Builder setX(int x);
    Builder setY(int y);
    Builder setColor(Color color);
    Builder setPicture(String picturePath);
    Builder reset();
    Figure getResult();
}
