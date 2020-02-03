package com.chess.сore.figures.builder;

import com.chess.сore.figures.abstrac.Figure;
import com.chess.сore.handlers.EventListener;
import com.chess.сore.handlers.MoveHandler;

import java.awt.*;

public class FigureBuilder implements Builder {
    private Figure result;

    @Override
    public Builder setResult(Figure result) {
        if (this.result == null) {
            this.result = result;
        }
        return this;
    }

    @Override
    public Builder setX(int x) {
        if (result == null)
            return null;
        if (x < 0)
            return null;
        result.setPositionInArrayX(x);
        return this;
    }

    @Override
    public Builder setY(int y) {
        if (result == null)
            return null;
        if (y < 0)
            return null;
        result.setPositionInArrayY(y);
        return this;
    }

    @Override
    public Builder setColor(Color color) {
        if (result == null)
            return null;
        result.setColor(color);
        return this;
    }

    @Override
    public Builder setPicture(String picturePath) {
        if (result == null)
            return null;
        if (picturePath == null || picturePath.isEmpty())
            return null;
        result.setPicturePath(picturePath);
        result.setSettings();
        return this;
    }

    @Override
    public Builder reset() {
        result = null;
        return this;
    }

    @Override
    public Figure getResult() {
        if (result == null)
            return null;
        result.move();
        result.setBounds();
        result.setOpaque();
        MoveHandler moveHandler = new MoveHandler(result);
        EventListener move = new EventListener(result, moveHandler);
        result.addMouseListener(move);
        result.addMouseMotionListener(move);
        return result;
    }
}
