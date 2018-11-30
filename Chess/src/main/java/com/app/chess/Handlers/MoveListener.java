package com.app.chess.Handlers;

import com.app.chess.Data.Data;
import com.app.chess.Figures.Figure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MoveListener extends MouseAdapter {
    private boolean[][] figureSteps;

    private Point old;
    private Figure piece;
    private JLayeredPane containPane;

    public MoveListener(Figure piece, JLayeredPane containPane) {
        this.piece = piece;
        this.containPane = containPane;
        figureSteps = piece.getSteps();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        old = e.getPoint();
        containPane.moveToFront(piece);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        if (piece.getX() > -1 && piece.getY() > -1 && piece.getX() <= 800 && piece.getY() <= 800)
            piece.setBounds(piece.getX() + e.getX() - (int) old.getX(), piece.getY() + e.getY() - (int) old.getY(), piece.getWidth(), piece.getHeight());
        else
            stayOnBoard();

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);

        stayOnBoard();
        moveTheFigure();

        System.out.println(piece.getPositionOnBoardX() + " " + piece.getPositionOnBoardY());
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

    private void moveTheFigure(){
        Point point;
        point = piece.getLocation();

        double centerBoardX = point.getX() + (double) piece.getWidth() / 2;
        double centerBoardY = point.getY() + (double) piece.getHeight() / 2;

        int figureInArrayX = (int) (centerBoardX / 100);
        int figureInArrayY = (int) (centerBoardY / 100);

        if(figureSteps[figureInArrayY][figureInArrayX]) {

            if (((int) centerBoardX > (figureInArrayX) * 100)
                    && ((int) centerBoardX < figureInArrayX * 100 + 100)
                    && ((int) centerBoardY > figureInArrayY * 100)
                    && ((int) centerBoardY < figureInArrayY * 100 + 100)) {

                if ((Data.figuresArray[figureInArrayY][figureInArrayX] != null)
                        && (Data.figuresArray[figureInArrayY][figureInArrayX].getColor().equals(piece.getColor()))) {

                    piece.setBounds(piece.getPositionOnBoardX(), piece.getPositionOnBoardY(), piece.getWidth(), piece.getHeight());

                    predictStepsOfAllFigures();

                } else {

                    if ((Data.figuresArray[figureInArrayY][figureInArrayX] != null)
                            && (!Data.figuresArray[figureInArrayY][figureInArrayX].getColor().equals(piece.getColor()))) {

                        Data.figuresList.remove(Data.figuresArray[figureInArrayY][figureInArrayX]);

                        containPane.remove(Data.figuresArray[figureInArrayY][figureInArrayX]);
                        piece.setBounds((figureInArrayX * 100), (figureInArrayY * 100), piece.getWidth(), piece.getHeight());

                        Data.figuresArray[piece.getPositionInArrayY()][piece.getPositionInArrayX()] = null;
                        Data.figuresArray[figureInArrayY][figureInArrayX] = null;
                        Data.figuresArray[figureInArrayY][figureInArrayX] = piece;

                        piece.moveTo(figureInArrayX,figureInArrayY);

                        isFirstStep();

                        predictStepsOfAllFigures();

                    } else {

                        piece.setBounds((figureInArrayX * 100), (figureInArrayY * 100), piece.getWidth(), piece.getHeight());

                        Data.figuresArray[piece.getPositionInArrayY()][piece.getPositionInArrayX()] = null;
                        Data.figuresArray[figureInArrayY][figureInArrayX] = null;
                        Data.figuresArray[figureInArrayY][figureInArrayX] = piece;

                        piece.moveTo(figureInArrayX,figureInArrayY);

                        isFirstStep();

                        predictStepsOfAllFigures();

                    }
                }
            }
        } else {
            piece.setBounds(piece.getPositionOnBoardX(), piece.getPositionOnBoardY(), piece.getWidth(), piece.getHeight());
        }
    }

    private void isFirstStep(){
        if(piece.isFirstStep()){
            piece.setFirstStep(false);
        }
    }

    private void predictStepsOfAllFigures(){
        for(Figure figure: Data.figuresList){
            figure.predictSteps();
        }
    }
}

