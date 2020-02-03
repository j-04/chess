package com.chess.сore.figures.builder;

import com.chess.сore.figures.white.*;

public class WhiteFigureDirector implements Director {
    private Builder builder;

    public WhiteFigureDirector(Builder builder) {
        this.builder = builder;
    }

    @Override
    public Builder buildPawn() {
        builder.setResult(new WhitePawn());
        return builder;
    }

    @Override
    public Builder buildBishop() {
        builder.setResult(new WhiteBishop());
        return builder;
    }

    @Override
    public Builder buildRook() {
        builder.setResult(new WhiteRook());
        return builder;
    }

    @Override
    public Builder buildKnight() {
        builder.setResult(new WhiteKnight());
        return builder;
    }

    @Override
    public Builder buildQueen() {
        builder.setResult(new WhiteQueen());
        return builder;
    }

    public Builder buildKing() {
        builder.setResult(new WhiteKing());
        return builder;
    }
}