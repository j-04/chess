package com.chess.сore.handlers;

import com.chess.сore.figures.abstrac.Figure;
import com.chess.сore.figures.abstrac.Pawn;
import com.chess.сore.figures.factory.BlackFigureFactory;
import com.chess.сore.figures.factory.FigureFactory;
import com.chess.сore.figures.factory.WhiteFigureFactory;
import com.chess.сore.сhessboard.ChessBoardGraphics;
import com.chess.сore.сhessboard.ChessBoardLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener {
    private JPanel owner;
    private Pawn figure;
    private JDialog rootDialog;

    public Mouse(JDialog rootDialog, JPanel owner, Pawn figure) {
        this.owner = owner;
        this.figure = figure;
        this.rootDialog = rootDialog;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        determinateAndChangeFigure();
        rootDialog.dispose();
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        owner.setBackground(new Color(0,100,0));
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        owner.setBackground(Color.WHITE);
    }

    private void determinateAndChangeFigure() {
        ChessBoardLogic chessBoardLogic = ChessBoardLogic.getInstance();
        ChessBoardGraphics chessBoardGraphics = ChessBoardGraphics.getInstance();

        FigureFactory whiteFigureFactory = new WhiteFigureFactory();
        FigureFactory blackFigureFactory = new BlackFigureFactory();

        int x = figure.getPositionInArrayX();
        int y = figure.getPositionInArrayY();
        chessBoardLogic.removeFigure(figure);

        switch(owner.getName()) {
            case "WhiteRook":
                registerFigure(x, y, whiteFigureFactory.createRook(x, y));
                break;

            case "WhiteKnight":
                registerFigure(x, y, whiteFigureFactory.createKnight(x, y));
                break;

            case "WhiteBishop":
                registerFigure(x, y, whiteFigureFactory.createBishop(x, y));
                break;

            case "WhiteQueen":
                registerFigure(x, y, whiteFigureFactory.createQueen(x, y));
                break;

            case "BlackRook":
                registerFigure(x, y, blackFigureFactory.createRook(x, y));
                break;

            case "BlackKnight":
                registerFigure(x, y, blackFigureFactory.createKnight(x, y));
                break;

            case "BlackBishop":
                registerFigure(x, y, blackFigureFactory.createBishop(x, y));
                break;

            case "BlackQueen":
                registerFigure(x, y, blackFigureFactory.createQueen(x, y));
                break;
        }
        chessBoardGraphics.render();
    }

    private void registerFigure(int x, int y, Figure figure) {
        ChessBoardLogic.figuresArray[y][x] = figure;
        ChessBoardLogic.figuresList.add(figure);
    }
}