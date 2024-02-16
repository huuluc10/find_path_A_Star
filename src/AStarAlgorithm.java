import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AStarAlgorithm {
    public List<Node> findPath(MapArray map) {
        List<Node> openList = new ArrayList<>();
        List<Node> closedList = new ArrayList<>();
        Map<Node, Node> cameFrom = new HashMap<>();
        openList.add(map.getNodeStart());
        while (!openList.isEmpty()) {
            Node current = getNodeLowestValue(openList, map.getNodeEnd());
            if (current.getX() == map.getNodeEnd().getX() && current.getY() == map.getNodeEnd().getY()) {
                return reconstructPath(cameFrom, current);
            }

            openList.remove(current);
            closedList.add(current);

            List<Node> neighbors = map.getNeighbors(current);
            for (Node node : neighbors) {
                if (closedList.contains(node) || node.getValue() == 1) {
                    continue;
                }

                if (!openList.contains(node)) {
                    openList.add(node);
                }
                cameFrom.put(node, current);
            }
        }
        return null;
    }

    private Node getNodeLowestValue(List<Node> openList, Node nodeEnd) {
        Node lowestFScoreNode = openList.get(0);
        int lowestFScore = getFScore(lowestFScoreNode, nodeEnd);
        for (Node node:openList
             ) {
            int nodeFScore = getFScore(node, nodeEnd);
            if (nodeFScore < lowestFScore) {
                lowestFScoreNode = node;
                lowestFScore = nodeFScore;
            }
        }
        return lowestFScoreNode;
    }

    private int getFScore(Node currentNode, Node endNode) {
        // Hàm heuristic - ước lượng chi phí từ ô hiện tại đến điểm đích
        int dx = Math.abs(currentNode.getX() - endNode.getX());
        int dy = Math.abs(currentNode.getY() - endNode.getY());
        return dx + dy;
    }

    private List<Node> reconstructPath(Map<Node, Node> cameFrom, Node current) {
        List<Node> path = new ArrayList<>();
        path.add(current);

        while (cameFrom.containsKey(current)) {
            current = cameFrom.get(current);
            path.add(0, current);
        }

        return path;
    }
}
