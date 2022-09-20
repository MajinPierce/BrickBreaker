package com.piercebeckett.BrickBreaker.action;

import com.piercebeckett.BrickBreaker.model.Paddle;
import javafx.scene.Group;

public class Gameplay {

    public Gameplay(Group root){
        drawPaddle(root);
    }

    public void drawPaddle(Group root){
        Paddle paddle = new Paddle();
        root.getChildren().add(paddle);
    }

}
