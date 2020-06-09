package tictactoe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var str = scanner.nextLine();
        var arr = new char[3][3];

        var hasEmpty = false;
        var xIsWin = false;
        var oIsWin = false;
        var countO = 0;
        var countX = 0;
        var k = 0;
        for (var i = 0; i < 3; i++) {
            for (var j = 0; j < 3; j++) {
                arr[i][j] = str.charAt(k++);
                if (arr[i][j] == 'X') {
                    countX++;
                } else if (arr[i][j] == 'O') {
                    countO++;
                } else {
                    hasEmpty = true;
                }
                if (j == 2 && arr[i][j - 2] == arr[i][j - 1] && arr[i][j - 1] == arr[i][j] ||
                    i == 2 && arr[i - 2][j] == arr[i - 1][j] && arr[i - 1][j] == arr[i][j] ||
                    i == 2 && j == 0 && arr[i - 2][j + 2] == arr[i - 1][j + 1] && arr[i - 1][j + 1] == arr[i][j] ||
                    i == 2 && j == 2 && arr[i - 2][j - 2] == arr[i - 1][j - 1] && arr[i - 1][j - 1] == arr[i][j]
                ) {
                    if (arr[i][j] == 'X') {
                        xIsWin = true;
                    } else if (arr[i][j] == 'O') {
                        oIsWin = true;
                    }
                }
            }
        }

        System.out.println("---------");
        for (var i = 0; i < 3; i++) {
            System.out.print("| ");
            for (var j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(" |");
        }
        System.out.println("---------");

        var result = "";
        if (xIsWin && oIsWin || Math.abs(countO - countX) > 1) {
            result = "Impossible";
        } else if (!xIsWin && !oIsWin) {
            result = hasEmpty ? "Game not finished" : "Draw";
        } else if (xIsWin) {
            result = "X wins";
        } else if (oIsWin) {
            result = "O wins";
        }
        System.out.println(result);
    }
}
