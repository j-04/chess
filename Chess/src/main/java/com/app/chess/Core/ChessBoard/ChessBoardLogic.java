package com.app.chess.Core.ChessBoard;

import com.app.chess.Figures.AbstractPieces.Pawn;
import com.app.chess.Figures.BlackPieces.BlackPawn;
import com.app.chess.Figures.Figure;
import com.app.chess.Figures.OtherPieces.ChessBoardCell;
import com.app.chess.Figures.WhitePieces.WhitePawn;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class ChessBoardLogic {
    public static boolean flag = true; //true = Black, false = White

    public static final Figure[][] figuresArray = new Figure[8][8];
    public static final LinkedList<Figure> figuresList = new LinkedList<>();
    public static final ChessBoardCell[][] panelsArray = new ChessBoardCell[8][8];

    private JLayeredPane layeredPane;
    private JFrame root;
    private static ChessBoardLogic instance;

    private ChessBoardLogic(JFrame root) {
        this.root = root;
    }

    public void removeFigure(Figure figureToRemove) {
        System.out.println(figureToRemove);
        System.out.println(figureToRemove.getPositionInArrayY());
        System.out.println(figureToRemove.getPositionInArrayX());

        boolean a = ChessBoardLogic.figuresList.remove(figureToRemove);
        System.out.println(a);
        ChessBoardLogic.figuresArray[figureToRemove.getPositionInArrayY()][figureToRemove.getPositionInArrayX()] = null;
        layeredPane.remove(figureToRemove);
    }

    public void predictStepsOfAllFigures() {
        for (Figure figure: ChessBoardLogic.figuresList) {
            figure.predictSteps();
        }
    }

    public void checkPawnsToChange() {
        Pawn pawn = null;
        for (Figure figure: figuresList) {
            if (figure instanceof WhitePawn && figure.getPositionInArrayY() == 0) {
                pawn = (Pawn) figure;
                break;
            } else {
                if (figure instanceof BlackPawn && figure.getPositionInArrayY() == 7) {
                    pawn = (Pawn) figure;
                    break;
                }
            }
        }

        if (pawn != null) {
            if (pawn.getColor().equals(Color.BLACK)) {
                changeWhitePawn(pawn);
            } else {
                if (pawn.getColor().equals(Color.WHITE)) {
                    changeBlackPawn(pawn);
                }
            }
        }
    }

    private void changeWhitePawn(Pawn pawn) {
        ChessPawnChanger chessPawnChanger = new ChessPawnChanger(root);
        chessPawnChanger.chooseWhiteFigure(pawn);
    }

    private void changeBlackPawn(Pawn pawn) {
        ChessPawnChanger chessPawnChanger = new ChessPawnChanger(root);
        chessPawnChanger.chooseBlackFigure(pawn);
    }

    public void setLayeredPane(JLayeredPane layeredPane) {
        this.layeredPane = layeredPane;
    }

    public static void changeTurn() {
        flag = !flag;
    }

    public static ChessBoardLogic getInstance(JFrame root) {
        if (instance == null) {
            instance = new ChessBoardLogic(root);
        }
        return instance;
    }

    public static ChessBoardLogic getInstance() {
        if (instance == null) {
            throw new NullPointerException();
        }
        return instance;
    }

    public JLayeredPane getLayeredPane() {
        return this.layeredPane;
    }
}
