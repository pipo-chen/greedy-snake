public class SnakeField {

    public static final int WIDTH = 20;
    public static final int HEIGHT = 8;

    public static Snake snake;
    public static Food food;

    public SnakeField() {
    }

    public SnakeField(Snake snake) {
        this.snake = snake;
        food = new Food();
    }

    //绘制地图
    public void printField() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (i == 0 || i == HEIGHT - 1 || j == 0 || j == WIDTH - 1) {
                    System.out.print("*");
                } else if (snake.contains(new Node(j, i))) {
                    System.out.print("o");
                } else if (Food.contains(new Node(j, i))) {
                    System.out.print("x");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
