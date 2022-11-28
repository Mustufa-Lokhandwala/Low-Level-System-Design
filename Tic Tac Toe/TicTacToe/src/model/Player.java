package model;

public class Player {
    private int id;
    private String name;
    private PlayingPiece playingPiece;

    public Player(int id, String name, PlayingPiece playingPiece) {
        this.id = id;
        this.name = name;
        this.playingPiece = playingPiece;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PlayingPiece getPlayingPiece() {
        return playingPiece;
    }
}
