package e1.ChessPieceCoordinates;

public enum ChessPieceCoordinates {
    KNIGHT_X_COORDINATE(3),
    KNIGHT_Y_COORDINATE(1),
    PAWN_X_COORDINATE(2),
    PAWN_Y_COORDINATE(2);

    private final int value;

    ChessPieceCoordinates(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
