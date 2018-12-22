package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    double w = 700, h = 500;
    double x, y;

    @Override
    public void start(Stage primaryStage){
        BorderPane root = new BorderPane();
        Canvas canvas = new Canvas(w, h);
        root.setCenter(canvas);
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setStroke(Color.BLACK);
        g.setLineWidth(3);

        primaryStage.addEventHandler(MouseEvent.MOUSE_PRESSED, e->{
            x = e.getSceneX();
            y = e.getSceneY();
        });

        primaryStage.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
            g.strokeOval(x, y, event.getSceneX() - x, event.getSceneY() - y);
        });

        primaryStage.setTitle("Ellipses");
        primaryStage.setScene(new Scene(root, w, h));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
