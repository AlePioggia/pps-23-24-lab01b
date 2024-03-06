package e1;

import org.junit.jupiter.api.*;

import e1.ChessPiece.Knight;
import e1.ChessPiece.Pawn;
import e1.ChessPieceCoordinates.ChessPieceCoordinates;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

  private static final int GRID_SIZE = 5;

  private Logics logics;

  @BeforeEach
  public void setUp() {
    this.logics = new LogicsImpl(GRID_SIZE,
        new Pawn(new Pair<>(ChessPieceCoordinates.PAWN_X_COORDINATE.getValue(),
            ChessPieceCoordinates.PAWN_Y_COORDINATE.getValue())),
        new Knight(new Pair<>(ChessPieceCoordinates.KNIGHT_X_COORDINATE.getValue(),
            ChessPieceCoordinates.KNIGHT_Y_COORDINATE.getValue())));
  }

  @Test
  public void testHasPawn() {
    boolean checkRightPosition = this.logics.hasPawn(ChessPieceCoordinates.PAWN_X_COORDINATE.getValue(),
        ChessPieceCoordinates.PAWN_Y_COORDINATE.getValue());
    boolean checkWrongPosition = this.logics.hasPawn(0, 0);
    assertTrue(checkRightPosition);
    assertFalse(checkWrongPosition);
  }

  @Test
  public void testHasKnight() {
    boolean checkRightPosition = this.logics.hasKnight(ChessPieceCoordinates.KNIGHT_X_COORDINATE.getValue(),
        ChessPieceCoordinates.KNIGHT_Y_COORDINATE.getValue());
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

  @Test
  public void testKnightMovement() {
    boolean isWinning = this.logics.hit(1, 0);
    assertEquals(new Pair<Integer, Integer>(1, 0), this.logics.getKnight());
    assertFalse(isWinning);
  }

  @Test
  public void testWrongKnightMovement() {
    this.logics.hit(1, 1);
    assertFalse(this.logics.getKnight().equals(new Pair<Integer, Integer>(1, 1)));
    assertTrue(this.logics.getKnight().equals(new Pair<Integer, Integer>(
        ChessPieceCoordinates.KNIGHT_X_COORDINATE.getValue(), ChessPieceCoordinates.KNIGHT_Y_COORDINATE.getValue())));
  }

  @Test
  public void testHitWinningSequence() {
    Pair<Integer, Integer> pawn = this.logics.getPawn();
    this.logics.hit(1, 0);
    boolean isWinning = this.logics.hit(pawn.getX(), pawn.getY());
    assertTrue(isWinning);
  }

  @Test
  public void testHitLosingSequence() {
    this.logics.hit(1, 0);
    this.logics.hit(0, 2);
    boolean isWinning = this.logics.hit(1, 4);
    assertFalse(isWinning);
  }

}
