import java.util.Iterator;
import java.util.LinkedList;

public class Snake {

    LinkedList<Node> snakes;
    private int dir;

    public static final int LEFT = -1;
    public static final int RIGHT = 1;
    public static final int UP = -2;
    public static final int DOWN = 2;

    public Snake() {

    }

    public Snake(Node node) {
        this.snakes = new LinkedList<>();
        this.snakes.add(node);
        this.dir = UP;
    }

    public boolean contains(Node node) {
        Iterator iterator = this.snakes.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(node)) {
                return true;
            }

        }
        return false;
    }

    public void step(int dir) {
        //判断移动的方向 即可计算
        if (dir + this.dir != 0) {
            Node curNode = snakes.getFirst();

            int next_x = curNode.getX(), next_y = curNode.getY();

            if (next_x < 1 || next_x > SnakeField.WIDTH - 1 || next_y < 1 || next_y > SnakeField.HEIGHT - 1) {
                System.out.println("撞墙了");
                return;
            }

            switch (dir) {
                case LEFT:
                    next_x--;
                    break;

                case RIGHT:
                    next_x++;
                    break;

                case UP:
                    next_y--;
                    break;

                case DOWN:
                    next_y++;
                    break;

                default:
                    System.out.println("Error Direction");
                    break;
            }

            Node nextHead = new Node(next_x, next_y);
            snakes.addFirst(nextHead);

            if (Food.contains(nextHead))
                Food.eat(nextHead);
            else
                snakes.removeLast();

            this.dir = dir;
        }

    }



}
