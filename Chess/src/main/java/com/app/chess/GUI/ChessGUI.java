package com.app.chess.GUI;

import com.app.chess.Data.Data;
import com.app.chess.Figures.BlackPieces.BlackPawn;
import com.app.chess.Figures.BlackPieces.BlackRook;
import com.app.chess.Figures.WhitePieces.WhitePawn;
import com.app.chess.Figures.WhitePieces.WhiteRook;
import com.app.chess.Handlers.MoveListener;
import com.app.chess.Figures.AbstractPieces.*;

import javax.swing.*;
import java.awt.*;


import java.net.Socket;

public class ChessGUI extends JFrame {

    private JLayeredPane layeredPane;

    private Socket socket;

    public ChessGUI(Socket socket){
        this.socket = socket;
    }

    public void start(){
        setupStreams();
        setupWindow();
    }

    private void setupWindow(){

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setTitle("Chess");
        short frameWidth = 817;
        short frameHeight = 839;
        setSize(frameWidth, frameHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation((screenWidth- frameWidth)/2, (screenHeight- frameHeight)/2);
        setResizable(false);

        layeredPane = new JLayeredPane();
        add(layeredPane);

        // Создание шахматной доски
        boolean color = false;

        short boardHeight = 800;

        for (int y = 0; y < boardHeight; y = y + 100 ) {

            short boardWidth = 800;
            for (int x = 0; x < boardWidth; x = x + 100) {

                JPanel panel = new JPanel();

                if (color)
                    panel.setBackground(Color.BLACK);
                else
                    panel.setBackground(Color.WHITE);

                panel.setBounds(x,y,100,100);
                layeredPane.add(panel, 0);
                color = !color;
            }
            color = !color;
        }

        createBlackPieces();
        createWhitePieces();

        setVisible(true);
    }

    private void createBlackPieces(){

        //PAWNS
        for(int y = 0; y <= 7; y++){
            for(int x = 0; x <= 7; x++){
                if(y == 1){
                    BlackPawn pawn = new BlackPawn(x,y, Color.WHITE);
                    MoveListener move = new MoveListener(pawn, layeredPane);
                    pawn.addMouseListener(move);
                    pawn.addMouseMotionListener(move);
                    layeredPane.add(pawn,0);
                    Data.figuresArray[y][x] = pawn;
                    Data.figuresList.add(pawn);
                }else{
                    Data.figuresArray[y][x] = null;
                }
            }
        }

        //ROOKS
        BlackRook rook = new BlackRook(0,0,Color.WHITE);
        MoveListener moveRook1 = new MoveListener(rook, layeredPane);
        rook.addMouseListener(moveRook1);
        rook.addMouseMotionListener(moveRook1);
        layeredPane.add(rook,0);
        Data.figuresArray[0][0] = rook;
        Data.figuresList.add(rook);

        BlackRook rook2 = new BlackRook(7,0,Color.WHITE);
        MoveListener moveRook2 = new MoveListener(rook2, layeredPane);
        rook2.addMouseListener(moveRook2);
        rook2.addMouseMotionListener(moveRook2);
        layeredPane.add(rook2,0);
        Data.figuresArray[0][7] = rook2;
        Data.figuresList.add(rook2);

        //KNIGHTS
        Knight knight = new Knight(1,0, Color.WHITE);
        MoveListener moveKnight1 = new MoveListener(knight, layeredPane);
        knight.addMouseListener(moveKnight1);
        knight.addMouseMotionListener(moveKnight1);
        layeredPane.add(knight,0);
        Data.figuresArray[0][1] = knight;
        Data.figuresList.add(knight);


        Knight knight2 = new Knight(6,0,Color.WHITE);
        MoveListener moveKnight2 = new MoveListener(knight2, layeredPane);
        knight2.addMouseListener(moveKnight2);
        knight2.addMouseMotionListener(moveKnight2);
        layeredPane.add(knight2,0);
        Data.figuresArray[0][6] = knight2;
        Data.figuresList.add(knight2);

        //BISHOPS
        Bishop bishop = new Bishop(2,0, Color.WHITE);
        MoveListener moveBishop1 = new MoveListener(bishop, layeredPane);
        bishop.addMouseListener(moveBishop1);
        bishop.addMouseMotionListener(moveBishop1);
        layeredPane.add(bishop,0);
        Data.figuresArray[0][2] = bishop;
        Data.figuresList.add(bishop);

        Bishop bishop2 = new Bishop(5,0, Color.WHITE);
        MoveListener moveBishop2 = new MoveListener(bishop2, layeredPane);
        bishop2.addMouseListener(moveBishop2);
        bishop2.addMouseMotionListener(moveBishop2);
        layeredPane.add(bishop2,0);
        Data.figuresArray[0][5] = bishop2;
        Data.figuresList.add(bishop2);

        //KING
        King king = new King(3, 0, Color.WHITE);
        MoveListener moveKing = new MoveListener(king, layeredPane);
        king.addMouseListener(moveKing);
        king.addMouseMotionListener(moveKing);
        layeredPane.add(king, 0);
        Data.figuresArray[0][3] = king;
        Data.figuresList.add(king);

        //QUEEN
        Queen queen = new Queen(4,0,Color.WHITE);
        MoveListener moveQueen = new MoveListener(queen,layeredPane);
        queen.addMouseListener(moveQueen);
        queen.addMouseMotionListener(moveQueen);
        layeredPane.add(queen,0);
        Data.figuresArray[0][4] = queen;
        Data.figuresList.add(queen);

    }

    private void createWhitePieces(){

        //PAWNS
        for(int y = 0; y <= 7; y++){
            for(int x = 0; x <= 7; x++){
                if(y == 6){
                    WhitePawn pawn = new WhitePawn(x,y, Color.BLACK);
                    MoveListener move = new MoveListener(pawn, layeredPane);
                    pawn.addMouseListener(move);
                    pawn.addMouseMotionListener(move);
                    layeredPane.add(pawn,0);
                    Data.figuresArray[y][x] = pawn;
                    Data.figuresList.add(pawn);
                }
            }
        }

        //ROOKS
        WhiteRook rook = new WhiteRook(0,7,Color.BLACK);
        MoveListener moveRook1 = new MoveListener(rook, layeredPane);
        rook.addMouseListener(moveRook1);
        rook.addMouseMotionListener(moveRook1);
        layeredPane.add(rook,0);
        Data.figuresArray[7][0] = rook;
        Data.figuresList.add(rook);

        WhiteRook rook2 = new WhiteRook(7,7,Color.BLACK);
        MoveListener moveRook2 = new MoveListener(rook2, layeredPane);
        rook2.addMouseListener(moveRook2);
        rook2.addMouseMotionListener(moveRook2);
        layeredPane.add(rook2,0);
        Data.figuresArray[7][7] = rook2;
        Data.figuresList.add(rook2);

        //KNIGHTS
        Knight knight = new Knight(1,7, Color.BLACK);
        MoveListener moveKnight1 = new MoveListener(knight, layeredPane);
        knight.addMouseListener(moveKnight1);
        knight.addMouseMotionListener(moveKnight1);
        layeredPane.add(knight,0);
        Data.figuresArray[7][1] = knight;
        Data.figuresList.add(knight);

        Knight knight2 = new Knight(6,7,Color.BLACK);
        MoveListener moveKnight2 = new MoveListener(knight2, layeredPane);
        knight2.addMouseListener(moveKnight2);
        knight2.addMouseMotionListener(moveKnight2);
        layeredPane.add(knight2,0);
        Data.figuresArray[7][6] = knight2;
        Data.figuresList.add(knight2);

        //BISHOPS
        Bishop bishop = new Bishop(2,7, Color.BLACK);
        MoveListener moveBishop1 = new MoveListener(bishop, layeredPane);
        bishop.addMouseListener(moveBishop1);
        bishop.addMouseMotionListener(moveBishop1);
        layeredPane.add(bishop,0);
        Data.figuresArray[7][2] = bishop;
        Data.figuresList.add(bishop);

        Bishop bishop2 = new Bishop(5,7, Color.BLACK);
        MoveListener moveBishop2 = new MoveListener(bishop2, layeredPane);
        bishop2.addMouseListener(moveBishop2);
        bishop2.addMouseMotionListener(moveBishop2);
        layeredPane.add(bishop2,0);
        Data.figuresArray[7][5] = bishop2;
        Data.figuresList.add(bishop2);

        //KING
        King king = new King(3, 7, Color.BLACK);
        MoveListener moveKing = new MoveListener(king, layeredPane);
        king.addMouseListener(moveKing);
        king.addMouseMotionListener(moveKing);
        layeredPane.add(king, 0);
        Data.figuresArray[7][3] = king;
        Data.figuresList.add(king);

        //QUEEN
        Queen queen = new Queen(4,7,Color.BLACK);
        MoveListener moveQueen = new MoveListener(queen,layeredPane);
        queen.addMouseListener(moveQueen);
        queen.addMouseMotionListener(moveQueen);
        layeredPane.add(queen,0);
        Data.figuresArray[7][4] = queen;
        Data.figuresList.add(queen);
    }

    private void setupStreams(){

    }
}
