package com.app.chess.Core.Handlers;

import com.app.chess.Core.ChessBoard.ChessBoardLogic;
import com.app.chess.Figures.Figure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EventListener extends MouseAdapter {
    private Point old;
    private Figure piece;
    private JLayeredPane containPane;
    private MoveHandler moveHandler;

    public EventListener(Figure piece, JLayeredPane containPane, MoveHandler moveHandler) {
        this.piece = piece;
        this.moveHandler = moveHandler;
        this.containPane = containPane;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        if (checkTurn() == 1) {
            old = e.getPoint();
            containPane.moveToFront(piece);
            piece.showFigureMoves();
        }

        if (checkTurn() == 0) {
            old = e.getPoint();
            containPane.moveToFront(piece);
            piece.showFigureMoves();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        if (checkTurn() == 1) {
            if (piece.getX() > -1 && piece.getY() > -1 && piece.getX() <= 800 && piece.getY() <= 800)
                piece.setBounds(piece.getX() + e.getX() - (int) old.getX(), piece.getY() + e.getY() - (int) old.getY(), piece.getWidth(), piece.getHeight());
            else
                stayOnBoard();
        }
        if (checkTurn() == 0) {
            if (piece.getX() > -1 && piece.getY() > -1 && piece.getX() <= 800 && piece.getY() <= 800)
                piece.setBounds(piece.getX() + e.getX() - (int) old.getX(), piece.getY() + e.getY() - (int) old.getY(), piece.getWidth(), piece.getHeight());
            else
                stayOnBoard();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        if (checkTurn() == 1) {
            stayOnBoard();
            moveHandler.moveFigure();
            piece.returnNativeCellColor();
        }

        if (checkTurn() == 0) {
            stayOnBoard();
            moveHandler.moveFigure();
            piece.returnNativeCellColor();
        }
    }

    private void stayOnBoard() {
        if (piece.getX() < 0) {
            piece.setBounds(0, piece.getY(), piece.getWidth(), piece.getHeight());
        }
        if (piece.getY() < 0) {
            piece.setBounds(piece.getX(), 0, piece.getWidth(), piece.getHeight());
        }
        if (piece.getX() + piece.getWidth() > 800) {
            piece.setBounds(800 - piece.getWidth(), piece.getY(), piece.getWidth(), piece.getHeight());
        }
        if (piece.getY() + piece.getHeight() > 800) {
            piece.setBounds(piece.getX(), 800 - piece.getHeight(), piece.getWidth(), piece.getHeight());
        }
    }

    private int checkTurn() {
        if (piece.getColor().equals(Color.BLACK) && ChessBoardLogic.flag) {
            return 1;
        } else {
            if (piece.getColor().equals(Color.WHITE) && !ChessBoardLogic.flag) {
                return 0;
            } else
                return -1;
        }
    }
}

