import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


class Main1_AdjacencyMatrixRead {
  public static void main(String args[]) {

    GraphMatrixWeight g = new GraphMatrixWeight(4);

    String filePath = "data_sample1.txt";

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
            g.addEdge(u,v, w);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

      g.printG();

    }
}
