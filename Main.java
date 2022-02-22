import java.util.Scanner;

public class Main {

    Main() {

    }
    public static void main(String args[]){
        new Main().playGame();
    }

    public void playGame() {
        Graph graph = new Graph();
        Board board = new Board();
        boolean end = false;
        boolean isX = true;
        graph.print();

        while(!end){
            int chosenSpot;
            stateTurn(isX);

            if ( (chosenSpot = takeInput()) < 0) {
                continue;
            }
            if (!placePiece(board, graph, chosenSpot, isX)) {
                continue;
            }


            graph.print();
            if (! (end = checkWinner(board, isX))) {
                end = checkTie(board);
            }
            isX = !isX;
        }
    }

    private void stateTurn(boolean isX) {
        if (isX) {
            System.out.println("Jugador X, te toca!");
        } else {
            System.out.println("Jugador O, te toca!");
        }
    }

    private int takeInput() {
        Scanner scanner = new Scanner(System.in);
        String token = scanner.nextLine();
        int slot = 0;
        try {
            slot = Integer.parseInt(token);
        } catch(Exception e) {
            System.out.println("Ingrese un numero.");
            return -1;
        }
        return slot;
    }

    private boolean placePiece(Board board, Graph graph, int chosenSpot, boolean isX) {
        if (board.placePiece(chosenSpot, isX)) {
            graph.changeSpot(chosenSpot, isX);
            return true;
        }
        return false;
    }

    private boolean checkWinner(Board board, boolean isX) {
        boolean winner = board.checkWinner();
        if (winner) {
            if (isX) {
                System.out.println("Jugador X ha ganado!");
            } else {
                System.out.println("Jugador O ha ganado!");
            }
            return true;
        }
        return false;
    }

    private boolean checkTie(Board board) {
        if (board.checkTie()) {
            System.out.println("Empate!");
            return true;
        }
        return false;
    }



}
