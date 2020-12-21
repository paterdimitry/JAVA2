package Lesson1.Classes;

import Lesson1.Interfaces.Participant;

import java.util.Random;


public class Human implements Participant {

    String name;
    public int maxJump;
    public int maxDistance;
    Random random = new Random();

    public Human(String name, int maxJump, int maxDistance) {
        this.name = name;
        this.maxJump = maxJump;
        this.maxDistance = maxDistance;
    }

    public Human(String name) {
        this.name = name;
        this.maxJump = random.nextInt(10) + 5;
        this.maxDistance = random.nextInt(400) + 100;
    }

    @Override
    public boolean run(int sizeOfObstacle) {
        if (maxDistance < sizeOfObstacle) {
            System.out.println("Человек " + name + " не смог пробежать дистанцию");
            return false;
        } else {
            System.out.println("Человек " + name + " успешно пробежал дистанцию");
            return true;
        }
    }

    @Override
    public boolean jump(int sizeOfObstacle) {
        if (maxJump < sizeOfObstacle) {
            System.out.println("Человек " + name + " не смог перепрыгнуть стену");
            return false;
        } else {
            System.out.println("Человек " + name + " успешно перепрыгнул стену");
            return true;
        }
    }

    public String getName() {
        return name;
    }
}
