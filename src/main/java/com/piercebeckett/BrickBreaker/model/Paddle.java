package com.piercebeckett.BrickBreaker.model;

public class Paddle {
    static final int BASE_SPEED = 50;
    static final int BASE_LENGTH = 50;
    static final int STARTING_X_POS = 0;

    private int length;
    private int xPos;
    private int speed;

    public Paddle(){
        resetLocation();
        resetLength();
        resetSpeed();
    }

    public void increaseSpeed(){this.speed += 10;}

    public void decreaseSpeed(){this.speed -= 10;}

    public void resetSpeed(){this.speed = BASE_SPEED;}

    public void increaseLength(){this.length += 10;}

    public void decreaseLength(){this.length -= 10;}

    public void resetLength(){this.length = BASE_LENGTH;}

    public void resetLocation(){this.xPos = STARTING_X_POS;}

}
