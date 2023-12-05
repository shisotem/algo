import java.util.*;

class FordFulkerson {
  
  // 課題3. 幅優先探索の部分
  boolean bfs(int Gf[][], int s, int t, int p[]) { // Gf: 残余グラフを与えるの配列，s:ソースの頂点, t:シンクの頂点, p: 拡張可能経路の親ノードを格納した配列
    // 編集: グラフの頂点数 numVを，Gfの大きさで定義
    int numV = Gf.length;
    // 編集: 頂点を訪問したかどうかのbooleanのリストを作る．(配列のサイズはnumV)
    boolean done[] = new boolean[numV];
    // 編集: 訪問したかどうかの配列．未訪問(false)で初期化． 配列の初期化はArrays.fill(配列,初期化の値)が便利．
    Arrays.fill(done, false);

    // 編集: 幅優先探索のキューQを整数を要素にもつ連結リストLinkedListで生成
    LinkedList<Integer> Q = new LinkedList<Integer>();
    // 編集: 初期化. 始点(ソース)の頂点sをキュー(queue)Qに追加
    Q.add(s);
    // 編集: 初期化. 始点(ソース)の頂点sは訪問済の印をつける．
    done[s] = true;
    // 編集: 配列pの頂点sを-1に初期化．(始点sに拡張可能経路の親ノードはないのであり得ない頂点の番号で初期化)
    p[s] = -1;

    // キューの出し入れの部分
    // 編集: while () { キューQが空でない(LinkedListのサイズが0でない)なら以下を回す．LinkedList Qのサイズは Q.size()で取得．
      while (Q.size() != 0) {
    // 編集: キューQの先頭にある頂点番号を取り出し，頂点uとする．LinkedList Qの先頭を取り出すのは，Q.poll()
        int u = Q.poll();
    // 編集: for (inv v =0 ...) 頂点vをfor文ですべて探索する
        for (int v = 0; v < numV; v++) {
    // 編集: if (...) 頂点vが未訪問，かつ辺(u,v)間の残余容量Gfが0よりも大きいなら以下を行う．
          if (done[v] == false && Gf[u][v] > 0) {
    // 編集: キューQに頂点vを追加．LinkedList Qに要素をつけるときは，Q.add() 
            Q.add(v);
    // 編集: 頂点vにつながる親ノードp[v]をuとする．
            p[v] = u;
    // 編集: 頂点vを訪問済とする
            done[v] = true;
          }
        }
      }
    // キューの出し入れの部分(ここまで)

    // 編集: return (...) 判定式 [シンクtが訪問済]==true をboolean型bfsの戻り値にする．もしこの判定式がTrueの場合，シンクtが訪問済で，拡張可能経路が存在することになる．Falseの場合は，ソースsからシンクtに辿りつけないことになり，拡張可能経路が存在しないことを意味する．つまり，最大流に到達したことになる．
    return done[t];
  }
  // 課題3. 幅優先探索の部分(ここまで)


  // 課題4. Ford-Fulkersonアルゴリズムの部分
  int fordFulkerson(int adj[][], int s, int t) { // 引数: adj: 隣接行列の配列, s:ソースの頂点, t:シンクの頂点
    // 編集: グラフの頂点数 numVを，adjの大きさで定義
    int numV = adj.length;
    int u, v; // 頂点名
    // 編集: 残余グラフの配列Gf[][]を生成
    int Gf[][] = new int[numV][numV];

    // 編集: 親ノードの配列pを作る．(サイズnumVの配列)
    int p[] = new int[numV];

    // 編集: Int型変数 max_flow の初期化  ゼロフローとする．
    int max_flow = 0;
    // 編集: 残余グラフGfの初期化．グラフの重み(adj)と等しくする．配列Aを配列Bと等しくする場合は，A = B.clone()が便利．
    Gf = adj.clone();

    // 拡張可能経路p上の最小残余容量を求める．
    // 編集: while (...) { } boolean型のメソッドbfsの戻り値がTrueなら拡張可能経路が存在するので以下を実行．Falseなら拡張可能経路が存在しないので，while文を終了．
      while (bfs(Gf, s, t, p)) {
    // 以下では，拡張可能経路p上の辺の最小残余容量(path_flow)を求める
      // 編集: 以下で，最小残余容量path_flowを求めるので，path_flowを最大の整数Integer.MAX_VALUEで初期化． 
        int path_flow = Integer.MAX_VALUE;
      // 編集: for文で，拡張可能経路を逆にたどる．Int型の頂点の変数vをシンクtから始め，拡張可能経路の親ノードを辿り，始点sについたら反復条件を終了．for (v = 初期値, 反復条件, 処理)なので，vの初期値はシンクt, 反復条件は頂点vが始点sでない限り，処理は頂点vの親ノードp[v]を次の頂点vとする．こうして，拡張可能経路を逆にたどる．
        for (v = t; v != s; v = p[v]) {
      // 編集: 頂点uを頂点vの親ノードとする．
          u = p[v];
      // 編集: 拡張可能経路の辺をたどった際，残余フローが最小値分しか結局は流せない．したがって，いまのpath_flowの値と，いまいる拡張可能経路の辺の残余フローの値を比較し，小さい方を新たにpath_flowとして更新する．
          path_flow = Math.min(path_flow, Gf[u][v]);
        }
    // 拡張可能経路p上の辺の最小残余容量(path_flow)を求める (ここまで)

      // p上の辺の最小残余容量path_flowの分だけフローmax_flowを増やす．
      // 編集: for文で，拡張可能経路を逆にたどる．Int型の頂点の変数vをシンクtから始め，拡張可能経路の親ノードを辿り，始点sについたら反復条件を終了．for (v = 初期値, 反復条件, 処理)なので，vの初期値はシンクt, 反復条件は頂点vが始点sでない限り，処理は頂点vの親ノードp[v]を次の頂点vとする．こうして，拡張可能経路を逆にたどる．
        for (v = t; v != s; v = p[v]) {
      // 編集: 頂点uを頂点vの親ノードとする．
          u = p[v];
      // 最小残余容量に従い，残余グラフGfを以下で更新する．
      // 編集: 残余グラフのGf[u][v]から，流したフロー分だけ引く
          Gf[u][v] -= path_flow;
      // 編集: 残余グラフのGf[v][u]には，頂点が逆なので，流したフロー分だけ足す．
          Gf[v][u] += path_flow;
        }

      // 編集: 最小残余容量path_flow分だけ流量が増えるので，max_flowをpath_flowだけ増やす．
        max_flow += path_flow;
      }
    // while文がここまで 

    // 編集: 戻り値はmax_flowとする
    return max_flow;
  }
  // 課題4. Ford-Fulkersonアルゴリズムの部分 (ここまで)

}