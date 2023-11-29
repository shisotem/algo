import java.util.*;

public class GraphListWeight {

    // グラフのクラス
    int numV;
    LinkedList<Edge> [] adj; // [書き換え] Integerではなく，Edgeクラスを変数にもつリストを作る．
    
    // Edgeクラスを与える[ここを書く]
        // integer型のメンバ変数node, next, weightを持つ
        // 上の３つのメンバ変数を引数として読み込み，それをインスタンスに代入するEdgeメソッドを作成
    public class Edge {
        int node;
        int next;
        int weight;
        public Edge(int node, int next, int weight) {
            this.node = node;
            this.next = next;
            this.weight = weight;
        }
    }


    public GraphListWeight(int numV) {
        this.numV = numV;
        adj = new LinkedList[numV];// 頂点数numVの数だけLinkedListを作る．
        for (int i = 0; i < numV ; i++) {
            adj[i] = new LinkedList<>(); // 初期化
        }
    }

    // addEdgeメソッドを与える[ここを書く]
        //引数はnode, next, weight 
        // 引数にnode, next, weightを持つEdgeクラスのインスタンスedgeを作る．
        // 隣接リストadjに，Edgeクラスのインスタンスedgeを加える．
    public void addEdge(int node, int next, int weight) {
        Edge edge = new Edge(node, next, weight);
        adj[node].add(edge);
    }

    public void printG(){
        for (int i = 0; i < numV ; i++) {
            LinkedList<Edge> list = adj[i]; // [書き換え]
                System.out.print(i);
            for (int j = 0; j < list.size() ; j++) {
                System.out.print(" -> " + list.get(j).next + ":" + list.get(j).weight); // [書き換え] 課題2の要件に合うように，重みも出力するようにする
            }
                System.out.println();
        }
        System.out.println();
    }
}
