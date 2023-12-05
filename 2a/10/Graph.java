public class Graph {
    public boolean adj[][]; // 隣接行列
    public int numV; // 頂点の数

    // コンストラクタ 初期化
    public Graph(int numV) {
      this.numV = numV; // インスタンス変数numVに，引数 numVの値を代入．
      adj = new boolean[numV][numV]; // 隣接行列の初期化
    }

    // 辺の追加
    public void addEdge(int i, int j) {
      adj[i][j] = true; // 頂点iと頂点j間のエッジを追加 
      adj[j][i] = true; // 頂点jと頂点i間のエッジを追加 
    }

    // 行列の表示
    public void printG() {
      StringBuilder s = new StringBuilder();
      // StringBuilder クラスは文字列を効率的に操作でき、文字列の結合や変更などの操作を高速に行える．
      for (int i = 0; i < numV; i++) {
        s.append(i + ": "); // 頂点の番号を追加
        // 隣接行列の各要素に対して処理
        for (boolean j : adj[i]) {
          s.append((j ? 1 : 0) + " "); // boolean型のjがtrueなら1を，falseなら0を返し，文字列に追加
        }
        s.append("\n"); // 行末に改行を追加
      }
      System.out.println(s); // 構築した文字列をコンソールに出力
    }

  }

