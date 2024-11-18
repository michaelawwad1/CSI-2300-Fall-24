module local.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;

    opens local.tictactoe to javafx.fxml;
    exports local.tictactoe;
}
