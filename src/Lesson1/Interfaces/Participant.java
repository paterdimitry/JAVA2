package Lesson1.Interfaces;

public interface Participant {

    int maxJump = 0;
    int maxDistance = 0;
    String name = "";

    boolean run(int sizeOfObstacle);

    boolean jump(int sizeOfObstacle);

    String getName();

    //при прохождении всей полосы препятствий выдается победное сообщение
    default void showWinMessage() {
        System.out.println("<<< " + getName() + " прошел всю полосу препятствий! >>>");
    }
}
