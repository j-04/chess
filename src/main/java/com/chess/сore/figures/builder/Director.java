package com.chess.сore.figures.builder;

public interface Director {
    Builder buildPawn();
    Builder buildBishop();
    Builder buildRook();
    Builder buildKnight();
    Builder buildQueen();
    Builder buildKing();
}
