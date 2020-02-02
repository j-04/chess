package com.chess.сore.сhessboard;

import com.chess.сore.figures.abstrac.Figure;
import com.chess.сore.figures.black.*;
import com.chess.сore.figures.other.ChessBoardCell;
import com.chess.сore.figures.white.*;
import com.chess.сore.handlers.EventListener;
import com.chess.сore.handlers.MoveHandler;

import javax.swing.*;
import java.awt.*;

public class ChessBoardGraphics extends JFrame {
    private static ChessBoardGraphics instance;

    private JLayeredPane layeredPane;
    private ChessBoardLogic chessBoardLogic;

    private ChessBoardGraphics() {
        ChessBoardLogic.setInstance(this, layeredPane);
        chessBoardLogic = ChessBoardLogic.getInstance();
    }

    public void start() {
        setupWindow();
        chessBoardLogic.setLayeredPane(layeredPane);
    }

    private void setupWindow() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        short frameWidth = 800;
        short frameHeight = 830;
        setTitle("Chess");
        setSize(frameWidth, frameHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation((screenWidth - frameWidth) / 2, (screenHeight - frameHeight) / 2);
        setResizable(false);

        createChessBoard();
        createBlackPieces();
        createWhitePieces();

        chessBoardLogic.predictStepsOfAllFigures();
        render();

        setVisible(true);
    }

    private void createChessBoard() {
        layeredPane = new JLayeredPane();
        add(layeredPane);

        // Создание шахматной доски
        boolean color = false;
        short boardHeight = 800;

        for (int y = 0; y < boardHeight; y = y + 100 ) {
            short boardWidth = 800;
            for (int x = 0; x < boardWidth; x = x + 100) {
                Color cellColor;

                if (color)
                    cellColor = new Color(139,69,19);
                else
                    cellColor = new Color(222,184,136);

                ChessBoardCell chessBoardCell = new ChessBoardCell(x, y, 100, 100 , cellColor);
                ChessBoardLogic.panelsArray[y / 100][x / 100] = chessBoardCell;
                layeredPane.add(chessBoardCell, 0);
                color = !color;
            }
            color = !color;
        }
    }

    private void createBlackPieces() {
        //PAWNS
        for(int y = 0; y <= 7; y++) {
            for(int x = 0; x <= 7; x++) {
                if(y == 1){
                    BlackPawn pawn = new BlackPawn(x, y, Color.WHITE);
                    MoveHandler moveHandler = new MoveHandler(pawn);
                    EventListener move = new EventListener(pawn, moveHandler);
                    pawn.addMouseListener(move);
                    pawn.addMouseMotionListener(move);
                    ChessBoardLogic.figuresArray[y][x] = pawn;
                    ChessBoardLogic.figuresList.add(pawn);
                } else
                    ChessBoardLogic.figuresArray[y][x] = null;
            }
        }

        //ROOKS
        BlackRook rook = new BlackRook(0,0,Color.WHITE);
        MoveHandler moveRook1 = new MoveHandler(rook);
        EventListener eventRook1 = new EventListener(rook, moveRook1);
        rook.addMouseListener(eventRook1);
        rook.addMouseMotionListener(eventRook1);
        ChessBoardLogic.figuresArray[0][0] = rook;
        ChessBoardLogic.figuresList.add(rook);

        BlackRook rook2 = new BlackRook(7,0,Color.WHITE);
        MoveHandler moveRook2 = new MoveHandler(rook2);
        EventListener eventRook2 = new EventListener(rook2, moveRook2);
        rook2.addMouseListener(eventRook2);
        rook2.addMouseMotionListener(eventRook2);
        ChessBoardLogic.figuresArray[0][7] = rook2;
        ChessBoardLogic.figuresList.add(rook2);

        //KNIGHTS
        BlackKnight knight = new BlackKnight(1,0, Color.WHITE);
        MoveHandler moveKnight1 = new MoveHandler(knight);
        EventListener eventKnight1 = new EventListener(knight, moveKnight1);
        knight.addMouseListener(eventKnight1);
        knight.addMouseMotionListener(eventKnight1);
        ChessBoardLogic.figuresArray[0][1] = knight;
        ChessBoardLogic.figuresList.add(knight);


        BlackKnight knight2 = new BlackKnight(6,0,Color.WHITE);
        MoveHandler moveKnight2 = new MoveHandler(knight2);
        EventListener eventKnight2 = new EventListener(knight2, moveKnight2);
        knight2.addMouseListener(eventKnight2);
        knight2.addMouseMotionListener(eventKnight2);
        ChessBoardLogic.figuresArray[0][6] = knight2;
        ChessBoardLogic.figuresList.add(knight2);

        //BISHOPS
        BlackBishop bishop = new BlackBishop(2,0, Color.WHITE);
        MoveHandler moveBishop = new MoveHandler(bishop);
        EventListener eventBishop1 = new EventListener(bishop, moveBishop);
        bishop.addMouseListener(eventBishop1);
        bishop.addMouseMotionListener(eventBishop1);
        ChessBoardLogic.figuresArray[0][2] = bishop;
        ChessBoardLogic.figuresList.add(bishop);

        BlackBishop bishop2 = new BlackBishop(5,0, Color.WHITE);
        MoveHandler moveBishop2 = new MoveHandler(bishop2);
        EventListener eventBishop2 = new EventListener(bishop2, moveBishop2);
        bishop2.addMouseListener(eventBishop2);
        bishop2.addMouseMotionListener(eventBishop2);
        ChessBoardLogic.figuresArray[0][5] = bishop2;
        ChessBoardLogic.figuresList.add(bishop2);

        //KING
        BlackKing king = new BlackKing(3, 0, Color.WHITE);
        MoveHandler moveKing = new MoveHandler(king);
        EventListener eventKing = new EventListener(king, moveKing);
        king.addMouseListener(eventKing);
        king.addMouseMotionListener(eventKing);
        ChessBoardLogic.figuresArray[0][3] = king;
        ChessBoardLogic.figuresList.add(king);

        //QUEEN
        BlackQueen queen = new BlackQueen(4,0,Color.WHITE);
        MoveHandler moveQueen = new MoveHandler(queen);
        EventListener eventQueen = new EventListener(queen, moveQueen);
        queen.addMouseListener(eventQueen);
        queen.addMouseMotionListener(eventQueen);
        ChessBoardLogic.figuresArray[0][4] = queen;
        ChessBoardLogic.figuresList.add(queen);

    }

    private void createWhitePieces() {
        //PAWNS
        for (int y = 0; y <= 7; y++) {
            for (int x = 0; x <= 7; x++) {
                if (y == 6) {
                    WhitePawn pawn = new WhitePawn(x,   y, Color.BLACK);
                    MoveHandler move = new MoveHandler(pawn);
                    EventListener event = new EventListener(pawn, move);
                    pawn.addMouseListener(event);
                    pawn.addMouseMotionListener(event);
                    ChessBoardLogic.figuresArray[y][x] = pawn;
                    ChessBoardLogic.figuresList.add(pawn);
                }
            }
        }

        //ROOKS
        WhiteRook rook = new WhiteRook(0,7,Color.BLACK);
        MoveHandler moveRook = new MoveHandler(rook);
        EventListener eventRook = new EventListener(rook, moveRook);
        rook.addMouseListener(eventRook);
        rook.addMouseMotionListener(eventRook);
        ChessBoardLogic.figuresArray[7][0] = rook;
        ChessBoardLogic.figuresList.add(rook);

        WhiteRook rook2 = new WhiteRook(7,7,Color.BLACK);
        MoveHandler moveRook2 = new MoveHandler(rook2);
        EventListener eventRook2 = new EventListener(rook2, moveRook2);
        rook2.addMouseListener(eventRook2);
        rook2.addMouseMotionListener(eventRook2);
        ChessBoardLogic.figuresArray[7][7] = rook2;
        ChessBoardLogic.figuresList.add(rook2);

        //KNIGHTS
        WhiteKnight knight = new WhiteKnight(1,7, Color.BLACK);
        MoveHandler moveKnight = new MoveHandler(knight);
        EventListener eventKnight = new EventListener(knight, moveKnight);
        knight.addMouseListener(eventKnight);
        knight.addMouseMotionListener(eventKnight);
        ChessBoardLogic.figuresArray[7][1] = knight;
        ChessBoardLogic.figuresList.add(knight);

        WhiteKnight knight2 = new WhiteKnight(6,7,Color.BLACK);
        MoveHandler moveKnight2 = new MoveHandler(knight2);
        EventListener eventKnight2 = new EventListener(knight2, moveKnight2);
        knight2.addMouseListener(eventKnight2);
        knight2.addMouseMotionListener(eventKnight2);
        ChessBoardLogic.figuresArray[7][6] = knight2;
        ChessBoardLogic.figuresList.add(knight2);

        //BISHOPS
        WhiteBishop bishop = new WhiteBishop(2,7, Color.BLACK);
        MoveHandler moveBishop = new MoveHandler(bishop);
        EventListener eventBishop = new EventListener(bishop, moveBishop);
        bishop.addMouseListener(eventBishop);
        bishop.addMouseMotionListener(eventBishop);
        ChessBoardLogic.figuresArray[7][2] = bishop;
        ChessBoardLogic.figuresList.add(bishop);

        WhiteBishop bishop2 = new WhiteBishop(5,7, Color.BLACK);
        MoveHandler moveBishop2 = new MoveHandler(bishop2);
        EventListener eventBishop2 = new EventListener(bishop2, moveBishop2);
        bishop2.addMouseListener(eventBishop2);
        bishop2.addMouseMotionListener(eventBishop2);
        ChessBoardLogic.figuresArray[7][5] = bishop2;
        ChessBoardLogic.figuresList.add(bishop2);

        //KING
        WhiteKing king = new WhiteKing(3, 7, Color.BLACK);
        MoveHandler moveKing = new MoveHandler(king);
        EventListener eventKing = new EventListener(king, moveKing);
        king.addMouseListener(eventKing);
        king.addMouseMotionListener(eventKing);
        ChessBoardLogic.figuresArray[7][3] = king;
        ChessBoardLogic.figuresList.add(king);

        //QUEEN
        WhiteQueen queen = new WhiteQueen(4,7,Color.BLACK);
        MoveHandler moveQueen = new MoveHandler(queen);
        EventListener eventQueen = new EventListener(queen, moveQueen);
        queen.addMouseListener(eventQueen);
        queen.addMouseMotionListener(eventQueen);
        ChessBoardLogic.figuresArray[7][4] = queen;
        ChessBoardLogic.figuresList.add(queen);
    }

    public void render() {
        for (Figure figure: ChessBoardLogic.figuresList)
            layeredPane.add(figure, 0);
    }

    public static ChessBoardGraphics getInstance() {
        if (instance == null)
            instance = new ChessBoardGraphics();
        return instance;
    }
}