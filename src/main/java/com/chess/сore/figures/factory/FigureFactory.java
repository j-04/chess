package com.chess.сore.figures.factory;

import com.chess.сore.figures.abstrac.Figure;

public interface FigureFactory {
    Figure createPawn(int x, int y);
    Figure createRook(int x, int y);
    Figure createKnight(int x, int y);
    Figure createBishop(int x, int y);
    Figure createQueen(int x, int y);
    Figure createKing(int x, int y);
}
