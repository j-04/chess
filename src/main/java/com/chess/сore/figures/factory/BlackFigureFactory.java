package com.chess.сore.figures.factory;

import com.chess.сore.figures.abstrac.Figure;
import com.chess.сore.figures.black.*;
import com.chess.сore.figures.builder.BlackFigureDirector;
import com.chess.сore.figures.builder.Builder;
import com.chess.сore.figures.builder.Director;
import com.chess.сore.figures.builder.FigureBuilder;

import java.awt.*;

import static com.chess.сore.util.FigureUtil.*;

public class BlackFigureFactory implements FigureFactory {
    private Builder builder = new FigureBuilder();
    private Director director = new BlackFigureDirector(builder);
    private Color color = Color.WHITE;

    @Override
    public Figure createPawn(int x, int y) {
        Figure figure = director.buildPawn()
                .setX(x)
                .setY(y)
                .setColor(color)
                .setPicture(pictures.get(BlackPawn.class))
                .getResult();
        builder.reset();
        return figure;
    }

    @Override
    public Figure createRook(int x, int y) {
        Figure figure = director.buildRook()
                .setX(x)
                .setY(y)
                .setColor(color)
                .setPicture(pictures.get(BlackRook.class))
                .getResult();
        builder.reset();
        return figure;
    }

    @Override
    public Figure createKnight(int x, int y) {
        Figure figure = director.buildKnight()
                .setX(x)
                .setY(y)
                .setColor(color)
                .setPicture(pictures.get(BlackKnight.class))
                .getResult();
        builder.reset();
        return figure;
    }

    @Override
    public Figure createBishop(int x, int y) {
        Figure figure = director.buildBishop()
                .setX(x)
                .setY(y)
                .setColor(color)
                .setPicture(pictures.get(BlackBishop.class))
                .getResult();
        builder.reset();
        return figure;
    }

    @Override
    public Figure createQueen(int x, int y) {
        Figure figure = director.buildQueen()
                .setX(x)
                .setY(y)
                .setColor(color)
                .setPicture(pictures.get(BlackQueen.class))
                .getResult();
        builder.reset();
        return figure;
    }

    @Override
    public Figure createKing(int x, int y) {
        Figure figure = director.buildKing()
                .setX(x)
                .setY(y)
                .setColor(color)
                .setPicture(pictures.get(BlackKing.class))
                .getResult();
        builder.reset();
        return figure;
    }
}
