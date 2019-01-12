package com.app.chess.Core.ChessBoard;

import com.app.chess.Figures.BlackPieces.BlackPawn;
import com.app.chess.Figures.Figure;
import com.app.chess.Figures.OtherPieces.ChessBoardCell;
import com.app.chess.Figures.WhitePieces.WhitePawn;

import javax.swing.*;
import java.util.LinkedList;

public class ChessBoardLogic {
    public static final Figure[][] figuresArray = new Figure[8][8];
    public static final LinkedList<Figure> figuresList = new LinkedList<>();
    public static final ChessBoardCell[][] panelsArray = new ChessBoardCell[8][8];
    public static boolean flag = true; //true = Black, false = White

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

    public void checkPawnsForChange() {
        for (Figure figure: figuresList) {
            if (figure instanceof WhitePawn && figure.getPositionInArrayY() == 0) {
                changeWhitePawn(figure);
            } else {
                if (figure instanceof BlackPawn && figure.getPositionInArrayY() == 7) {
                    changeBlackPawn(figure);
                }
            }
        }
    }

    private void changeWhitePawn(Figure figure) {

    }

    private void changeBlackPawn(Figure figure) {

    }

    public void setLayeredPane(JLayeredPane layeredPane) {
        this.layeredPane = layeredPane;
    }

    public static void changeTurn() {
        flag = !flag;
    }
}
