package model;

public class Board {
    private int size;
    private PieceType[][] cells;

    public Board(int size) {
        this.size = size;
        this.cells = new PieceType[size][size];
    }

    public int getSize() {
        return size;
    }

    public PieceType[][] getCells() {
        return cells;
    }

    public boolean addPiece(int row, int col, PieceType pieceType) {
        if(cells[row][col] != null)
            return false;
        cells[row][col] = pieceType;

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
                    System.out.print(cells[i][j].name());
                }
                else {
                    System.out.print(" ");
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }
}
