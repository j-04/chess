package com.chess.сore.figures.other;

import javax.swing.*;
import java.awt.*;

public class ChessBoardCell extends JPanel {
    private Color nativeColor;

    public ChessBoardCell(int x, int y, int width, int height, Color color) {
        setBounds(x, y, width, height);
        this.nativeColor = color;
        setBackground(color);
    }

    public void setNewColor(Color color) {
        setBackground(color);
    }

    public void setNativeColor() {
        setBackground(this.nativeColor);
    }

    public Color getNativeColor() {
        return this.nativeColor;
    }
}
