package com.app.chess;

import com.app.chess.GUI.PIGUI;

import javax.swing.*;

public class StartGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            PIGUI pigui = new PIGUI();
            pigui.showWindow();
        });
    }
}
