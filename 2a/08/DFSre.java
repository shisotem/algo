import java.util.*;

public class DFSre {
  private int numV;
  private LinkedList<Integer> [] adj;
  private boolean done[]; // 訪問したかのbooleanリスト(サイズは頂点数)

  DFSre(LinkedList<Integer> [] adj) {
    int numV = adj.length; // ネットワークの頂点数
    boolean done[] = new boolean[numV]; // 訪問したかのbooleanリスト(サイズは頂点数)
    this.adj = adj;   // インスタンス化
    this.done = done; // インスタンス化
  }

  boolean first = true;
  // DFS recursive
  void DFSrecursive(int u) {
    // [ここを書く] 頂点uに訪問したという印をつける
    done[u] = true;
    // System.out.print(">" + u); // 訪問した箇所を記述
    if (!first) System.out.print(">");
    System.out.print(u);
    first = false;
    // [ここを書く] 頂点uに隣接する要素を取り出す(隣接頂点のリストuvEを生成)
    Iterator<Integer> iterator = adj[u].listIterator();
    while (iterator.hasNext()) { // [ここを書く] 隣接する辺がまだあるか？
      int v = iterator.next(); // [ここを書く] 隣接要素があり，それをvとする
      if (!done[v]) { // [ここを書く] まだvがまだ訪問されていないなら・・・
        DFSrecursive(v); // [ここを書く] 再帰的に探索
      }
    }
  }

}