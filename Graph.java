import java.util.Arrays;

public class Graph {

    private char[] topString;
    private char[] midString;
    private char[] botString;
    Graph() {
        String start = "       |       |       ";
        topString = start.toCharArray();
        midString = start.toCharArray();
        botString = start.toCharArray();
    }
    void print() {
        System.out.println("0      |1      |2   ");
        System.out.println(topString);
        System.out.println("       |       |    ");
        System.out.println("-----------------------");
        System.out.println("3      |4      |5   ");
        System.out.println(midString);
        System.out.println("       |       |    ");
        System.out.println("-----------------------");
        System.out.println("6      |7      |8   ");
        System.out.println(botString);
        System.out.println("       |       |    ");
    }
    void changeSpot(int spot, boolean isX) {
        char piece = 'X';
        if (!isX) {
            piece = 'O';
        }

        boolean madeChange = false;
        if (spot >= 0 && spot <= 2) {
            madeChange = changeLine(topString, spot % 3, piece);
        } else if (spot >= 3 && spot <= 5){
            madeChange = changeLine(midString, spot % 3, piece);
        } else if (spot >= 6 && spot <= 8) {
            madeChange = changeLine(botString, spot % 3, piece);
        } else {
            System.out.println("Que tonto que eres.");
            return;
        }

        if (!madeChange) {
            System.out.println("Ese espacio ya esta lleno!");
        }
    }

    private boolean changeLine(char[] toChange, int spot, char piece) {
        int location = spot + 3 + (7 * spot);

        if (toChange[location] != ' ') {
            return false;
        }
        toChange[location] = piece;

        return true;
    }



}
