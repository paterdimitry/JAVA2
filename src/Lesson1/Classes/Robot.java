package Lesson1.Classes;

import Lesson1.Interfaces.Participant;

import java.util.Random;

public class Robot implements Participant {

    String name;
    int maxJump;
    int maxDistance;
    Random random = new Random();

    public Robot(String name, int maxJump, int maxDistance) {
        this.name = name;
        this.maxJump = maxJump;
        this.maxDistance = maxDistance;
    }

    public Robot(String name) {
        this.name = name;
        this.maxJump = random.nextInt(5) + 5;
        this.maxDistance = random.nextInt(900) + 100;
    }

    @Override
    public boolean run(int sizeOfObstacle) {
        if (maxDistance < sizeOfObstacle) {
            System.out.println("Робот " + name + " не смог пробежать дистанцию");
            return false;
        } else {
            System.out.println("Робот " + name + " успешно пробежал дистанцию");
            return true;
        }
    }

    @Override
    public boolean jump(int sizeOfObstacle) {
        if (maxJump < sizeOfObstacle) {
            System.out.println("Робот " + name + " не смог перепрыгнуть стену");
            return false;
        } else {
            System.out.println("Робот " + name + " успешно перепрыгнул стену");
            return true;
        }
    }

    public String getName() {
        return name;
    }

}
