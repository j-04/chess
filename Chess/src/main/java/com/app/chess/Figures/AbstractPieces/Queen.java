package com.app.chess.Figures.AbstractPieces;

import com.app.chess.Figures.Figure;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Queen extends Figure{

    public Queen(int x, int y, Color color){
        moveTo(x, y);

        setBackground(color);
        setColor(color);

        setBounds(getPositionOnBoardX(),getPositionOnBoardY(), getWidth(), getHeight());

        JLabel label = new JLabel();


        if(color.equals(Color.WHITE)) {
            try {
                label.setIcon(new ImageIcon(ImageIO.read(new File("C:\\Users\\Jonathan\\Documents\\Repositories\\MainBitBucket\\chess\\Chess\\src\\main\\java\\com\\app\\chess\\GUI\\Chess pieces\\Chess_qdt60.png"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try {
                label.setIcon(new ImageIcon(ImageIO.read(new File("C:\\Users\\Jonathan\\Documents\\Repositories\\MainBitBucket\\chess\\Chess\\src\\main\\java\\com\\app\\chess\\GUI\\Chess pieces\\Chess_qlt60.png"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        add(label);
    }

    @Override
    public void predictSteps() {

    }
}
