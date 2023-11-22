import java.util.*;

public class Main2_AdjacencyList {
      public static void main(String[] args) {
            GraphListWeight g = new GraphListWeight(4);
            g.addEdge(0, 1, 4);
            g.addEdge(0, 2, 3);
            g.addEdge(1, 3, 2);
            g.addEdge(1, 2, 5);
            g.addEdge(2, 3, 7);
            g.addEdge(3, 0, 2);
            g.printG();
        }
}
