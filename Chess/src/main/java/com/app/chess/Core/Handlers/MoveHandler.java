package com.app.chess.Core.Handlers;

import com.app.chess.Core.ChessBoard.ChessBoardLogic;
import com.app.chess.Figures.Figure;

import java.awt.*;

public class MoveHandler {
    private Figure figure;
    private boolean[][] figuresSteps;
    private ChessBoardLogic chessBoardLogic;

    public MoveHandler(Figure figure, ChessBoardLogic chessBoardLogic) {
        this.figure = figure;
        this.figuresSteps = figure.getSteps();
        this.chessBoardLogic = chessBoardLogic;
    }

    public void moveFigure(){
        Point point;
        point = figure.getLocation();

        double centerBoardX = point.getX() + (double) figure.getWidth() / 2;
        double centerBoardY = point.getY() + (double) figure.getHeight() / 2;

        int figureInArrayX = (int) (centerBoardX / 100);
        int figureInArrayY = (int) (centerBoardY / 100);

        if (figuresSteps[figureInArrayY][figureInArrayX]) {
            if (((int) centerBoardX > (figureInArrayX) * 100) && ((int) centerBoardX < figureInArrayX * 100 + 100)
                    && ((int) centerBoardY > figureInArrayY * 100) && ((int) centerBoardY < figureInArrayY * 100 + 100)) {

                // Установка фигуры на пустую клетку
                if ((ChessBoardLogic.figuresArray[figureInArrayY][figureInArrayX] != null)
                        && (ChessBoardLogic.figuresArray[figureInArrayY][figureInArrayX].getColor().equals(figure.getColor()))) {

                    figure.setBounds(figure.getPositionOnBoardX(), figure.getPositionOnBoardY(), figure.getWidth(), figure.getHeight());
                    predictStepsOfAllFigures();

                } else {
                    // Удаление фигуры с доски
                    Figure figureToRemove = getFigure(figureInArrayX, figureInArrayY);
                    if ((figureToRemove != null) && (!figureToRemove.getColor().equals(figure.getColor()))) {
                        removeFigure(figureToRemove);
                        moveFigure(figureInArrayX, figureInArrayY);
                    } else {
                        moveFigure(figureInArrayX, figureInArrayY);
                    }
                }
            }
        } else {
            figure.setBounds(figure.getPositionOnBoardX(), figure.getPositionOnBoardY(), figure.getWidth(), figure.getHeight());
        }
    }

    // Удаление фигуры
    private void removeFigure(Figure figureToRemove) {
        chessBoardLogic.removeFigure(figureToRemove);
    }

    // Сдвиг фигуры
    private void moveFigure(int x, int y) {
        figure.setBounds((x * 100), (y * 100), figure.getWidth(), figure.getHeight());

        ChessBoardLogic.figuresArray[figure.getPositionInArrayY()][figure.getPositionInArrayX()] = null;
        ChessBoardLogic.figuresArray[y][x] = null;
        ChessBoardLogic.figuresArray[y][x] = figure;

        figure.moveTo(x,y);

        isFirstStep();
        predictStepsOfAllFigures();
    }

    private void isFirstStep() {
        if (figure.isFirstStep()) {
            figure.setFirstStep(false);
        }
    }

    private Figure getFigure(int x, int y) {
        return ChessBoardLogic.figuresArray[y][x];
    }

    private void predictStepsOfAllFigures() {
        chessBoardLogic.predictStepsOfAllFigures();
    }
}
