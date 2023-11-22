import java.util.*;

public class Main0_AdjacencyList {
      public static void main(String[] args) {
            GraphList g = new GraphList(4);
            g.addEdge(0, 1);
            g.addEdge(0, 2);
            g.addEdge(1, 3);
            g.addEdge(1, 2);
            g.addEdge(2, 3);
            g.addEdge(3, 0);
            g.printG();
        }
}
