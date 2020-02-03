package com.chess.сore.util;

import com.chess.сore.figures.black.*;
import com.chess.сore.figures.white.*;

import java.util.HashMap;
import java.util.Map;

public class FigureUtil {
    public static final Map<Class, String> pictures = new HashMap<Class, String>() {{
        put(BlackBishop.class, "src/main/resources/pictures/Chess_bdt60.png");
        put(WhiteBishop.class, "src/main/resources/pictures/Chess_blt60.png");
        put(BlackKing.class, "src/main/resources/pictures/Chess_kdt60.png");
        put(WhiteKing.class, "src/main/resources/pictures/Chess_klt60.png");
        put(BlackKnight.class, "src/main/resources/pictures/Chess_ndt60.png");
        put(WhiteKnight.class, "src/main/resources/pictures/Chess_nlt60.png");
        put(BlackPawn.class, "src/main/resources/pictures/Chess_pdt60.png");
        put(WhitePawn.class, "src/main/resources/pictures/Chess_plt60.png");
        put(BlackQueen.class, "src/main/resources/pictures/Chess_qdt60.png");
        put(WhiteQueen.class, "src/main/resources/pictures/Chess_qlt60.png");
        put(BlackRook.class, "src/main/resources/pictures/Chess_rdt60.png");
        put(WhiteRook.class, "src/main/resources/pictures/Chess_rlt60.png");
    }};
}