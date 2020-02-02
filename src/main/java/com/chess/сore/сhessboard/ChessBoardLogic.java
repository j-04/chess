package com.chess.сore.сhessboard;

import com.chess.сore.figures.abstrac.Pawn;
import com.chess.сore.figures.black.BlackPawn;
import com.chess.сore.figures.abstrac.Figure;
import com.chess.сore.figures.other.ChessBoardCell;
import com.chess.сore.figures.white.WhitePawn;

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

    private ChessBoardLogic(JFrame root, JLayeredPane layeredPane) {
        this.layeredPane = layeredPane;
        this.root = root;
    }

    public void removeFigure(Figure figureToRemove) {
        ChessBoardLogic.figuresList.remove(figureToRemove);
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
            if (pawn.getColor().equals(Color.BLACK))
                changeWhitePawn(pawn);
            else
                if (pawn.getColor().equals(Color.WHITE)) {
                    changeBlackPawn(pawn);
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

    public static void setInstance(JFrame root, JLayeredPane layeredPane) {
        if (instance == null)
            instance = new ChessBoardLogic(root, layeredPane);
    }

    public static ChessBoardLogic getInstance() {
        if (instance == null)
            throw new NullPointerException();
        return instance;
    }
}
