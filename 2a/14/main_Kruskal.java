import java.io.*;
import java.util.*;

public class main_Kruskal {
    public static void main(String[] args) {
        try {
            File file = new File("data.txt");
            Scanner scanner = new Scanner(file);
            List<KruskalGraph.Edge> edges = new ArrayList<>();
            int maxVertex = 0;
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                KruskalGraph.Edge edge = new KruskalGraph(0, 0).new Edge();
                edge.src = Integer.parseInt(data[0].trim());
                edge.dest = Integer.parseInt(data[1].trim());
                edge.weight = Integer.parseInt(data[2].trim());
                edges.add(edge);
                maxVertex = Math.max(maxVertex, Math.max(edge.src, edge.dest));
            }
            scanner.close();

            int V = maxVertex + 1;
            int E = edges.size();
            KruskalGraph graph = new KruskalGraph(V, E);

            for (int i = 0; i < E; i++) {
                graph.edge[i] = edges.get(i);
            }

            graph.KruskalMST();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found");
            e.printStackTrace();
        }
    }
}