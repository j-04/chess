package com.app.chess.Core.Handlers;

import com.app.chess.Core.ChessBoard.ChessBoardLogic;
import com.app.chess.Figures.AbstractPieces.Pawn;
import com.app.chess.Figures.BlackPieces.BlackBishop;
import com.app.chess.Figures.BlackPieces.BlackKnight;
import com.app.chess.Figures.BlackPieces.BlackQueen;
import com.app.chess.Figures.BlackPieces.BlackRook;
import com.app.chess.Figures.WhitePieces.WhiteBishop;
import com.app.chess.Figures.WhitePieces.WhiteKnight;
import com.app.chess.Figures.WhitePieces.WhiteQueen;
import com.app.chess.Figures.WhitePieces.WhiteRook;

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
        JLayeredPane layeredPane = ChessBoardLogic.getInstance().getLayeredPane();

        int x = figure.getPositionInArrayX();
        int y = figure.getPositionInArrayY();
        chessBoardLogic.removeFigure(figure);

        switch(owner.getName()) {
            case "WhiteRook":
                WhiteRook rook = new WhiteRook(x, y, Color.BLACK);
                MoveHandler moveRook = new MoveHandler(rook, chessBoardLogic);
                EventListener eventRook = new EventListener(rook, layeredPane, moveRook);
                rook.addMouseListener(eventRook);
                rook.addMouseMotionListener(eventRook);
                layeredPane.add(rook,0);
                ChessBoardLogic.figuresArray[y][x] = rook;
                ChessBoardLogic.figuresList.add(rook);
                break;

            case "WhiteKnight":
                WhiteKnight knight = new WhiteKnight(x, y, Color.BLACK);
                MoveHandler moveKnight = new MoveHandler(knight, chessBoardLogic);
                EventListener eventKnight = new EventListener(knight, layeredPane, moveKnight);
                knight.addMouseListener(eventKnight);
                knight.addMouseMotionListener(eventKnight);
                layeredPane.add(knight,0);
                ChessBoardLogic.figuresArray[y][x] = knight;
                ChessBoardLogic.figuresList.add(knight);
                break;

            case "WhiteBishop":
                WhiteBishop bishop = new WhiteBishop(x, y, Color.BLACK);
                MoveHandler moveBishop = new MoveHandler(bishop, chessBoardLogic);
                EventListener eventBishop = new EventListener(bishop, layeredPane, moveBishop);
                bishop.addMouseListener(eventBishop);
                bishop.addMouseMotionListener(eventBishop);
                layeredPane.add(bishop,0);
                ChessBoardLogic.figuresArray[y][x] = bishop;
                ChessBoardLogic.figuresList.add(bishop);
                break;

            case "WhiteQueen":
                WhiteQueen queen = new WhiteQueen(x, y, Color.BLACK);
                MoveHandler moveQueen = new MoveHandler(queen, chessBoardLogic);
                EventListener eventQueen = new EventListener(queen, layeredPane, moveQueen);
                queen.addMouseListener(eventQueen);
                queen.addMouseMotionListener(eventQueen);
                layeredPane.add(queen,0);
                ChessBoardLogic.figuresArray[y][x] = queen;
                ChessBoardLogic.figuresList.add(queen);
                break;

            case "BlackRook":
                BlackRook blackRook = new BlackRook(x, y, Color.WHITE);
                MoveHandler moveRook1 = new MoveHandler(blackRook, chessBoardLogic);
                EventListener eventRook1 = new EventListener(blackRook, layeredPane, moveRook1);
                blackRook.addMouseListener(eventRook1);
                blackRook.addMouseMotionListener(eventRook1);
                layeredPane.add(blackRook,0);
                ChessBoardLogic.figuresArray[y][x] = blackRook;
                ChessBoardLogic.figuresList.add(blackRook);
                break;

            case "BlackKnight":
                BlackKnight blackKnight = new BlackKnight(x, y, Color.WHITE);
                MoveHandler moveKnight1 = new MoveHandler(blackKnight, chessBoardLogic);
                EventListener eventKnight1 = new EventListener(blackKnight, layeredPane, moveKnight1);
                blackKnight.addMouseListener(eventKnight1);
                blackKnight.addMouseMotionListener(eventKnight1);
                layeredPane.add(blackKnight,0);
                ChessBoardLogic.figuresArray[y][x] = blackKnight;
                ChessBoardLogic.figuresList.add(blackKnight);
                break;

            case "BlackBishop":
                BlackBishop blackBishop = new BlackBishop(x, y, Color.WHITE);
                MoveHandler moveBishop1 = new MoveHandler(blackBishop, chessBoardLogic);
                EventListener eventBishop1 = new EventListener(blackBishop, layeredPane, moveBishop1);
                blackBishop.addMouseListener(eventBishop1);
                blackBishop.addMouseMotionListener(eventBishop1);
                layeredPane.add(blackBishop,0);
                ChessBoardLogic.figuresArray[y][x] = blackBishop;
                ChessBoardLogic.figuresList.add(blackBishop);
                break;

            case "BlackQueen":
                BlackQueen blackQueen = new BlackQueen(x, y, Color.WHITE);
                MoveHandler moveQueen1 = new MoveHandler(blackQueen, chessBoardLogic);
                EventListener eventQueen1 = new EventListener(blackQueen, layeredPane, moveQueen1);
                blackQueen.addMouseListener(eventQueen1);
                blackQueen.addMouseMotionListener(eventQueen1);
                layeredPane.add(blackQueen,0);
                ChessBoardLogic.figuresArray[y][x] = blackQueen;
                ChessBoardLogic.figuresList.add(blackQueen);
                break;
        }
    }
}
