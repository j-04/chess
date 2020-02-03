package com.chess.сore.figures.builder;

import com.chess.сore.figures.black.*;

public class BlackFigureDirector implements Director {
    private Builder builder;

    public BlackFigureDirector(Builder builder) {
        this.builder = builder;
    }

    @Override
    public Builder buildPawn() {
        builder.setResult(new BlackPawn());
        return builder;
    }

    @Override
    public Builder buildBishop() {
        builder.setResult(new BlackBishop());
        return builder;
    }

    @Override
    public Builder buildRook() {
        builder.setResult(new BlackRook());
        return builder;
    }

    @Override
    public Builder buildKnight() {
        builder.setResult(new BlackKnight());
        return builder;
    }

    @Override
    public Builder buildQueen() {
        builder.setResult(new BlackQueen());
        return builder;
    }

    @Override
    public Builder buildKing() {
        builder.setResult(new BlackKing());
        return builder;
    }
}
