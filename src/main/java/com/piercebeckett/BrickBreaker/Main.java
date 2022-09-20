package com.piercebeckett.BrickBreaker;

import com.piercebeckett.BrickBreaker.action.Gameplay;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application{

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 640, 480);
        stage.setTitle("Brick Breaker");
        stage.setScene(scene);
        stage.setResizable(false);
        new Gameplay(root);
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }

}
