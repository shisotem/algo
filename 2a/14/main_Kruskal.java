
class main_Kruskal {
  public static void main(String[] args) 

// data.txtを読み込む部分を加筆してください．


      KruskalGraph G=new KruskalGraph(numv, nume); // numv: 頂点数, nume: 辺数
      // 以下は src0, dest0, weight0をArrayList<Integer>とし，読み込んだデータを格納している例．

      for (int i = 0; i < nume; ++i) {
        G.edge[i].src = src0.get(i);
        G.edge[i].dest = dest0.get(i);
        G.edge[i].weight = weight0.get(i);
      }

     G.KruskalAlgo();


  }
}