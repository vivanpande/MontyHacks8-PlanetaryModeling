package planet.model;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
import static planet.model.Textures.MERCURY_MATERIAL;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    public static Sphere PlanetTemplate(double r, PhongMaterial m, int x, int y, int z, double mass) {
        Sphere p = new Sphere(r);
        p.setTranslateX(x);
        p.setTranslateY(y);
        p.setTranslateZ(z);
        p.setMaterial(m);
        p.setUserData(mass);
        return p;
    }

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setTitle("test");

        // create sphere and move it to center of screen
        Sphere test = PlanetTemplate(20, MERCURY_MATERIAL, 250, 500, 100, 3);

        // Camera object
        Camera cam = new PerspectiveCamera();

        // group - collection of items put into stage
        Group g = new Group();

        // scene - window created (?)
        Scene s = new Scene(g, 1000, 500);
        s.setFill(Color.BLACK);

        // how we are handling key presses here
        stage.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            switch (event.getCode()) {
                case MOUSE_PRESSED:
                    g.translateXProperty().set(g.getTranslateX() + 10);
                    g.translateYProperty().set(g.getTranslateY() + 10);
                    break;
                case W:
                    g.translateZProperty().set(g.getTranslateZ() + 10);
                    break;
                case S:
                    g.translateZProperty().set(g.getTranslateZ() - 10);
            }
        });
        s.setCamera(cam);

        g.getChildren().add(test);
        stage.setScene(s);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}
