import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Food {
    public static Set<Node> foods;
    private static final int TOTAL_FOOD = 2;

    public Food() {
        this.foods = new HashSet<Node>();
        generate_food();
    }

    public static void generate_food() {
        Random random = new Random();
        while (foods.size() <= TOTAL_FOOD) {
            int x = random.nextInt(SnakeField.WIDTH - 1) + 1;
            int y = random.nextInt(SnakeField.HEIGHT - 1) + 1;
            Node cur = new Node(x,y);
            if (!SnakeField.snake.contains(cur)) {
                foods.add(cur);
            }
        }
    }

    public static boolean contains(Node node) {
        Iterator iterator = foods.iterator();
        while (iterator.hasNext()) {
            Node cur = (Node) iterator.next();
            if (cur.equals(node)) {
                return true;
            }
        }
        return false;
    }

    public static void eat(Node node) {
        foods.remove(node);
        generate_food();
    }


}
