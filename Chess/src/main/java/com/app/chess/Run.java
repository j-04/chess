package com.app.chess;

import com.app.chess.Core.ChessBoard.ChessBoardGraphics;

import javax.swing.*;

public class Run {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            ChessBoardGraphics chessBoardGraphics = ChessBoardGraphics.getInstance();
            chessBoardGraphics.start();
        });
    }
}
