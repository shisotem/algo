import java.util.*;

public class Dijkstra {
// フィールド変数の定義
  int numV; // ネットワークの頂点数
  int[][] adjM; //  隣接行列 (課題3で使う)
  LinkedList<GraphListWeight.Edge> [] adjL; // 隣接リスト (課題4で使う)
  boolean[] done; // 最短距離が確定済の頂点集合 X に含まれているかどうか．trueなら最短距離が確定済,falseなら未確定 
  boolean[] vertex; // 頂点の参照用
  int[] distance; // 始点からの距離を格納する配列．配列の大きさは頂点数
  int[] parent; // 親ノードを格納する配列．配列の大きさは頂点数
// フィールド変数の定義

// 課題3用のコンストラクタ 配列adjMが引数
  public Dijkstra(int numV, int[][] adjM) {
    this.adjM = adjM; // adjMはDijkstraクラスの変数

    boolean[] done = new boolean[numV]; // 配列doneの生成
    boolean[] vertex = new boolean[numV]; // 配列vertexの生成
    int[] distance = new int[numV]; // 配列distanceの生成
    int[] parent = new int[numV]; // 配列parentの生成
    this.numV = numV; // numVはDijkstraクラスの変数
    this.done = done; // doneはDijkstraクラスの変数
    this.vertex = vertex; // vertexはDijkstraクラスの変数
    this.distance = distance; // distanceはDijkstraクラスの変数
    this.parent = parent; // parentはDijkstraクラスの変数
  }
// 課題3用のコンストラクタ 配列adjMが引数（ここまで）

//////////////////////// 課題4. ///////////////////////////////
// 課題4用のコンストラクタ LinkedList adjLが引数 (課題3と同様につくってみよう)
// オーバーロードするので，名前は上のDijkstraと同じにする．
// 引数は int numV と LinkedList<GraphListWeight.Edge> [] adjL にする
    // 編集: 課題4 (コンストラクタ LinkedList adjLが引数）
    public Dijkstra(int numV, LinkedList<GraphListWeight.Edge> [] adjL) {
        this.adjL = adjL; // adjLはDijkstraクラスの変数

        boolean[] done = new boolean[numV]; // 配列doneの生成
        boolean[] vertex = new boolean[numV]; // 配列vertexの生成
        int[] distance = new int[numV]; // 配列distanceの生成
        int[] parent = new int[numV]; // 配列parentの生成
        this.numV = numV; // numVはDijkstraクラスの変数
        this.done = done; // doneはDijkstraクラスの変数
        this.vertex = vertex; // vertexはDijkstraクラスの変数
        this.distance = distance; // distanceはDijkstraクラスの変数
        this.parent = parent; // parentはDijkstraクラスの変数
    }
    // 編集: 課題4 (コンストラクタ LinkedList adjLが引数（ここまで）)
//////////////////////// 課題4. ///////////////////////////////

// dijkstraのメソッド
  public void dijkstra(int s) { // 入力は始点s(source)

//////////////////////// 課題3. ///////////////////////////////
// 以下で初期化を行います．
// 配列の初期化はArrays.fill(配列,初期化の値)が便利．
    // 編集: 課題3 始点からの距離の配列distanceの全要素をInt型で扱える範囲の最大値に初期化: 無限大はInteger.MAX_VALUEを使うと便利
    Arrays.fill(distance, Integer.MAX_VALUE);
    // 編集: 課題3 最短距離確定済頂点集合Xについて，配列doneの全要素を未確定(false)で初期化．
    Arrays.fill(done, false);
    // 編集: 課題3 参照用の配列vertexの全て全要素をtrueで初期化
    Arrays.fill(vertex, true);
    // 編集: 課題3 始点sの距離distanceを0に初期化
    distance[s] = 0;
// 初期化はここまで
//////////////////////// 課題3. ///////////////////////////////

//////////////////////// 課題3. ///////////////////////////////
// 擬似コードの while (X!=V){ の部分．(Vは全頂点の集合．Xは最短距離が確定した頂点集合)
// while(条件式){ は条件式=trueの場合，処理が行われることに注意．
// 配列Aと配列Bがが等しいかの比較はboolean型のArrays.equals(配列A,配列B)が便利．否定する場合は，!を使って，!Arrays.equals(配列A,配列B)とすると簡潔．
    while ( !Arrays.equals(done, vertex) ) { // 編集: 課題3. while文の完成．doneの中身が全てtrueになり，vertexと等しくなるまで回す．
//////////////////////// 課題3. ///////////////////////////////

//////////////////////// 課題3. ///////////////////////////////
// V-X (X以外の部分) の中で，Dの値が最小の頂点をuとする計算を実行する部分．
// 最小の距離minDとその最小距離を与える頂点u=minD_Vertexを与えるアルゴリズムを書く．
      // 編集: 課題3. 最小値を求めるので，minDは扱える最大の数で初期化．
      int minD = Integer.MAX_VALUE;
      // 編集: 課題3. minD_Vertexはあり得ない頂点の番号で初期化
      int minD_vertex = -1;
      // 編集: 課題3. for文で全頂点を探索 
      for (int i = 0; i < numV; i++) {
      // 編集: 課題3. for文で探索している頂点iが，(1) 最短距離が確定済の頂点集合 X に取り込まれておらす，(2) minDよりも距離distanceが短いなら以下の処理を行う
        if (done[i] == false && distance[i] < minD) {
      // 編集: 課題3. for文の中身1． minDをいまのdistance[i]で置き換え
          minD = distance[i];
      // 編集: 課題3. for文の中身2. minD_vertexの値をいまの頂点番号iとする
          minD_vertex = i;
      // 編集: 課題3. if文終了
        }
      // 編集: 課題3. for文終了
      }
      // 編集: 課題3. Dの値が最小の頂点uをminD_Vertexで与える
      int u = minD_vertex;
// V-X (X以外の部分) の中で，Dの値が最小の頂点をuとする計算を実行する部分．（ここまで）
//////////////////////// 課題3. ///////////////////////////////
    
//////////////////////// 課題3. ///////////////////////////////
// 擬似コードの ① X = X U {u} の部分．
      // 編集: 課題3 doneのu成分をtrueに更新
      done[u] = true;
// 擬似コードの ① X = X U {u} の部分（ここまで）
//////////////////////// 課題3. ///////////////////////////////

// 擬似コードの②の部分
// uに接続する各辺について，最短距離distance[v]と，それを与える親ノードparent[v]を求めるメソッドを使う
// 引数を配列adjMにするか，リンクリストadjLにするかを選択するが，メソッド名はfindMinDで共通．<- オーバーロード
// findMinDのメソッドの中身は後で定義
// この部分は変えない
      if (adjM != null) { findMinD(u, adjM); } // 隣接行列なら実行
      if (adjL != null) { findMinD(u, adjL); } // 隣接リストな実行
// 擬似コードの②の部分

    }
// ここまで擬似コードの while (X!=V){ の部分．

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
// print （ここは書き換えない）
// 出力: 0からvまでの距離: d
    for (int i = 0; i < distance.length; i++) {
      System.out.println(String.format(s+ "から" +i+ "までの距離:" +distance[i]));
    }
// 出力: 0からvまでの距離: d (ここまで．)

    System.out.println();
    System.out.println(String.format("始点:" + s));

// 出力: uの親ノード: v
    for (int i = 0; i < distance.length; i++) {
      if (i != s) {
      System.out.println(String.format(i+ "の親ノード: " +parent[i]));
      }
    }
// 出力: uの親ノード: v (ここまで．)
///////////////////////////////////////////////////////////////////////////////////////////////////////////////

  }

// 擬似コードの②の部分のメソッド (課題3の隣接行列の場合)
// uに接続する各辺について，最短距離distance[v]と，それを与える親ノードparent[v]を求める．
  public void findMinD(int u,  int[][] adj) { // 入力はXに取り込む頂点 (int u)と配列adj (int[][] adj)
//////////////////////// 課題3. ///////////////////////////////
      // 編集: 課題3. 全ての頂点vをfor文で回す．
      for (int v = 0; v < numV; v++) {
      // 編集: 課題3 もし，(1)頂点vの最短距離が未確定で，かつ(2)辺(u,v)がつながっているなら・・・
        if (done[v] == false && adj[u][v] != 0) {
      // 編集: 課題3. もし，距離[u]と辺(u,v)の距離の和が，距離[v]よりも短いなら・・・
          if (distance[u] + adj[u][v] < distance[v]) {
      // 編集: 課題3. 距離[v]を更新する
            distance[v] = distance[u] + adj[u][v];
      // 編集: 課題3. vの親ノードをuに更新する
            parent[v] = u;
          }
        }
      }
//////////////////////// 課題3. ///////////////////////////////
  }
// 擬似コードの②の部分のメソッド (課題3の隣接行列の場合．ここまで)

// 擬似コードの②の部分のメソッド (課題4の隣接リストの場合)
// uに接続する各辺について，最短距離distance[v]と，それを与える親ノードparent[v]を求める．
// GraphListWeight.javaのprintGの部分と課題3の上のメソッド"findMinD"を参考に残りの部分を書いてみよう．
public void findMinD(int u,  LinkedList<GraphListWeight.Edge> [] adj) { 
//////////////////////// 課題4. ///////////////////////////////
        // 編集: 課題4. 頂点uを始点とするLinkedList(adj[u])をlistとおく．LinkedList<GraphListWeight.Edge> の型．
        LinkedList<GraphListWeight.Edge> list = adj[u];
        // 編集: 課題4. for文でuを始点とするLinkedListを探索する．listの大きさまで回す．(GraphListWeight.javaのメソッドprintGを参照すると良い)
        for (int i = 0; i < list.size(); i++) {
        // 編集: 課題4. uを始点とするLinkedListから，隣接頂点の情報を取得しvと置く．(GraphListWeight.javaのメソッドprintGを参照すると良い)
            int v = list.get(i).next;
        // 編集: 課題4 もし，(1) 頂点vの最短距離が未確定で，かつ(2)その頂点の距離が短く更新されるなら・・・
            if (done[v] == false && distance[u] + list.get(i).weight < distance[v]) {
        // 編集: 課題4. 距離[v]を更新する
                distance[v] = distance[u] + list.get(i).weight;
        // 編集: 課題4. vの親ノードをuに更新する
                parent[v] = u;
            }
        }
//////////////////////// 課題4. ///////////////////////////////
}
// 擬似コードの②の部分のメソッド (課題4の隣接リストの場合．ここまで)


}
