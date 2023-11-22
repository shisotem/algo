import java.util.*;

public class BFS {
  boolean done[]; // 訪問したかのbooleanリスト(サイズは頂点数)
  LinkedList<Integer> Q = new LinkedList(); // キューを連結リストで生成

  public BFS(LinkedList<Integer> [] adj, int s) {
    int numV = adj.length; // ネットワークの頂点数
    boolean done[] = new boolean[numV]; // 訪問したかのbooleanリスト(サイズは頂点数)

    //////////////////////////////////////////////////////
    boolean first = true;
    done[s] = true; //頂点sは訪問した印をつける
    Q.add(s); // 頂点sをQ という名前のQueueに入れ初期化
    while (Q.size() != 0) { // Q という名前のQueueが空でない
      int u = Q.poll();// Q という名前のQueueの先頭から頂点uを取得し，削除
      if (!first) System.out.print(">"); // 次を指す矢印を出力
      System.out.print(u); // Q という名前のQueueから取り出した頂点を書き出す．
      first = false;
      Iterator<Integer> iterator = adj[u].listIterator(); // 頂点uの隣接要素を取り出す
      while (iterator.hasNext()) { // 隣接要素がまだあるか？
        int v = iterator.next(); // 隣接要素があり，それをvとする
        if (!done[v]) { // まだvが訪問されていないなら・・・
          done[v] = true; // vに訪問したという印をつける
          Q.add(v); // vをQ という名前のQueueに入れる．
        }
      }
    }
    //////////////////////////////////////////////////////

    System.out.println(""); 
  }
}