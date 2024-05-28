module com.example.DuckHuntGame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.DuckHuntGame to javafx.fxml;
    exports com.example.DuckHuntGame;
    exports com.example.DuckHuntGame.control;
    opens com.example.DuckHuntGame.control to javafx.fxml;
}