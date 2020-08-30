import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Snake snake = new Snake(new Node(2,1));
        snake.snakes.add(new Node(2,2));
        snake.snakes.add(new Node(2,3));

        SnakeField snakeField = new SnakeField(snake);

        Scanner sc = new Scanner(System.in);

        while (true) {
            snakeField.printField();
            String order = sc.next();
            if (order.equalsIgnoreCase("w")) {
                snake.step(Snake.UP);
            } else if (order.equalsIgnoreCase("s")) {
                snake.step(Snake.DOWN);
            } else if (order.equalsIgnoreCase("a")) {
                snake.step(Snake.LEFT);
            } else if (order.equalsIgnoreCase("d")) {
                snake.step(Snake.RIGHT);
            } else {
                continue;
            }
        }
    }
}
