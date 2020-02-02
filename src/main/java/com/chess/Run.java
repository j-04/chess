package com.chess;

import com.chess.сore.сhessboard.ChessBoardGraphics;

import javax.swing.*;

public class Run {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            ChessBoardGraphics chessBoardGraphics = ChessBoardGraphics.getInstance();
            chessBoardGraphics.start();
        });
    }
}
