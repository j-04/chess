package com.app.chess.Figures;

public interface IFigure {
    void moveTo(int x, int y);

    void predictSteps();
}
