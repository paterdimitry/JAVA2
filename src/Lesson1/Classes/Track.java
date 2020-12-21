package Lesson1.Classes;

import Lesson1.Interfaces.Obstacle;

import java.util.Random;

public class Track implements Obstacle {

    int sizeOfObstacle;

    Random random = new Random();

    public Track(int sizeOfObstacle) {
        this.sizeOfObstacle = sizeOfObstacle;
    }

    public Track() {
        this.sizeOfObstacle = random.nextInt(400);
    }

    public int getSizeOfObstacle() {
        return sizeOfObstacle;
    }

    @Override
    public int getType() {
        return 1; //условный id препятствия
    }
}
