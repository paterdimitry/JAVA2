package Lesson1.Classes;

import Lesson1.Interfaces.Obstacle;

import java.util.Random;

public class Wall implements Obstacle {

    int sizeOfObstacle;

    Random random = new Random();

    public Wall(int sizeOfObstacle) {
        this.sizeOfObstacle = sizeOfObstacle;
    }

    public Wall() {
        this.sizeOfObstacle = random.nextInt(20);
    }

    public int getSizeOfObstacle() {
        return sizeOfObstacle;
    }

    @Override
    public int getType() {
        return 2; //условный id препятствия
    }
}
