package com.chess.сore.figures.factory;

import com.chess.сore.figures.abstrac.Figure;
import com.chess.сore.figures.builder.Builder;
import com.chess.сore.figures.builder.Director;
import com.chess.сore.figures.builder.FigureBuilder;
import com.chess.сore.figures.builder.WhiteFigureDirector;
import com.chess.сore.figures.white.*;

import java.awt.*;

import static com.chess.сore.util.FigureUtil.*;

public class WhiteFigureFactory implements FigureFactory {
    private Color color = Color.BLACK;
    private Builder builder = new FigureBuilder();
    private Director director = new WhiteFigureDirector(builder);

    @Override
    public Figure createPawn(int x, int y) {
        Figure figure = director.buildPawn()
                .setX(x)
                .setY(y)
                .setColor(color)
                .setPicture(pictures.get(WhitePawn.class))
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
                .setPicture(pictures.get(WhiteRook.class))
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
                .setPicture(pictures.get(WhiteKnight.class))
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
                .setPicture(pictures.get(WhiteBishop.class))
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
                .setPicture(pictures.get(WhiteQueen.class))
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
                .setPicture(pictures.get(WhiteKing.class))
                .getResult();
        builder.reset();
        return figure;
    }
}
