import java.util.List;

public class Main {
    public static void main(String[] args) {
        MapArray map = new MapArray();
        AStarAlgorithm algorithm = new AStarAlgorithm();
        List<Node> path = algorithm.findPath(map);
        if (path == null) {
            System.out.println("Không có đường đi");
        } else {
            for (Node node :
                    path) {
                System.out.print("(" +node.getX() + ", " + node.getY() + ")  -->");
            }
        }
    }
}