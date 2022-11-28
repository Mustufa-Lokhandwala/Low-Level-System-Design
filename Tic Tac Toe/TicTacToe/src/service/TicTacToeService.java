package service;

import model.Board;
import model.Player;
import model.PlayingPiece;

import java.util.LinkedList;
import java.util.Scanner;

public class TicTacToeService {
    private Board board;
    private LinkedList<Player> players;

    public TicTacToeService(int size, LinkedList<Player> players) {
        this.board = new Board(size);
        this.players = players;
    }

    public void startGame() {
        while(board.hasEmptyCells()) {
            board.printCells();
            Player player = players.removeFirst();
            System.out.println("Player " + player.getId() + " : Enter row,column : ");

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String[] values = input.split(",");
            int row = Integer.valueOf(values[0]);
            int col = Integer.valueOf(values[1]);

            if(board.addPiece(row, col, player.getPlayingPiece())) {
                if(hasPlayerWon(row, col, player.getPlayingPiece())) {
                    System.out.println("Game finished. Player " + player.getId() + " has won !!");
                    return ;
                }
            } else {
                System.out.println("Incorrect position chosen. Please try again.");
            }
            players.add(player);
        }
        System.out.println("Game finished. There is a tie !!");
    }

    private boolean hasPlayerWon(int row, int col, PlayingPiece playingPiece) {
        PlayingPiece[][] cells = board.getCells();

        // Check row
        boolean rowMatch = true;
        for(int j = 0; j < cells[0].length; j++) {
            if(cells[row][j] == null || cells[row][j].getPieceType() != playingPiece.getPieceType()) {
                rowMatch = false;
                break;
            }
        }
        if(rowMatch) return true;

        // Check col
        boolean colMatch = true;
        for(int i = 0; i < cells.length; i++) {
            if(cells[i][col] == null || cells[i][col].getPieceType() != playingPiece.getPieceType()) {
                colMatch = false;
                break;
            }
        }
        if(colMatch) return true;

        if(row == col || row+col == cells.length-1) {
            // Check diagonal
            boolean diagMatch = true;
            for(int i = 0; i < cells.length; i++) {
                if(cells[i][i] == null || cells[i][i].getPieceType() != playingPiece.getPieceType()) {
                    diagMatch = false;
                    break;
                }

            }
            if(diagMatch) return true;

            // Check anti-diagonal
            boolean antidiagMatch = true;
            for(int i = 0; i < cells.length; i++) {
                if(cells[i][cells.length-i-1] == null || cells[i][cells.length-i-1].getPieceType() != playingPiece.getPieceType()) {
                    antidiagMatch = false;
                    break;
                }
            }
            if(antidiagMatch) return true;
        }
        return false;
    }
}
