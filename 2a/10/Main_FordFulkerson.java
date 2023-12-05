import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Main_FordFulkerson {
  public static void main(String[] args) throws java.lang.Exception {

    // 課題1. 重み付き有向グラフのtxtファイルを読み込む．
    GraphMatrixWeight g = new GraphMatrixWeight(6);
    String filePath = "data.txt";

    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        // ファイルの各行を読み込む
        while ((line = br.readLine()) != null) {
            // カンマで分割
            String[] values = line.split(", ");
            // x座標、y座標、関数の値に対する処理
            int u = Integer.parseInt(values[0]);
            int v = Integer.parseInt(values[1]);
            int w = Integer.parseInt(values[2]);
            // ここで取得した値に対する処理を行う
            g.addEdge(u, v, w);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    g.printG();
    // 課題1. 重み付き有向グラフのtxtファイルを読み込む． (ここまで)
    

    // 課題3用 幅優先探索が動くかの確認用
    // 課題3では，以下のコメントアウトを外すこと
    FordFulkerson m = new FordFulkerson();

    int p[] = new int[g.adj.length];
    m.bfs(g.adj, 0, 2, p);
    for (int i = 0; i < g.adj.length; i++){
      System.out.println(i + "の親ノード:" + p[i]);
    }
    // 課題3用 幅優先探索が動くかの確認用 (ここまで)

    System.out.println();

    // 課題4用 Ford-Fulkerson法の動作
    // 課題４では，以下の二行のコメントアウトを外すこと
    int maxflow = m.fordFulkerson(g.adj, 0, 5);
    System.out.println("最大流は" + maxflow);
    // 課題4用 Ford-Fulkerson法の動作 (ここまで)

  }
}
