package Lesson1.Classes;

import Lesson1.Interfaces.Participant;

import java.util.Random;

public class Cat implements Participant {

    String name;
    int maxJump;
    int maxDistance;
    Random random = new Random();

    public Cat(String name, int maxJump, int maxDistance) {
        this.name = name;
        this.maxJump = maxJump;
        this.maxDistance = maxDistance;
    }

    public Cat(String name) {
        this.name = name;
        this.maxJump = random.nextInt(10) + 20;
        this.maxDistance = random.nextInt(200) + 100;
    }

    @Override
    public boolean run(int sizeOfObstacle) {
        if (maxDistance < sizeOfObstacle) {
            System.out.println("Кот " + name + " не смог пробежать дистанцию");
            return false;
        } else {
            System.out.println("Кот " + name + " успешно пробежал дистанцию");
            return true;
        }
    }

    @Override
    public boolean jump(int sizeOfObstacle) {
        if (maxJump < sizeOfObstacle) {
            System.out.println("Кот " + name + " не смог перепрыгнуть стену");
            return false;
        } else {
            System.out.println("Кот " + name + " успешно перепрыгнул стену");
            return true;
        }
    }

    public String getName() {
        return name;
    }

}
