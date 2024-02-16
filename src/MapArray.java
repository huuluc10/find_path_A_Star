import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MapArray {
    private int col;
    private int row;
    private Node NodeStart;
    private Node NodeEnd;
    private Node map[][];

    public MapArray() {
        Scanner inp = new Scanner(System.in);
        System.out.print("Nhập số cột của mê cung: ");
        this.col = inp.nextInt();
        System.out.print("Nhập số hàng của mê cung: ");
        this.row = inp.nextInt();
        this.map = new Node[row][col];
        this.initMap();
        System.out.print("Vị trí hàng ô bắt đầu: ");
        int x = inp.nextInt();
        System.out.print("Vị trí cột ô bắt đầu: ");
        int y = inp.nextInt();
        setNodeStart(new Node(x,y,map[x][y].getValue()));
        System.out.print("Vị trí hàng ô kết thúc: ");
        x = inp.nextInt();
        System.out.print("Vị trí cột ô kết thúc: ");
        y = inp.nextInt();
        setNodeEnd(new Node(x,y,map[x][y].getValue()));
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public Node getNodeStart() {
        return NodeStart;
    }

    public void setNodeStart(Node nodeStart) {
        NodeStart = nodeStart;
    }

    public Node getNodeEnd() {
        return NodeEnd;
    }

    public void setNodeEnd(Node nodeEnd) {
        NodeEnd = nodeEnd;
    }

    private void initMap() {
        Scanner inp = new Scanner(System.in);
        System.out.println("Xây dựng bản đồ");
        System.out.println("0 tương ứng với đường đi, 1 tương ứng với tường");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int value = inp.nextInt();
                map[i][j] = new Node(i,j,value);
            }

        }
    }
    private void printMap() {
        System.out.println("-------------------------------------------");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print( map[i][j].getValue() + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------");
    }

    public List<Node> getNeighbors(Node current) {
        List<Node> neighbors = new ArrayList<>();
        if (current.getX() > 0 ) {
            neighbors.add(map[current.getX() - 1][current.getY()]);
        }
        if (current.getX() < row - 1 ) {
            neighbors.add(map[current.getX() + 1][current.getY()]);
        }
        if (current.getY() > 0 ) {
            neighbors.add(map[current.getX()][current.getY() - 1]);
        }
        if (current.getY() < col - 1 ) {
            neighbors.add(map[current.getX()][current.getY() + 1]);
        }
        return neighbors;
    }
}
