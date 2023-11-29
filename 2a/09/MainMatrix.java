import java.util.*;

public class MainMatrix {
      public static void main(String[] args) {
            int num = 7;

            GraphMatrixWeight g = new GraphMatrixWeight(num); // 隣接行列

    //////////////////////////////////////////////////////
    //  課題1. 指示されたグラフの辺を与えるコード．

        g.addEdge(0, 2, 1);
        g.addEdge(2, 0, 1);
        g.addEdge(0, 3, 2);
        g.addEdge(3, 0, 2);
        g.addEdge(2, 3, 1);
        g.addEdge(3, 2, 1);
        g.addEdge(2, 1, 2);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 3);
        g.addEdge(4, 2, 3);
        g.addEdge(1, 5, 3);
        g.addEdge(5, 1, 3);
        g.addEdge(4, 5, 2);
        g.addEdge(5, 4, 2);
        g.addEdge(5, 6, 1);
        g.addEdge(6, 5, 1);
        g.addEdge(3, 6, 1);
        g.addEdge(6, 3, 1);

    //////////////////////////////////////////////////////

            g.printG();

            Dijkstra D = new Dijkstra(num, g.adj);
            D.dijkstra(0);


        }
}
