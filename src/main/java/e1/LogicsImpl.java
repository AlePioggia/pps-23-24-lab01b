package e1;

import java.util.*;

import e1.ChessBoard.PiecesGenerator;
import e1.ChessBoard.PiecesGeneratorImpl;
import e1.ChessPiece.ChessPiece;
import e1.ChessPiece.Knight;
import e1.ChessPiece.Pawn;

public class LogicsImpl implements Logics {

	private final ChessPiece pawn;
	private final ChessPiece knight;
	private final int size;

	public LogicsImpl(int size) {
		this.size = size;
		PiecesGenerator piecesGenerator = new PiecesGeneratorImpl(size);
		this.pawn = new Pawn(piecesGenerator.generatePawnInARandomPosition());
		this.knight = new Knight(piecesGenerator.generateKnightInARandomPosition());
	}

	public LogicsImpl(int size, ChessPiece pawn, ChessPiece knight) {
		this.size = size;
		this.pawn = pawn;
		this.knight = knight;
	}

	@Override
	public boolean hit(int row, int col) {
		if (row < 0 || col < 0 || row >= this.size || col >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		return this.knight.move(row, col) ? this.pawn.getPosition().equals(this.knight.getPosition())
				: false;
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.getPosition().equals(new Pair<>(row, col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.getPosition().equals(new Pair<>(row, col));
	}

	@Override
	public Pair<Integer, Integer> getPawn() {
		return this.pawn.getPosition();
	}

	@Override
	public Pair<Integer, Integer> getKnight() {
		return this.knight.getPosition();
	}
}
