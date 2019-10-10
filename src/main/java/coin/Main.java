package coin;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.*;

import java.io.File;

public class Main extends Application {
    public static String language = "english";
    public static Stage mainStage;
    private static StackPane root;

    @Override
    public void start(Stage primaryStage) throws Exception{
        root = FXMLLoader.load(getClass().getResource("/main.fxml"));
        Scene mainScene = new Scene(root);
        //mainScene.getStylesheets().add("styles/dark-theme.css");

        primaryStage.setTitle("sport data parser-20191010-2.12-v2.3");
        primaryStage.setScene(mainScene);

        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX(primaryScreenBounds.getMinX());
        primaryStage.setY(primaryScreenBounds.getMinY());
//        primaryStage.setWidth(primaryScreenBounds.getWidth());
//        primaryStage.setHeight(primaryScreenBounds.getHeight());
        primaryStage.setWidth(1280);
        primaryStage.setHeight(960);

        primaryStage.setMinWidth(320);
        primaryStage.setMinHeight(240);
        primaryStage.show();

        Main.mainStage = primaryStage;
    }

    public static String getLanguage() {
        return language;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
