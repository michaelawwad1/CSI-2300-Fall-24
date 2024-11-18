package local.tictactoe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class App extends Application {
    private static final int SIZE = 5;
    private final Button[][] board = new Button[SIZE][SIZE];
    private boolean playerXTurn = true;

    @SuppressWarnings("exports")
    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                Button cell = new Button();
                cell.setFont(Font.font(24));
                cell.setMinSize(100, 100);
                cell.setOnAction(e -> handleCellClick(cell));
                board[row][col] = cell;
                gridPane.add(cell, col, row);
            }
        }

        Scene scene = new Scene(gridPane, SIZE * 100, SIZE * 100);
        primaryStage.setTitle("5x5 TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleCellClick(Button cell) {
        if (!cell.getText().isEmpty()) {
            return;
        }

        cell.setText(playerXTurn ? "X" : "O");

        if (checkWin()) {
            showAlert((playerXTurn ? "Player X" : "Player O") + " wins!");
            resetBoard();
            return;
        }

        if (isBoardFull()) {
            showAlert("It's a draw!");
            resetBoard();
            return;
        }

        playerXTurn = !playerXTurn;
    }

    private boolean checkWin() {
        String currentPlayerSymbol = playerXTurn ? "X" : "O";

        for (int i = 0; i < SIZE; i++) {
            if (checkLine(currentPlayerSymbol, board[i])
                    || checkLine(currentPlayerSymbol, getColumn(i))
                    || checkDiagonal(currentPlayerSymbol, true)
                    || checkDiagonal(currentPlayerSymbol, false)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkLine(String symbol, Button[] line) {
        int count = 0;
        for (Button cell : line) {
            if (cell.getText().equals(symbol)) {
                count++;
                if (count == SIZE) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

    private boolean checkDiagonal(String symbol, boolean isMainDiagonal) {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            int row = i;
            int col = isMainDiagonal ? i : SIZE - 1 - i;

            if (board[row][col].getText().equals(symbol)) {
                count++;
                if (count == SIZE) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

    private Button[] getColumn(int colIndex) {
        Button[] column = new Button[SIZE];
        for (int i = 0; i < SIZE; i++) {
            column[i] = board[i][colIndex];
        }
        return column;
    }

    private boolean isBoardFull() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void resetBoard() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                board[row][col].setText("");
            }
        }
        playerXTurn = true;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void setRoot(String string) {
        throw new UnsupportedOperationException("Unimplemented method 'setRoot'");
    }
}