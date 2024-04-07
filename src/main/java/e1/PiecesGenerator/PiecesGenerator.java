package e1.PiecesGenerator;

import e1.Pair;

public interface PiecesGenerator {
    int getSize();

    Pair<Integer, Integer> generatePawnInARandomPosition();

    Pair<Integer, Integer> generateKnightInARandomPosition();
}
