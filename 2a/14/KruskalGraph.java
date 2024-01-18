import java.util.*;

public class KruskalGraph {
    int V, E;
    Edge edge[];

    KruskalGraph(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    int find(int subsets[], int i) {
        if (subsets[i] != i)
            subsets[i] = find(subsets, subsets[i]);
        return subsets[i];
    }

    void KruskalMST() {
        Edge result[] = new Edge[V];
        int e = 0;
        int i = 0;
        for (i = 0; i < V; ++i)
            result[i] = new Edge();

        Arrays.sort(edge);

        int parent[] = new int[V];

        for (int v = 0; v < V; ++v)
            parent[v] = v;

        i = 0;

        while (e < V - 1) {
            Edge next_edge = edge[i++];

            int x = find(parent, next_edge.src);
            int y = find(parent, next_edge.dest);

            if (x != y) {
                result[e++] = next_edge;
                parent[x] = y;
            }
        }

        System.out.println("最小全域木の辺");
        int totalWeight = 0;
        for (i = 0; i < e; ++i) {
            System.out.println(result[i].src + " - " + result[i].dest);
            totalWeight += result[i].weight;
        }
        System.out.println("重みの総和" + totalWeight);
    }
}