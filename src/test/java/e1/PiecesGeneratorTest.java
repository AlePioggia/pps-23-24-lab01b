package e1;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import e1.PiecesGenerator.*;

public class PiecesGeneratorTest {
    private final static int SIZE = 8;
    PiecesGenerator piecesGenerator;

    @BeforeEach
    void setUp() {
        piecesGenerator = new PiecesGeneratorImpl(SIZE);
    }

    @Test
    public void testGeneratePawnInARandomPosition() {
        Pair<Integer, Integer> pawnPosition = piecesGenerator.generatePawnInARandomPosition();

        assertNotNull(pawnPosition);

        assertTrue(pawnPosition.getX() >= 0 && pawnPosition.getX() < SIZE);
        assertTrue(pawnPosition.getY() >= 0 && pawnPosition.getY() < SIZE);
    }

    @Test
    public void testGenerateKnightInARandomPosition() {
        Pair<Integer, Integer> knightPosition = piecesGenerator.generateKnightInARandomPosition();

        assertNotNull(knightPosition);

        assertTrue(knightPosition.getX() >= 0 && knightPosition.getX() < SIZE);

        assertTrue(knightPosition.getY() >= 0 && knightPosition.getY() < SIZE);
    }
}
