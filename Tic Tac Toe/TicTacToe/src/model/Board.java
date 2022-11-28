package model;

public class Board {
    private int size;
    private PlayingPiece[][] cells;

    public Board(int size) {
        this.size = size;
        this.cells = new PlayingPiece[size][size];
    }

    public int getSize() {
        return size;
    }

    public PlayingPiece[][] getCells() {
        return cells;
    }

    public boolean addPiece(int row, int col, PlayingPiece playingPiece) {
        if(cells[row][col] != null)
            return false;
        cells[row][col] = playingPiece;

        return true;
    }

    public boolean hasEmptyCells() {
        for(int i = 0; i < cells.length; i++) {
            for(int j = 0; j < cells[i].length; j++) {
                if(cells[i][j] == null)
                    return true;
            }
        }
        return false;
    }

    public void printCells() {
        for(int i = 0; i < cells.length; i++) {
            for(int j = 0; j < cells[i].length; j++) {
                if(cells[i][j] != null) {
                    System.out.print(cells[i][j].getPieceType().name() + "  ");
                }
                else {
                    System.out.print("   ");
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }
}
