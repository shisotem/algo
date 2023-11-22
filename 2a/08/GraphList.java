import java.util.*;

public class GraphList {
    int numV;
    LinkedList<Integer> [] adj; 

    public GraphList(int numV) {
        this.numV = numV;
        adj = new LinkedList[numV];// 頂点数numVerticesの数だけLinkedListを作る．
        for (int i = 0; i < numV; i++) {
            adj[i] = new LinkedList<>(); // 初期化
        }
    }

    public void addEdge(int node, int next) {  
        adj[node].add(next); // nodeを始点としたLinkedリストにnextの情報を加える．
    }

    public void printG(){
        for (int i = 0; i < numV; i++) {
            LinkedList<Integer> list = adj[i];
                System.out.print(i);
            for (int j = 0; j < list.size() ; j++) {
                System.out.print(" -> " + list.get(j));
            }
                System.out.println();
        }
    }
}