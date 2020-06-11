package tictactoe;
import java.util.Scanner;

public class Main {
    public static char codeX = 'X';
    public static char code0 = 'O';
    public static char codeNull = ' ';

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        var arr = new char[3][3];
        var player = codeX;
        var result = "";

        for (var i = 0; i < 3; i++) {
            for (var j = 0; j < 3; j++) {
                arr[i][j] = codeNull;
            }
        }

        while (true) {
            print(arr);

            var winner = getWinner(arr);
            var hasEmptyCells = hasPossibilities(arr);
            var hasWinner = winner != codeNull;

            if (!hasEmptyCells || hasWinner) {
                result = hasWinner ? winner + " wins" : "Draw";
                break;
            }

            var isCompleted = false;
            while (!isCompleted) {
                System.out.print("Enter the coordinates: ");
                var coordinates = scanner.nextLine().split(" ");

                if (coordinates.length != 2 || tryParseInt(coordinates[0]) || tryParseInt(coordinates[1])) {
                    System.out.println("You should enter numbers!");
                } else {
                    var x = Integer.parseInt(coordinates[0]);
                    var y = Integer.parseInt(coordinates[1]);

                    if (validateInterval(x) || validateInterval(y)) {
                        System.out.println("Coordinates should be from 1 to 3!");
                    } else if (arr[3 - y][x - 1] != codeNull) {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        arr[3 - y][x - 1] = player;
                        player =  player == codeX ? code0 : codeX;
                        isCompleted = true;
                    }
                }
            }
        }
        System.out.println(result);
    }

    public static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public static boolean validateInterval(int value) {
        return value != 1 && value != 2 && value != 3;
    }

    public static boolean hasPossibilities(char[][] arr) {
        for (var i = 0; i < 3; i++) {
            for (var j = 0; j < 3; j++) {
                if (arr[i][j] == codeNull) {
                    return true;
                }
            }
        }
        return false;
    }

    public static char getWinner(char[][] arr) {
        for (var i = 0; i < 3; i++) {
            if (arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2]) {
                return arr[i][0];
            }
            if (arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i]) {
                return arr[0][i];
            }
        }
        if (arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2] ||
                arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0]) {
            return arr[1][1];
        }
        return codeNull;
    }

    public static void print(char[][] arr) {
        System.out.println("---------");
        for (var i = 0; i < 3; i++) {
            System.out.print("| ");
            for (var j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(" |");
        }
        System.out.println("---------");
    }
}
