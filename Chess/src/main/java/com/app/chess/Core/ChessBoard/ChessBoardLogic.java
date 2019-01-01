package com.app.chess.Core.ChessBoard;

import com.app.chess.Figures.Figure;

import javax.swing.*;
import java.util.LinkedList;

public class ChessBoardLogic {
    public static final Figure[][] figuresArray = new Figure[8][8];
    public static final LinkedList<Figure> figuresList = new LinkedList<>();
    private JLayeredPane layeredPane;

    public void removeFigure(Figure figureToRemove) {
        ChessBoardLogic.figuresList.remove(figureToRemove);
        layeredPane.remove(figureToRemove);
    }

    public void predictStepsOfAllFigures() {
        for (Figure figure: ChessBoardLogic.figuresList) {
            figure.predictSteps();
        }
    }

    public void setLayeredPane(JLayeredPane layeredPane) {
        this.layeredPane = layeredPane;
    }
}
