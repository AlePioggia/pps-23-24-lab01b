package e1;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map.Entry;
import java.util.function.Predicate;

import javax.swing.JButton;

public class LogicTest {

  private static final int GRID_SIZE = 5;
  private static final int KNIGHT_X_COORDINATE = 1;
  private static final int KNIGHT_Y_COORDINATE = 4;
  private static final int PAWN_X_COORDINATE = 0;
  private static final int PAWN_Y_COORDINATE = 2;

  private Logics logics;

  @BeforeEach
  public void setUp() {
    this.logics = new LogicsImpl(GRID_SIZE, new Pair<Integer, Integer>(KNIGHT_X_COORDINATE, KNIGHT_Y_COORDINATE),
        new Pair<Integer, Integer>(PAWN_X_COORDINATE, PAWN_Y_COORDINATE));
  }

  @Test
  public void testHasPawn() {
    boolean checkRightPosition = this.logics.hasPawn(PAWN_X_COORDINATE, PAWN_Y_COORDINATE);
    boolean checkWrongPosition = this.logics.hasPawn(0, 0);
    assertTrue(checkRightPosition);
    assertFalse(checkWrongPosition);
  }

  @Test
  public void testHasKnight() {
    boolean checkRightPosition = this.logics.hasKnight(GRID_SIZE, KNIGHT_X_COORDINATE);
    boolean checkWrongPosition = this.logics.hasKnight(0, 0);
    assertTrue(checkRightPosition);
    assertFalse(checkWrongPosition);
  }

  @Test
  public void testPiecesOverlap() {
    Pair<Integer, Integer> pawn = this.logics.getPawn();
    Pair<Integer, Integer> knight = this.logics.getKnight();
    boolean arePositionsDifferent = pawn.getX() != knight.getX() || pawn.getY() != knight.getY();
    assertTrue(arePositionsDifferent);
  }

}
