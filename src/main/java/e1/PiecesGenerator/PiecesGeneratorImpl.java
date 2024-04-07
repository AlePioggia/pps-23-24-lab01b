
package e1.PiecesGenerator;

import java.util.Random;

import e1.Pair;

public class PiecesGeneratorImpl implements PiecesGenerator {

    private int size;
    private final Random random = new Random();
    private Pair<Integer, Integer> pawnPosition;
    private Pair<Integer, Integer> knightPosition;

    public PiecesGeneratorImpl(int size) {
        this.size = size;
        this.pawnPosition = randomEmptyPosition();
        this.knightPosition = randomEmptyPosition();
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public Pair<Integer, Integer> generatePawnInARandomPosition() {
        this.pawnPosition = randomEmptyPosition();
        return this.pawnPosition;
    }

    @Override
    public Pair<Integer, Integer> generateKnightInARandomPosition() {
        this.knightPosition = randomEmptyPosition();
        return this.knightPosition;
    }

    private Pair<Integer, Integer> randomEmptyPosition() {
        Pair<Integer, Integer> pos = new Pair<>(random.nextInt(size), random.nextInt(size));
        return (pawnPosition != null && pawnPosition.equals(pos))
                || (knightPosition != null && knightPosition.equals(pos)) ? randomEmptyPosition() : pos;
    }

}
