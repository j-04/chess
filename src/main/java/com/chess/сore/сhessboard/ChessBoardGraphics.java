package com.chess.сore.сhessboard;

import com.chess.сore.figures.abstrac.Figure;
import com.chess.сore.figures.factory.BlackFigureFactory;
import com.chess.сore.figures.factory.FigureFactory;
import com.chess.сore.figures.factory.WhiteFigureFactory;
import com.chess.сore.figures.other.ChessBoardCell;

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
        FigureFactory figureFactory = new BlackFigureFactory();
        //PAWNS
        for(int y = 0; y <= 7; y++) {
            for(int x = 0; x <= 7; x++) {
                if(y == 1){
                    registerFigure(x, y, figureFactory.createPawn(x, y));
                }
            }
        }
        //ROOKS
        registerFigure(0, 0, figureFactory.createRook(0, 0));
        registerFigure(7, 0, figureFactory.createRook(7, 0));
        //KNIGHTS
        registerFigure(1, 0, figureFactory.createKnight(1, 0));
        registerFigure(6, 0, figureFactory.createKnight(6, 0));
        //BISHOPS
        registerFigure(2, 0, figureFactory.createBishop(2, 0));
        registerFigure(5, 0, figureFactory.createBishop(5, 0));
        //KING
        registerFigure(3, 0, figureFactory.createKing(3, 0));
        //QUEEN
        registerFigure(4, 0, figureFactory.createQueen(4, 0));
    }

    private void createWhitePieces() {
        FigureFactory figureFactory = new WhiteFigureFactory();
        //PAWNS
        for (int y = 0; y <= 7; y++) {
            for (int x = 0; x <= 7; x++) {
                if (y == 6) {
                    registerFigure(x, y, figureFactory.createPawn(x, y));
                }
            }
        }
        //ROOKS
        registerFigure(0, 7, figureFactory.createRook(0, 7));
        registerFigure(7, 7, figureFactory.createRook(7, 7));
        //KNIGHTS
        registerFigure(1, 7, figureFactory.createRook(1, 7));
        registerFigure(6, 7, figureFactory.createRook(6, 7));
        //BISHOPS
        registerFigure(2, 7, figureFactory.createBishop(2, 7));
        registerFigure(5, 7, figureFactory.createBishop(5, 7));
        //KING
        registerFigure(3, 7, figureFactory.createKing(3, 7));
        //QUEEN
        registerFigure(4, 7, figureFactory.createQueen(4, 7));
    }

    private void registerFigure(int x, int y, Figure figure) {
        ChessBoardLogic.figuresArray[y][x] = figure;
        ChessBoardLogic.figuresList.add(figure);
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