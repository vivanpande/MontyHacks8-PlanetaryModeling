module planet.model {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens planet.model to javafx.fxml;
    exports planet.model;
}
