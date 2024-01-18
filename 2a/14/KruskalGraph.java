import java.util.*;

class KruskalGraph {
  int vertices;  // グラフの頂点数
  int edges;     // グラフの辺数
  Edge[] edge;   // グラフの辺を表すEdgeクラスの配列


  // Kruskalクラスのコンストラクタ
  // グラフの頂点数と辺数を受け取り、必要な配列を初期化する
  KruskalGraph(int v, int e) {
      vertices = v;
      edges = e;

  // Edgeクラスのedgeを初期化
      edge = new Edge[edges];
      // 各辺のために新しいEdgeオブジェクトを生成し、配列に格納する
      for (int i = 0; i < e; ++i)
          edge[i] = new Edge();
// このような初期化を行わないと、edge 配列が null のままであるため、
// 配列の各要素にアクセスする際に NullPointerExceptionの例外が発生する可能性がある．
// それを防ぐため．
// for ループで edge 配列の各要素に新しい Edge オブジェクトを生成
// これにより、各要素は異なる Edge インスタンスを参照し、
// null ではなく適切に初期化された状態になる．
  }

// 編集: Edgeクラスの実装
//
//
// 編集: Edgeクラスの実装

// 編集: subetクラスの実装 変数 parent, rankを持つ
//
//
// 編集: subsetクラスの実装



  int find(subset subsets[], int i) {
    //編集: findメソッドの実装
    //
    //
    //編集: findメソッドの実装
  }

  void Union(subset subsets[], int x, int y) {
    //編集: Unionメソッドの実装
    //
    //
    //編集: Unionメソッドの実装

  }

  void KruskalAlgo() {
    Edge result[] = new Edge[vertices]; // 頂点の数だけ，Edgeクラスのresultを作る．
  
// 編集: subsetクラスのsubsets配列を初期化．サイズは頂点数
// KruskalGraphのedgeの初期化を参考にする
//
//
// 編集: subsetクラスのsubsets配列を初期化．サイズは頂点数

// 編集: Edge型のedgeの重みに対するソート
//
// 編集: Edge型のedgeの重みに対するソート

// 編集: すべての頂点vについて初期化を行う
// 初期化 1. 各頂点の親ノードは自身
// 初期化 2. 各頂点のランクは0
//
//
// 編集: すべての頂点vについて初期化を行う

    // 編集: iv = 0で初期化．頂点番号に対応し，全頂点まで探索する
    // 編集: ie = 0で初期化．辺のインデックスに対応
    while (iv < vertices - 1) {  // while文で，全頂点が探索するまで実行する
      //編集: Edge型のnext_edgeを生成する
      // 編集: ie番目のedgeをnext_edgeとする
      // 編集: next_edgeの１つの頂点の根をxとする
      // 編集: next_edgeの他方の頂点の根をyとする
      // 編集: if文: next_edgeの辺の頂点同士の根(親)xとyが異なったら
      // 編集: iv番目のresult[]にnext_edgeを入れる．
      // 編集: xとyをUnionで統合する
      // 編集: ivを1つ増やす
      // 編集: if文 ここまで
      // 編集: ieを１つ増やす
    } // while文 ここまで

// 編集: 要件を満たすように出力する result[]の中に最小全域木の辺の情報が入っている
// 
//
// 編集: 要件を満たすように出力する
  
}

}