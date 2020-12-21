package Lesson1;

import Lesson1.Classes.*;
import Lesson1.Interfaces.Obstacle;
import Lesson1.Interfaces.Participant;

import java.util.Random;

public class Main {

    static Random random = new Random();
    final static int OBSTACLE_TYPE_NUMBER = 2; //количество разновидностей препятствий
    final static String ERR_MSG = "Встретилось неизвестное препятствие!";

    public static void main(String[] args) {
        //пусть полоса состоит из случайного числа препятствий
        int obstacleNumber = random.nextInt(10) + 1;
        Participant[] participants = createParticipants(); //создадим отдельным методом массив участников
        Obstacle[] obstacles = createObstacles(obstacleNumber); //и массив препятствий. Получается полоса препятствий

        for (Participant participant : participants) { //пройдем циклом по всем участникам
            boolean flag = true; //флаг преодоления предыдущего препятствия
            for (int i = 0; i < obstacleNumber && flag; i++) {
                switch (obstacles[i].getType()) { //из класса препятствий получаем условный id для типа препятствия
                    case 1 -> flag = participant.run(obstacles[i].getSizeOfObstacle()); // 1 для беговой дорожки
                    case 2 -> flag = participant.jump(obstacles[i].getSizeOfObstacle());// 2 для стены
                    default -> System.err.println(ERR_MSG);
                }
            }
            if (flag)
                participant.showWinMessage();
        }
    }

    //для простоты создадим массив участников напрямую
    private static Participant[] createParticipants() {
        Human human = new Human("Василий Петрович");
        Cat cat = new Cat("Чубайс");
        Robot robot = new Robot("Вертер");
        return new Participant[]{human, cat, robot};
    }

    //создаем массив случайных препятствий случаного размера
    private static Obstacle[] createObstacles(int obstacleNumber) {
        Obstacle[] obstacles = new Obstacle[obstacleNumber];
        for (int i = 0; i < obstacleNumber; i++) {
            switch (random.nextInt(OBSTACLE_TYPE_NUMBER)) {
                case 0 -> obstacles[i] = new Wall();
                case 1 -> obstacles[i] = new Track();
                default -> System.err.println(ERR_MSG);
            }
        }
        return obstacles;
    }
}
