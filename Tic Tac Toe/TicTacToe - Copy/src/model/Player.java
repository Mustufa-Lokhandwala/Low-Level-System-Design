package model;

public class Player {
    private int id;
    private String name;
    private PieceType pieceType;

    public Player(int id, String name, PieceType pieceType) {
        this.id = id;
        this.name = name;
        this.pieceType = pieceType;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PieceType getPieceType() {
        return pieceType;
    }
}
